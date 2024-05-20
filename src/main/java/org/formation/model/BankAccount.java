package org.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BankAccount {
	
	private String numAccount;
	private double solde;
	private String openDate;
	private String card;
	
	@Column(name= "account_type")
	private String accountType;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="client_id")
	private Client client;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
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

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "BankAccount [numAccount=" + numAccount + ", solde=" + solde + ", openDate=" + openDate + ", card="
				+ card + "]";
	}
	
	
	

}
