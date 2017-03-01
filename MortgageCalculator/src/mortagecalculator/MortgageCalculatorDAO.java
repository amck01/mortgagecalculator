package mortagecalculator;

import java.sql.*;
import java.lang.*;
import java.math.BigDecimal;

public class MortgageCalculatorDAO {
	
	Connection db;
	
	public MortgageCalculatorDAO() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
			
			System.out.println("Missing PostgreSQL JDBC Driver");
			e.printStackTrace();
		
		}
		
		try {
		
			db = DriverManager.getConnection("jdbc:postgresql://localhost/mortgagecalculator","postgres","postgres");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		if(db != null) {
			System.out.println("JDBC Success!");
		}
	}
	
	public Mortgage getMortgage(int mortgageId) {
		
		BigDecimal principal = null;
		double interestRate = 0;
		int termInYears = 0;
		
		try {
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM mortgages WHERE mortgage_id = " + mortgageId);
			
			while (rs.next()) {
				principal = rs.getBigDecimal(1);
				interestRate = rs.getDouble(2);
				termInYears = rs.getInt(3);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		if (principal == null && interestRate == 0 && termInYears == 0) {
			
			return new Mortgage();
		
		} else {
		
			Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
			return mortgage;
		}
					
	}
	
	public void saveMortgage(Mortgage mortgage) {
		BigDecimal principal = mortgage.getPrincipal();
		double interestRate = mortgage.getInterestRate();
		int termInYears = mortgage.getTermInYears();
		
		try {
			PreparedStatement st = db.prepareStatement("INSERT INTO mortgages (principal, interest_rate, term_in_years) VALUES (" + principal + ", " + interestRate + ", " + termInYears + ")");
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
