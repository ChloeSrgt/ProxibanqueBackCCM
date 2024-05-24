package org.formation.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CurrentAccount {
	
	@Embedded
	private InfoAccount infoAccount;
	private double overDrawn=1000;

	@OneToOne(mappedBy = "currentAccount")
	private Client client;
	
	@Id
	private Long id;

	public CurrentAccount() {
		
	}
	
//	public CurrentAccount(String numAccount, double solde, String openDate) {
//		super(numAccount, solde, openDate);
//	}


	public double getOverDrawn() {
		return overDrawn;
	}


	public void setOverDrawn(double overDrawn) {
		this.overDrawn = overDrawn;
	}

	
	
	

	
	
	
}
