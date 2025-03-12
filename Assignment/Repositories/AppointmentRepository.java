package Assignment.Repositories;

import Assignment.Objects.Appointment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentRepository {
    public static List<Appointment> appointments = new ArrayList<>();
    public static int appointmentID;
    private final File file = new File("src/main/java/Assignment/data/appointment.txt");

    public void retrieveAppointment(){
        appointments.clear();
//        List<Appointment> appointments = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Appointment appointmentDetail = new Appointment();
                String[] arr = reader.nextLine().split(",");
                appointmentDetail.apptID = arr[0];
                appointmentDetail.date = arr[1];
                appointmentDetail.startTime = arr[2];
                appointmentDetail.endTime = arr[3];
                appointmentDetail.purpose = arr[4];
                appointmentDetail.studentID = arr[5];
                appointmentDetail.lecturerID = arr[6];
                appointmentDetail.status = arr[7];
                appointmentDetail.studentFeed = arr[8];
                appointmentDetail.lecturerFeed = arr[9];
                appointmentDetail.studentRescheduleReason = arr[10];
                appointmentID = Integer.parseInt(appointmentDetail.apptID.replace("A", ""));
                appointments.add(appointmentDetail);
            }
//            System.out.println(appointmentID + 1);
//            System.out.println(appointments.size());
        } catch (IOException io) {
            Logger.getLogger(AppointmentRepository.class.getName()).log(Level.SEVERE, null, io);
        }
    }

    public List<Appointment> getAppointment() {
        return appointments;
    }

    public void addAppointment(String[] args) {
        appointmentID++;
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.printf("A%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", appointmentID, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
            System.out.println("appointment added");
        } catch (IOException io) {
            Logger.getLogger(AppointmentRepository.class.getName()).log(Level.SEVERE, null, io);
        }
    }

    public void modifyAppointment(List<Appointment> arr) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Appointment line : arr) {
                writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", line.apptID, line.date, line.startTime, line.endTime, line.purpose, line.studentID, line.lecturerID, line.status, line.studentFeed, line.lecturerFeed, line.studentRescheduleReason);

            }
            System.out.println("status change");
        } catch (IOException io) {
            Logger.getLogger(AppointmentRepository.class.getName()).log(Level.SEVERE, null, io);
        }
    }
//
//    public static void main(String[] args) {
//        AppointmentRepository.retrieveAppointment();
//        System.out.println(appointmentID);
//        System.out.println(appointments.size());
//    }
}

