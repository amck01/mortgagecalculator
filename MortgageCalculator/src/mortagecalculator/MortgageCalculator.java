package mortagecalculator;

import java.io.IOException;
import java.math.BigDecimal;

public class MortgageCalculator {

    MortgageCalculatorDAO dao;

    public MortgageCalculator() {
        dao = new MortgageCalculatorDAO();
    }

    public void go() {
        asciiBanner();
        menu();
        System.exit(0);
    }

    public void menu() {
        final String[] menuItems = { "Calculate Mortgage Payment", "View Previous Mortgage Calculation", "Exit" };
        int menuChoice;
        
        do {
            for (int i = 1; i <= menuItems.length; i++) {
                System.out.println(i + ": " + menuItems[i - 1]);
            }
            menuChoice = MortgageUtil.getInt("\nChoice");
            if (menuChoice == 1) {
                calculateMortgage();
            } else if (menuChoice == 2) {
                viewPreviousMortgage();
            } else if (menuChoice < 1 && menuChoice > menuItems.length){
                System.out.println("\nInvalid selection.\n");
            } 
        } while (menuChoice != 3);
    }

    public void calculateMortgage() {
        final BigDecimal principal = MortgageUtil.getBigDecimal("Principal");
        final double interestRate = MortgageUtil.getDouble("Interest rate");
        final int termInYears = MortgageUtil.getInt("Term In Years");

        final Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
        System.out.printf("\nMonthly payment will be $%.2f.\n\n", mortgage.calculateMonthlyPayment());
        dao.saveMortgage(mortgage);
    }

    public void viewPreviousMortgage() {
        final int mortgageId = MortgageUtil.getInt("Enter ID");
        final Mortgage previousMortgage = dao.getMortgage(mortgageId);

        if (previousMortgage.getPrincipal() == null && previousMortgage.getInterestRate() == 0
                && previousMortgage.getTermInYears() == 0) {
            System.out.println("\nInvalid ID\n");
        } else {
            System.out.println("\n" + previousMortgage.toString() + "\n");
        }
    }

    public void redirectToMenu() {
        System.out.println("Press Enter to return to Menu...");
        try {
            System.in.read();
        } catch (final IOException e) {
            e.printStackTrace();
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
