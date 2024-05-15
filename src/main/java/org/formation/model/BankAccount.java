package org.formation.model;

public class BankAccount {
	
	private String numAccount;
	private double solde;
	private String openDate;
	private String card;
	
	
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
	public BankAccount(String numAccount, double solde, String openDate, String card) {
		super();
		this.numAccount = numAccount;
		this.solde = solde;
		this.openDate = openDate;
		this.card = card;
	}
	
	

}
