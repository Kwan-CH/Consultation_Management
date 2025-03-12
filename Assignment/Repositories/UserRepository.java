package Assignment.Repositories;

import Assignment.Objects.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {
    File file = new File("src/main/java/Assignment/data/users.txt");
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] arr = reader.nextLine().split(",");
                User credential = new User();
                credential.accountID = arr[0];
                credential.accountName = arr[1];
                credential.email = arr[2];
                credential.password = arr[3];
                users.add(credential);
            }
        } catch (IOException io) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, io);
        }
        return users;
    }

    public void addUser(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.printf("%s,%s,%s,%s\n", args[0], args[1], args[2], args[3]);
        } catch (IOException io) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, io);
        }
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
////        getUsers();
//        while (true) {
//            String password = scanner.next();
//            try {
//                MessageDigest digest = MessageDigest.getInstance("SHA-256");
//                var hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//                String encoded = Base64.getEncoder().encodeToString(hash);
//                System.out.println(encoded);
//            } catch (NoSuchAlgorithmException e) {
//                System.out.println("error");
//            }
//        }
//    }
}
