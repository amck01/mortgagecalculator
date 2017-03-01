package mortagecalculator;

import java.math.BigDecimal;
import java.sql.SQLException;

public class MortgageCalculator {
	
	MortgageCalculatorDAO dao;
	
	public MortgageCalculator() {
		
		dao = new MortgageCalculatorDAO();
		
	}
	
	public void go() {
		
		asciiBanner();
		
		/*
		System.out.println(dao.getMortgage(1).toString());
		dao.saveMortgage(new Mortgage(new BigDecimal(50000), 7.0, 20));
		System.out.println(dao.getMortgage(2).toString());
		System.out.println(dao.getMortgage(3).toString());
		*/
		
		menu();
	}

	public void menu() {
		
		String[] menuItems = {"Calculate Mortgage Payment", "View Previous Mortgage Calculation", "Exit"};
		for (int i = 1; i <= menuItems.length; i++) {
			System.out.println(i + ": " + menuItems[i-1]);
		}
		int menuChoice = MortgageUtil.getInt("\nChoice");
		
		switch(menuChoice) {
			case 1: calculateMortgage();
			case 2: viewPreviousMortgage();
			case 3: System.exit(0);
		}
		
		menu();
	}
	
	public void calculateMortgage() {
		
		BigDecimal principal = MortgageUtil.getBigDecimal("Principal");
		
		double interestRate = MortgageUtil.getDouble("Interest rate");
		
		int termInYears = MortgageUtil.getInt("Term In Years");
		
		Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
		
		//System.out.println(mortgage.calculateFullAmount());
		System.out.printf("%.2f", mortgage.calculateMonthlyPayment());
	}
	
	public void viewPreviousMortgage() {
		
		int mortgageId = MortgageUtil.getInt("Enter ID");
		
		Mortgage previousMortgage = dao.getMortgage(mortgageId);
		
		if (previousMortgage.getPrincipal() == null && previousMortgage.getInterestRate() == 0 && previousMortgage.getTermInYears() == 0) {
		
			System.out.println("\nInvalid ID\n");
		
		} else {
		
			System.out.println(previousMortgage.toString() + "/n");
		
		}
		
		menu();
		
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
