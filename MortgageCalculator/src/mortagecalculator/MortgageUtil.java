package mortagecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MortgageUtil {

    public static BigDecimal getBigDecimal(String text) {

        final Scanner sc = new Scanner(System.in);
        BigDecimal tempBigDecimal;

        do {
            System.out.print(text + ": ");
            while (!sc.hasNextBigDecimal()) {
                System.out.println("Invalid input");
                sc.next();
            }
            tempBigDecimal = sc.nextBigDecimal();
        } while (tempBigDecimal.doubleValue() <= 0);
        tempBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return tempBigDecimal;
    }

    public static int getInt(String text) {

        final Scanner sc = new Scanner(System.in);
        int tempInt;

        do {
            System.out.print(text + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input");
                sc.next();
            }
            tempInt = sc.nextInt();
        } while (tempInt <= 0);
        return tempInt;
    }

    public static double getDouble(String text) {

        final Scanner sc = new Scanner(System.in);
        double tempDouble;

        do {
            System.out.print(text + ": ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input");
                sc.next();
            }
            tempDouble = sc.nextDouble();
        } while (tempDouble <= 0);
        return tempDouble;
    }
}
