/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment.GUI;

import Assignment.Objects.Appointment;
import Assignment.Repositories.AppointmentRepository;
import Assignment.Repositories.UserRepository;
import Assignment.Objects.User;
import Assignment.status.STATUS;
import table.TableCustom;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author Hp
 */
public class feedbackGUI extends javax.swing.JFrame {

    /**
     * Creates new form student_signedIn
     */
    public feedbackGUI(String accountName, String accountID) {
        initComponents(accountName, accountID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(String accountName, String accountID) {

        jSeparator2 = new javax.swing.JSeparator();
        history = new javax.swing.JLabel();
        feedback = new javax.swing.JLabel();
        dashboard = new javax.swing.JLabel();
        appointment = new javax.swing.JLabel();
        timeSlot_consult = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        picHolder = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackTable = new javax.swing.JTable();
        feedbackLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        feedbackInput = new javax.swing.JTextArea();
        selectedAppoinment = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        isStudent = accountID.startsWith("S");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        history.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        history.setText("History");
        history.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMouseClicked(evt, accountName, accountID);
            }
        });

        feedback.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        feedback.setText("Feedback");
        feedback.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedbackMouseClicked(evt, accountName, accountID);
            }
        });

        dashboard.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dashboard.setText("Dashboard");
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt, accountName, accountID);
            }
        });

        appointment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        appointment.setText("Appointment");
        appointment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentMouseClicked(evt, accountName, accountID);
            }
        });

        timeSlot_consult.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        String text = isStudent ? "Consult" : "Time Slot";
        timeSlot_consult.setText(text);
        timeSlot_consult.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        timeSlot_consult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultMouseClicked(evt, accountName, accountID);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        name.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        name.setText(accountName);

        id.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        id.setText(accountID);

        ImageIcon profilePic = new ImageIcon("src/main/java/Assignment/image/profile_pic_50x50.png");
        picHolder.setIcon(profilePic);
        picHolder.setText("");

        ImageIcon exitPic = new ImageIcon("src/main/java/Assignment/image/sign_out.png");
        exit.setIcon(exitPic);
        exit.setText("");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });

        // if accountID startswith L, lecturer is signed in, displayed Student title, vice versa
        String role = accountID.startsWith("L") ? "Student" : "Lecturer";
        feedbackTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Appointment ID", "Date", "Time", role, "Feedback"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane1.setViewportView(feedbackTable);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        DefaultTableModel model = (DefaultTableModel) feedbackTable.getModel();
        feedbackTable.getTableHeader().setResizingAllowed(false);

        feedbackTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedbackTableMouseClicked(evt);
            }
        });

        for (Appointment appointment : appointmentList) {
            boolean isComplete = appointment.status.equals(String.valueOf(STATUS.Complete));
            if (!isComplete) {
                continue;
            }
            if (isStudent && accountID.equals(appointment.studentID)) {
                String lecturerName = findName(appointment.lecturerID, userList);
                model.addRow(new Object[]{appointment.apptID, appointment.date, String.format("%s - %s", appointment.startTime, appointment.endTime), lecturerName, appointment.lecturerFeed.replace("$COMMA$", ",")});
            } else if (!isStudent && accountID.equals(appointment.lecturerID)) {
                String studentName = findName(appointment.studentID, userList);
                model.addRow(new Object[]{appointment.apptID, appointment.date, String.format("%s - %s", appointment.startTime, appointment.endTime), studentName, appointment.studentFeed.replace("$COMMA$", ",")});
            }
        }

        feedbackLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        feedbackLabel.setText("Feedback:");

        jLabel2.setText("* Please select an appointment to give your feedback");

        feedbackInput.setColumns(20);
        feedbackInput.setRows(5);
        jScrollPane2.setViewportView(feedbackInput);

        selectedAppoinment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedAppoinment.setText(" ");


        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt, accountID);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(picHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(exit)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(picHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(name)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(id))))
                                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(dashboard)
                                                        .addComponent(history)
                                                        .addComponent(feedback)
                                                        .addComponent(appointment)
                                                        .addComponent(timeSlot_consult)))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectedAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(95, 100, 101))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(feedbackLabel)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(submitButton))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(timeSlot_consult, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(selectedAppoinment))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(feedbackLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(submitButton)))
                                .addGap(5, 5, 5))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {
        int selection = JOptionPane.showConfirmDialog(rootPane, "Are you sure want to logout...");
        if (selection == JOptionPane.YES_OPTION) {
            loginGUI login = new loginGUI();
            login.setVisible(true);
            this.dispose();
        }
    }

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt, String accountName, String accountID) {
        // TODO add your handling code here:
        dashboardGUI obj = new dashboardGUI(accountName, accountID);
        obj.setVisible(true);
        this.dispose();
    }

    private void historyMouseClicked(java.awt.event.MouseEvent evt, String accountName, String accountID) {
        // TODO add your handling code here:
        historyGUI obj = new historyGUI(accountName, accountID);
        obj.setVisible(true);
        this.dispose();

    }

    private void feedbackMouseClicked(java.awt.event.MouseEvent evt, String accountName, String accountID) {
        // TODO add your handling code here:
        feedbackGUI obj = new feedbackGUI(accountName, accountID);
        obj.setVisible(true);
        this.dispose();
    }

    private void appointmentMouseClicked(java.awt.event.MouseEvent evt, String accountName, String accountID) {
        // TODO add your handling code here:
        appointmentGUI obj = new appointmentGUI(accountName, accountID);
        obj.setVisible(true);
        this.dispose();
    }

    private void consultMouseClicked(java.awt.event.MouseEvent evt, String accountName, String accountID) {
        if (isStudent) {
            studentConsultGUI obj = new studentConsultGUI(accountName, accountID);
            obj.setVisible(true);
        } else {
            lecturerSetApptGUI obj = new lecturerSetApptGUI(accountName, accountID);
            obj.setVisible(true);
        }
        this.dispose();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt, String accountID) {
        if (feedbackTable.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(rootPane, "Please select an appointment to submit the feedback", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (Appointment appointment : appointmentList) {
            if (appointment.apptID.equals(feedbackTable.getValueAt(feedbackTable.getSelectedRow(), 0)) && isStudent) {
                appointment.studentFeed = feedbackInput.getText().replace(",", "$COMMA$");
            } else if (appointment.apptID.equals(feedbackTable.getValueAt(feedbackTable.getSelectedRow(), 0)) && !isStudent) {
                appointment.lecturerFeed = feedbackInput.getText().replace(",", "$COMMA$");
            }
        }

        appointmentRepo.modifyAppointment(appointmentList);
        JOptionPane.showMessageDialog(rootPane, "Feedback submitted");
    }

    private void feedbackTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        selectedAppoinment.setText((feedbackTable.getValueAt(feedbackTable.getSelectedRow(), 0)) + " Selected");
        for (Appointment appointment : appointmentList) {
            if (appointment.apptID.equals(feedbackTable.getValueAt(feedbackTable.getSelectedRow(), 0)) && isStudent) {
                feedbackInput.setText(appointment.studentFeed.replace("$COMMA$", ","));
            } else if (appointment.apptID.equals(feedbackTable.getValueAt(feedbackTable.getSelectedRow(), 0)) && !isStudent) {
                feedbackInput.setText(appointment.lecturerFeed.replace("$COMMA$", ","));
            }
        }
    }

    private String findName(String accountID, List<User> userList) {
        for (User users : userList) {
            if (users.accountID.equals(accountID)) {
                return (users.accountName);
            }
        }
        return "Cannot find record";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(feedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feedbackGUI("", "S1").setVisible(true);
//                new appointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel appointment;
    private javax.swing.JLabel timeSlot_consult;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel feedback;
    private javax.swing.JTextArea feedbackInput;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JTable feedbackTable;
    private javax.swing.JLabel history;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel picHolder;
    private javax.swing.JLabel selectedAppoinment;
    private javax.swing.JButton submitButton;
    private final UserRepository userRepo = new UserRepository();
    private final AppointmentRepository appointmentRepo = new AppointmentRepository();
    private List<User> userList = userRepo.getUsers();
    private List<Appointment> appointmentList = appointmentRepo.getAppointment();
    private boolean isStudent;
    // End of variables declaration
}
