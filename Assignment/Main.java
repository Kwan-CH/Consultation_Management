package Assignment;

import Assignment.GUI.loginGUI;

import javax.swing.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1 -> System.out.println("Correct");
            case 2-> System.out.println("False");
        }
    }
}
