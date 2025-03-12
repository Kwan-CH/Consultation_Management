package Assignment.Units;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class timeClashCheck {
    static boolean clashCheck() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> appt = new ArrayList<>();
        File file = new File("src/appt.txt");
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()){
            appt.add(reader.nextLine().split(","));
        }
        for (String[] line: appt){
            System.out.println(Arrays.toString(line));
        }
        System.out.print("Start: ");
        int start = scanner.nextInt();
        System.out.print("End: ");
        int end = scanner.nextInt();
        for (String[] line: appt){
            if(Integer.parseInt(line[0]) < end && start < Integer.parseInt(line[1])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (!clashCheck()){
            System.out.println("No Clash");
        }else{
            System.out.println("Clash");
        }

    }
}
