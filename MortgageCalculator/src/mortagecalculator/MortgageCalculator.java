package mortagecalculator;

import java.math.BigDecimal;
import java.sql.SQLException;

public class MortgageCalculator {
	
	public void go() throws ClassNotFoundException, SQLException {
		
		asciiBanner();
		
		new MortgageCalculatorDAO().readMortgage();
		
		menu();
	}

	public void menu() {
		String[] menuItems = {"Calculate Mortgage Payment", "View Previous Calculation", "Exit"};
		for (int i = 1; i <= menuItems.length; i++) {
			System.out.println(i + ": " + menuItems[i-1]);
		}
		int menuChoice = MortgageUtil.getInt("\nChoice");
		
		switch(menuChoice) {
			case 1: calculateMortgage();
			case 3: System.exit(0);
		}
	}
	
	public void calculateMortgage() {
		BigDecimal principal = MortgageUtil.getBigDecimal("Principal");
		
		double interestRate = MortgageUtil.getDouble("Interest rate");
		
		int termInYears = MortgageUtil.getInt("Term In Years");
		
		Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
		
		//System.out.println(mortgage.calculateFullAmount());
		System.out.printf("%.2f", mortgage.calculateMonthlyPayment());
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
