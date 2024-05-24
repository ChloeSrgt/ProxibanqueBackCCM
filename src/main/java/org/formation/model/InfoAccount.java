package org.formation.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class InfoAccount {

	private String numAccount;
	private double solde;
	private String openDate;
	
	
	
	
	public String getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	
	
	
}
