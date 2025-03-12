/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment.GUI;

import Assignment.Objects.Appointment;
import Assignment.Repositories.AppointmentRepository;
import Assignment.status.STATUS;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import table.TableCustom;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Hp
 */
public class lecturerSetApptGUI extends javax.swing.JFrame {

    /**
     * Creates new form lecturerSetAppt
     */
    public lecturerSetApptGUI(String accountName, String accountID) {
        initComponents(accountName, accountID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(String accountName, String accountID) {

        jSeparator1 = new JSeparator();
        appointment = new JLabel();
        jPanel2 = new JPanel();
        picHolder = new JLabel();
        name = new JLabel();
        id = new JLabel();
        exit = new JLabel();
        history = new JLabel();
        dashboard = new JLabel();
        timeSlot_consult = new JLabel();
        jSeparator2 = new JSeparator();
        feedback = new JLabel();
        jPanel1 = new JPanel();
        calender = new JDateChooser();
        startTime = new JComboBox<>();
        endTime = new JComboBox<>();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        apptTable = new JTable();
        submit = new JButton();

        jScrollPane1 = new JScrollPane(apptTable);

        isStudent = accountID.startsWith("S");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setForeground(new Color(0, 0, 0));

        appointment.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        appointment.setText("Appointment");
        appointment.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        appointment.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                appointmentMouseClicked(evt, accountName, accountID);
            }
        });

        jPanel2.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));


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


        history.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        history.setText("History");
        history.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        history.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                historyMouseClicked(evt, accountName, accountID);
            }
        });

        dashboard.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        dashboard.setText("Dashboard");
        dashboard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        dashboard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                dashboardMouseClicked(evt, accountName, accountID);
            }
        });

        timeSlot_consult.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        String text = isStudent ? "Consult" : "Time Slot";
        timeSlot_consult.setText(text);
        timeSlot_consult.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        timeSlot_consult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                consultMouseClicked(evt, accountName, accountID);
            }
        });
        jSeparator2.setForeground(new Color(0, 0, 0));
        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        feedback.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        feedback.setText("Feedback");
        feedback.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        feedback.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                feedbackMouseClicked(evt, accountName, accountID);
            }
        });

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanel1.setForeground(new Color(255, 255, 255));

        startingTime = new String[]{"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        startTime.setModel(new DefaultComboBoxModel<>(startingTime));

        endingTime = new String[]{"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        endTime.setModel(new DefaultComboBoxModel<>(endingTime));

        jLabel1.setText("Date:");

        jLabel2.setText("Start Time:");

        jLabel3.setText("End Time:");


        apptTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Date", "Start Time", "End Time", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(apptTable);
        DefaultTableModel model = (DefaultTableModel) apptTable.getModel();
        for (Appointment appointment : appointmentList) {
            if (appointment.lecturerID.equals(accountID)) {
//                System.out.printf("%s, %s\n", appointment.lecturerID, accountID);
                model.addRow(new Object[]{appointment.date, appointment.startTime, appointment.endTime, appointment.status});
            }
        }
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);

        calender.getDateEditor().setEnabled(false);

        IDateEditor dateEditor = calender.getDateEditor();
        JTextFieldDateEditor txtFld = (JTextFieldDateEditor) dateEditor;
        txtFld.setDisabledTextColor(Color.black);

        calender.setDateFormatString("d-M-yyyy");

        calender.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                getSelectedDate(evt, accountID);
            }
        });

//        calender.getJCalendar().setPreferredSize(new Dimension(300, 250));
//        calender.getJCalendar().setFont(new Font("Segoe UI", 0, 8));

        startingTime = new String[]{"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        startTime.setModel(new javax.swing.DefaultComboBoxModel<>(startingTime));
//        jComboBox1.setEnabled(false);
//        jComboBox1.getEditor().getEditorComponent().setForeground(Color.black);
        endingTime = new String[]{"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        endTime.setModel(new javax.swing.DefaultComboBoxModel<>(endingTime));

        submit.setText("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitActionPerformed(evt, accountID);
            }
        });

// Force the scrollbars to always be displayed

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(calender, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(startTime, 0, 87, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(endTime, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(endTime)
                                        .addComponent(calender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(startTime))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(picHolder, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(exit)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(picHolder, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(name)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(id))))
                                .addGap(9, 9, 9))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(dashboard)
                                                        .addComponent(history)
                                                        .addComponent(feedback)
                                                        .addComponent(appointment)
                                                        .addComponent(timeSlot_consult)))
                                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(submit))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)) // Adjust size as needed
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(dashboard, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(history, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(feedback, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(appointment, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(timeSlot_consult, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(submit))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE) // Adjust height as needed
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void getSelectedDate(PropertyChangeEvent evt, String accountID) {
        DefaultTableModel model = (DefaultTableModel) apptTable.getModel();
        if (calender.getDate() != null) {
            choseDate = ((JTextField) calender.getDateEditor().getUiComponent()).getText();
//            System.out.println(choseDate);
            model.setRowCount(0);
            for (Appointment appointment : appointmentList) {
                if (appointment.date.equals(choseDate) && appointment.lecturerID.equals(accountID)) {
                    model.insertRow(0, new Object[]{appointment.date, appointment.startTime, appointment.endTime, appointment.status});
                }
            }
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

    private void submitActionPerformed(java.awt.event.ActionEvent evt, String accountID) {
        // validate appointment slot
        Appointment obj = new Appointment();

        DefaultTableModel model = (DefaultTableModel) apptTable.getModel();
        LocalTime startChose = LocalTime.parse((String) startTime.getSelectedItem());
        LocalTime endChose = LocalTime.parse((String) endTime.getSelectedItem());
        obj.validAppointment(accountID, choseDate, startChose, endChose);
        appointmentRepo.
        System.out.println(obj.validTime);
        if (!obj.valid_Date) {
            JOptionPane.showMessageDialog(rootPane, "You are selecting past date, please select again", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!obj.validTime) {
            JOptionPane.showMessageDialog(rootPane, "There is an appointment time clash, please try again", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Accepted");
            model.insertRow(0, new Object[]{choseDate, startChose.toString(), endChose.toString(), String.valueOf(STATUS.Available)});
        }
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
            java.util.logging.Logger.getLogger(lecturerSetApptGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lecturerSetApptGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lecturerSetApptGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lecturerSetApptGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lecturerSetApptGUI("Alpha", "L4").setVisible(true);
//                new appointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel appointment;
    private javax.swing.JTable apptTable;
    private com.toedter.calendar.JDateChooser calender;
    private javax.swing.JLabel timeSlot_consult;
    private javax.swing.JLabel dashboard;
    private javax.swing.JComboBox<String> endTime;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel feedback;
    private javax.swing.JLabel history;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel picHolder;
    private javax.swing.JComboBox<String> startTime;
    private javax.swing.JButton submit;
    public String choseDate;
    private String[] startingTime, endingTime;
    private final AppointmentRepository appointmentRepo = new AppointmentRepository();
    private List<Appointment> appointmentList = appointmentRepo.getAppointment();
    private boolean isStudent;
    // End of variables declaration
}
