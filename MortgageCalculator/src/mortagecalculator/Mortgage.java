package mortagecalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class Mortgage {
	
	private BigDecimal principal;
	private double interestRate;
	private int termInYears;
	private int termInMonths;
	private double monthlyPayment;
	
	public Mortgage() {}
	
	public Mortgage(BigDecimal principal, double interestRate, int termInYears) {
		this.principal = principal;
		this.interestRate = interestRate;
		this.termInYears = termInYears;
		this.termInMonths = termInYears * 12;
		this.monthlyPayment = calculateMonthlyPayment().doubleValue();
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

	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayments(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public BigDecimal calculateMonthlyPayment() {
		return new BigDecimal(this.principal.doubleValue() * ((((this.interestRate / 100) / 12) * Math.pow((1 + ((this.interestRate / 100) / 12)), this.termInMonths) /
				(Math.pow(1 + ((this.interestRate / 100) / 12), this.termInMonths) - 1))));
	}
	
	public double generatePaymentSchedule() {
		return getMonthlyPayment();
		
	}

	@Override
	public String toString() {
		return "Mortgage [principal=" + principal + ", interestRate=" + interestRate + ", termInYears=" + termInYears
				+ ", termInMonths=" + termInMonths + ", monthlyPayments=" + "]";
	}
}
