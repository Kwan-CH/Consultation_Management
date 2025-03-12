package Assignment.Objects;

import Assignment.Repositories.AppointmentRepository;
import Assignment.status.STATUS;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Appointment {
    public String apptID, date, startTime, endTime, purpose, studentID, lecturerID, status, studentFeed, lecturerFeed, studentRescheduleReason;

    public boolean valid_Date, validTime=true;

    static AppointmentRepository appointmentRepo = new AppointmentRepository();
    static List<Appointment> appointmentList = appointmentRepo.getAppointment();

    // check for incomplete or still available appointment and set to expired, ready to be deleted
    public static void setExpired(List<Appointment> appointmentList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        //get current time
        long timeElapsed = System.currentTimeMillis() / 1000;
        int hour = (int) ((timeElapsed / 3600) % 24) + 8;
        int minute = (int) ((timeElapsed / 60) % 60);

        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);

        for (Appointment line : appointmentList) {
            //parse it date and time retrieved from txt file
            LocalDate parseDate = LocalDate.parse(line.date, formatter);
            LocalTime parseTime = LocalTime.parse(line.startTime);
            LocalTime currentTime = LocalTime.of(hour, minute);
            if (!line.status.equals(String.valueOf(STATUS.Complete)) && !line.status.equals(String.valueOf(STATUS.Decline))) {
                if (parseDate.isBefore(yesterday)) {
                    line.status = String.valueOf(STATUS.Expired);
                } else if (parseDate.equals(today) && parseTime.isBefore(currentTime)) {
                    line.status = String.valueOf(STATUS.Expired);
                }
            }
        }
        appointmentRepo.modifyAppointment(appointmentList);
    }

    public void isValid_Date(String accountID, LocalDate choseDate) {
            LocalDate today = LocalDate.now();
            valid_Date = !choseDate.isBefore(today);
        }


    public void isValidTime(String accountID, LocalDate choseDate, DateTimeFormatter formatter, LocalTime choseStart, LocalTime choseEnd) {
        System.out.println(validTime);
        if (valid_Date) {
            System.out.println(accountID);
            for (Appointment appointment : appointmentList) {
                if (!appointment.lecturerID.equals(accountID)){
                    continue;
                }
                LocalDate appointmentDate = LocalDate.parse(appointment.date, formatter);
                if (choseDate.equals(appointmentDate)) {
                    boolean isOverlap = choseStart.isBefore(LocalTime.parse(appointment.endTime)) && choseEnd.isAfter(LocalTime.parse(appointment.startTime));
                    boolean isContain = choseStart.isBefore(LocalTime.parse(appointment.startTime)) && choseEnd.isAfter(LocalTime.parse(appointment.endTime));
                    validTime = !(isOverlap || isContain);
                    break;
                }else{
                    validTime = true;
                }
            }
        }
    }

    public void validAppointment(String accountID, String choseDate, LocalTime choseStart, LocalTime choseEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate dateChose = LocalDate.parse(choseDate, formatter);
        isValid_Date(accountID, dateChose);
        isValidTime(accountID, dateChose, formatter, choseStart, choseEnd);
        if (valid_Date && validTime){
            appointmentRepo.addAppointment(new String[]{choseDate, choseStart.toString(), choseEnd.toString(),
                    "-", "-", accountID, String.valueOf(STATUS.Available), "-", "-", "-"});
        }
    }
}
