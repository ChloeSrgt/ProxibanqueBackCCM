package org.formation.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Card {
	
	private String numCard;
	private String expirationDate;
	private String cardType;
	
	@OneToOne(mappedBy = "card")
	private Client client;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	
	
	public Card() {
	}
	
	public Card(String numCard, String expirationDate, String cardType) {
		this.numCard = numCard;
		this.expirationDate = expirationDate;
		this.cardType = cardType;
	}
	

	
	public String getNumCard() {
		return numCard;
	}
	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

//	public BankAccount getBankAccount() {
//		return bankAccount;
//	}
//
//	public void setBankAccount(BankAccount bankAccount) {
//		this.bankAccount = bankAccount;
//	}
	
	

	public Long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

}
