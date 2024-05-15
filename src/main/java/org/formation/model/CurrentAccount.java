package org.formation.model;

public class CurrentAccount extends BankAccount{
	
	private double overDrawn=1000;
	

	public CurrentAccount(String numAccount, double solde, String openDate, String card) {
		super(numAccount, solde, openDate, card);
		// TODO Auto-generated constructor stub
	}


	public double getOverDrawn() {
		return overDrawn;
	}


	public void setOverDrawn(double overDrawn) {
		this.overDrawn = overDrawn;
	}

	
}
