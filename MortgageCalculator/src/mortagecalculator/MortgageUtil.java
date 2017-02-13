package mortagecalculator;

import java.util.Scanner;

public class MortgageUtil {
	
	public static double getDouble(String text) {
		
		Scanner sc = new Scanner(System.in);
		double tempDouble;
		
		do {
			System.out.print(text + ": ");
			while(!sc.hasNextDouble()) {
				System.out.println("Invalid input");
				sc.next();
			}
			tempDouble = sc.nextDouble();
		} while (tempDouble <= 0);
		return tempDouble;
	}
	
	public static int getInt(String text) {
		
		Scanner sc = new Scanner(System.in);
		int tempInt;
		
		do {
			System.out.print(text + ": ");
			while(!sc.hasNextInt()) {
				System.out.println("Invalid input");
				sc.next();
			}
			tempInt = sc.nextInt();
		} while (tempInt <= 0);
		return tempInt;
	}
}
