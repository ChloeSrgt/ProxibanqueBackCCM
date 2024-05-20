package org.formation.model;

import jakarta.persistence.ManyToOne;

public class BankAccount {
	
	private String numAccount;
	private double solde;
	private String openDate;
	private String card;
	
	@ManyToOne
	private Client client;
	
	
	
	public BankAccount() {
		
	}
	
	public BankAccount(String numAccount, double solde, String openDate, String card) {
		this.numAccount = numAccount;
		this.solde = solde;
		this.openDate = openDate;
		this.card = card;
	}
	
	
	
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
	
	public String getCard() {
		return card;
	}
	
	public void setCard(String card) {
		this.card = card;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	@Override
	public String toString() {
		return "BankAccount [numAccount=" + numAccount + ", solde=" + solde + ", openDate=" + openDate + ", card="
				+ card + "]";
	}
	
	
	

}
