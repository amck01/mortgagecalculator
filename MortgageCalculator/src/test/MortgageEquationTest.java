package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import mortagecalculator.Mortgage;

public class MortgageEquationTest {

	@Test
	public void test() {
		Mortgage mortgage = new Mortgage(new BigDecimal(30000), 5.0, 30);
		int monthlyPayment = mortgage.calculateMonthlyPayment().intValue();
		assertEquals(161, monthlyPayment);
	}

}
