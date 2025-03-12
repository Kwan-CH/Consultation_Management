package Assignment.Objects;

import Assignment.GUI.dashboardGUI;
import Assignment.Repositories.AppointmentRepository;
import Assignment.Repositories.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    public String accountID, accountName, email, password;
    AppointmentRepository appointmentRepo = new AppointmentRepository();

    public boolean login(String emailInput, String passwordInput) {
        try {
            UserRepository obj = new UserRepository();
            List<User> users = obj.getUsers();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            var hash = digest.digest(passwordInput.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            for (User user : users) {
                if (user.email.equals(emailInput) && user.password.equals(encoded)) {
                    appointmentRepo.retrieveAppointment();
                    Appointment.setExpired(appointmentRepo.getAppointment());
                    dashboardGUI validLogin = new dashboardGUI(user.accountName, user.accountID);
                    validLogin.setVisible(true);
                    return true;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean register(String NameInput, String emailInput, String passwordInput, String MasterPasswordInput) {
        int studentCode = 1, lecturerCode = 1;
        String encoded = "";
        UserRepository repo = new UserRepository();
        List<User> users = repo.getUsers();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            var hash = digest.digest(passwordInput.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
            for (User user : users) {
                if (user.accountID.startsWith("S")) {
                    studentCode++;
                } else {
                    lecturerCode++;
                }
                if (user.email.equals(emailInput) || !emailInput.contains("@")) {
//                    SignedInGUI validLogin = new SignedInGUI(user.name, user.ID);
//                    validLogin.setVisible(true);
                    return false;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        if (MasterPasswordInput.isEmpty()) {
            repo.addUser(new String[]{"S" + studentCode, NameInput.strip(), emailInput.strip(), encoded});
        } else if (MasterPasswordInput.equals("1234")) {
            repo.addUser(new String[]{"L" + lecturerCode, NameInput.strip(), emailInput.strip(), encoded});

        } else {
            return false;
        }
        return true;
    }
}
