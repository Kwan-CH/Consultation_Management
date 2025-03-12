package Assignment.Units;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class validTimeChose {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(150, 200);

        long timeElapsed = System.currentTimeMillis() / 1000;
        int hour = (int) ((timeElapsed / 3600) % 24) + 8;
        int minute = (int) ((timeElapsed / 60) % 60);

        String[] option = {"08:30", "09:00", "09:30", "10:00", "10:40", "13:00", "14:00", "13:35", "13:33", "18:00"};
        JComboBox<String> comboBox = new JComboBox<>(option);
        frame.add(comboBox);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chose = (String) comboBox.getSelectedItem();
                LocalTime currentTime = LocalTime.of(hour, minute);
                if (chose != null) {
                    LocalTime choseTime = LocalTime.parse(chose);
                    if (choseTime.isBefore(currentTime)) {
                        System.out.println("past time");
                    } else {
                        System.out.println("acceptable");
                    }
                }
            }
        });
    }
}
