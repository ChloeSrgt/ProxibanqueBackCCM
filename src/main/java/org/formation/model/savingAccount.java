package org.formation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class savingAccount {

	private double payRate = 0.03;
	
	@OneToOne(mappedBy = "savingAccount")
	private Client client;
	
	@Id
	private Long id;

	
	

	public savingAccount() {

	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	
	

}
