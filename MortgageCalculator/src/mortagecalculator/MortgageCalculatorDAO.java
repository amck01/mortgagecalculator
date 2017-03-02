package mortagecalculator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MortgageCalculatorDAO {

    Connection db;

    public MortgageCalculatorDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (final ClassNotFoundException e) {
            System.out.println("Missing PostgreSQL JDBC Driver");
            e.printStackTrace();
        }

        try {
            db = DriverManager.getConnection("jdbc:postgresql://localhost/mortgagecalculator", "postgres", "postgres");
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        if (db != null) {
            System.out.println("JDBC Success!");
        }
    }

    public Mortgage getMortgage(int mortgageId) {
        BigDecimal principal = null;
        double interestRate = 0;
        int termInYears = 0;
        final String query = "SELECT * FROM mortgages WHERE mortgage_id = ?";

        try {
            final PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, mortgageId);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                principal = rs.getBigDecimal(1);
                interestRate = rs.getDouble(2);
                termInYears = rs.getInt(3);
            }

            rs.close();
            st.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        if (principal == null && interestRate == 0 && termInYears == 0) {
            return new Mortgage();
        } else {
            final Mortgage mortgage = new Mortgage(principal, interestRate, termInYears);
            return mortgage;
        }

    }

    public void saveMortgage(Mortgage mortgage) {
        final BigDecimal principal = mortgage.getPrincipal();
        final double interestRate = mortgage.getInterestRate();
        final int termInYears = mortgage.getTermInYears();

        try {
            final PreparedStatement st = db
                    .prepareStatement("INSERT INTO mortgages (principal, interest_rate, term_in_years) VALUES ("
                            + principal + ", " + interestRate + ", " + termInYears + ")");
            st.executeUpdate();
            st.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
