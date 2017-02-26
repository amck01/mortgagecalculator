package mortagecalculator;

import java.io.Serializable;
import java.math.BigDecimal;

public class Mortgage {
	
	private BigDecimal principal;
	private double interestRate;
	private int termInYears;
	private int termInMonths;
	private double[] monthlyPayments;
	
	public Mortgage() {}
	
	public Mortgage(BigDecimal principal, double interestRate, int termInYears) {
		this.principal = principal;
		this.interestRate = interestRate;
		this.termInMonths = termInYears * 12;
	}
	
	
	//Getters and setters
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getTermInYears() {
		return termInYears;
	}
	public void setTermInYears(int termInYears) {
		this.termInYears = termInYears;
	}
	public int getTermInMonths() {
		return termInMonths;
	}
	
	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public double[] getMonthlyPayments() {
		return monthlyPayments;
	}
	public void setMonthlyPayments(double[] monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

	public BigDecimal calculateMonthlyPayment() {
		return new BigDecimal(this.principal.doubleValue() * (((this.interestRate / 12) * Math.pow((1 + (this.interestRate / 12)), this.termInMonths) /
				(Math.pow(1 + (this.interestRate / 12), this.termInMonths) - 1))));
	}
	
	public double[] generatePaymentSchedule() {
		return monthlyPayments;
		
	}
}
