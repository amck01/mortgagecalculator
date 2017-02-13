package mortagecalculator;

public class MortgageCalculator {
	
	public void run() {
		
		asciiBanner();
		
		double principal = MortgageUtil.getDouble("Principal");
		
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
