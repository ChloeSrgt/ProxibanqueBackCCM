package org.formation.model;

public class Card {
	
	private String numCard;
	private String expirationDate;
	private String cardType;
	private String bankAccountAssociated;
	
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
	public String getBankAccountAssociated() {
		return bankAccountAssociated;
	}
	public void setBankAccountAssociated(String bankAccountAssociated) {
		this.bankAccountAssociated = bankAccountAssociated;
	}
	
	public Card(String numCard, String expirationDate, String cardType, String bankAccountAssociated) {
		super();
		this.numCard = numCard;
		this.expirationDate = expirationDate;
		this.cardType = cardType;
		this.bankAccountAssociated = bankAccountAssociated;
	}
	
	

}
