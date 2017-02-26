package mortagecalculator;

import java.sql.SQLException;

public class MortgageCalculatorApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MortgageCalculator mortgageCalculator = new MortgageCalculator();
		mortgageCalculator.go();
	}

}
