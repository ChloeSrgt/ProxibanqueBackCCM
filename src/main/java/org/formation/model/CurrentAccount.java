package org.formation.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Current account")
public class CurrentAccount extends BankAccount{
	
	private double overDrawn=1000;
	

	public CurrentAccount() {
		
	}
	
	public CurrentAccount(String numAccount, double solde, String openDate, Card card) {
		super(numAccount, solde, openDate, card);
	}


	public double getOverDrawn() {
		return overDrawn;
	}


	public void setOverDrawn(double overDrawn) {
		this.overDrawn = overDrawn;
	}

	
	
	

	
	
	
}
