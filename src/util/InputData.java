package util;

import java.util.Scanner;

/**
 * InputData
 */
public class InputData {

    public static Integer inputInteger(String msg, Scanner scanner){
        while (true) {
            System.out.println(msg);
            try {
                return Integer.parseInt(scanner.next());
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Invalid number");
            }
        }
    }

    public static Float inputFloat(String msg, Scanner scanner){
        while (true) {
            System.out.println(msg);
            try {
                return Float.parseFloat(scanner.next());
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Invalid number");
            }
        }
    }

    public static String inputString(String msg, Scanner scanner){
            System.out.println(msg);
            return scanner.next();
    }
}