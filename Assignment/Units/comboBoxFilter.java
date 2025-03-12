package Assignment.Units;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class comboBoxFilter {
    static boolean edit = true;
    static JComboBox<String> comboBox = new JComboBox<>();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ComboBox Search Filter Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            // List of items to add to the combo box
            List<String> items = new ArrayList<>();
            items.add("Apple");
            items.add("Banana");
            items.add("Orange");
            items.add("Mango");
            items.add("Grapes");
            items.add("Blueberry");

            comboBox = new JComboBox<>(items.toArray(new String[0]));
            comboBox.setEditable(true);

            JTextField editorComponent = (JTextField) comboBox.getEditor().getEditorComponent();
            editorComponent.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    edit = true;
                    String input = editorComponent.getText();
                    comboBox.hidePopup();
                    comboBox.removeAllItems();

                    // Add items matching user input to combo box
                    for (String item : items) {
                        if (item.toLowerCase().contains(input.toLowerCase())) {
                            comboBox.addItem(item);
                        }
                    }

                    comboBox.showPopup();
                    editorComponent.setText(input);
                    edit = false;
                }
            });



            frame.add(comboBox);
            frame.setSize(400, 200);
            frame.setVisible(true);
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() != null && !edit) {
                    System.out.println("Selected item: " + comboBox.getSelectedItem().toString());
                }
            }
        });
    }
}
