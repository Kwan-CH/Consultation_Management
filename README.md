# Consultation_Management
Java based consultation management for Asia Pacific University

* It can be only run in local machine, data storing also in local machine

It features with SHA-256 password hashing for security login, a user friendly UI for the student to book consultation appointment wth lecturers, lecturer side also provides a UI for them to update their available time slot for the students to refer.

Appointment made will be verified by the lecturer before accepting it, and can be reject with a provided reason.

Students are also be able to modify their appointment by changing the date and time, but it will be based on the available time slot of the lecturer that they had booked previously.

This system also allows both of the user to provide their feedback for their appointment, as well as a history section for them to see past completed appointment and the feedback provided.

API's that have been integrated is the JCalendar for a direct and simple way to allow the lecturer to set the available time slot, this can help to avoid any point of human error, another API used is table-custom for a modern design of each JTable used in the system, this is only to replace the original design provided by javax.swing for a better look

* In order for the API to work, you need to configure the project structure to import the API's .jar file into the project before you start running the code

**Development Environment**
Utilise the drag and drop UI element feature in Apache NetBeans for a faster UI development, and IntelliJ IDEA for the backend logic. The reason of using two platforms is by the limitation in Apache Netbeans that does not allow developer to edit the auto-generated code during the drag and drop UI element phase.

**Steps to Use**
1. Run the Main.java file to start the whole system
2. You need to register your own student and lecturer account; for lecturer registration, a password is needed, which is '1234', I put it this simple is just not confuse myself during testing
3. Then you can start to explore the system 😁
