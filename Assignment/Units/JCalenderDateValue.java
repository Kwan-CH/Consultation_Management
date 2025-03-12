package Assignment.Units;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class JCalenderDateValue {
    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame();
        JDateChooser calender = new JDateChooser();

        frame.add(calender);

        calender.getDateEditor().setEnabled(false);

        IDateEditor dateEditor = calender.getDateEditor();
        JTextFieldDateEditor txtFld = (JTextFieldDateEditor) dateEditor;
        txtFld.setDisabledTextColor(Color.black);

        calender.setDateFormatString("d-M-yyyy");

        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        calender.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (calender.getDate() == null) {
                    System.out.println("No date chosen");
                } else {
                    Date today = new Date();
                    Date yesterday = new Date(today.getTime() - (1000 * 3600 * 24));
                    String date = ((JTextField) calender.getDateEditor().getUiComponent()).getText();
                    String[] dateChosen = date.split("-");
                    if (calender.getDate().before(yesterday)) {
                        System.out.println("You are selecting past date");
                    } else {
                        System.out.println(Arrays.toString(dateChosen));
                        System.out.println("Day " + Integer.parseInt(dateChosen[0]));
                        System.out.println("Month " + Integer.parseInt(dateChosen[1]));
                        System.out.println("Year " + Integer.parseInt(dateChosen[2]));
                    }
                }
            }
        });

    }
}