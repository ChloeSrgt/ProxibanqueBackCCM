package org.formation.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class savingAccount extends BankAccount{

	private double payRate = 0.03;
	
	public savingAccount(String numAccount, double solde, String openDate) {
		super(numAccount, solde, openDate);
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	
	

}
