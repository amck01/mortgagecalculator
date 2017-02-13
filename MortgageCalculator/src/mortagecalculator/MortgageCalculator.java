package mortagecalculator;

import java.util.Scanner;

public class MortgageCalculator {
	
	public void run() {
		
		asciiBanner();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Loan amount: ");
		int principal = sc.nextInt();
		System.out.print("\n");
		
		System.out.print("Interest rate: ");
		float interestRate = sc.nextFloat();
		System.out.print("\n");
		
		System.out.print("Term In Years: ");
		int termInYears = sc.nextInt();
		System.out.print("\n");
		
		Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
		
		//System.out.println(mortgage.calculateFullAmount());
		System.out.printf("%.2f", mortgage.calculateFullAmount());
	}
	
	public void asciiBanner() {
		System.out.println("#     #                                                               ");
		System.out.println("##   ##  ####  #####  #####   ##    ####  ######                      ");
		System.out.println("# # # # #    # #    #   #    #  #  #    # #                           ");
		System.out.println("#  #  # #    # #    #   #   #    # #      #####                       ");
		System.out.println("#     # #    # #####    #   ###### #  ### #                           ");
		System.out.println("#     # #    # #   #    #   #    # #    # #                           ");
		System.out.println("#     #  ####  #    #   #   #    #  ####  ######                      ");
		System.out.println(" #####                                                                ");
		System.out.println("#     #   ##   #       ####  #    # #        ##   #####  ####  #####  ");
		System.out.println("#        #  #  #      #    # #    # #       #  #    #   #    # #    # ");
		System.out.println("#       #    # #      #      #    # #      #    #   #   #    # #    # ");
		System.out.println("#       ###### #      #      #    # #      ######   #   #    # #####  ");
		System.out.println("#     # #    # #      #    # #    # #      #    #   #   #    # #   #  ");
		System.out.println(" #####  #    # ######  ####   ####  ###### #    #   #    ####  #    # ");
		System.out.println("\n---------------------------------------------------------------------\n");
	}
}
