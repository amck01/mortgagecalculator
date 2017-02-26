package mortagecalculator;

import java.sql.*;
import java.lang.*;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(db != null) {
			System.out.println("JDBC Success!");
		}
	}
	
	public void readMortgage() {
		try {
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM mortgages");
			while (rs.next()) {
				System.out.println("Column 1 returned ");
				System.out.println(rs.getString(1));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
