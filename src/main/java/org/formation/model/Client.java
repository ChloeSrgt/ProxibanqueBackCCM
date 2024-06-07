package org.formation.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String noTel;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id", unique = true)
	private Card card;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "current_account_id", unique = true)
	private CurrentAccount currentAccount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "saving_account_id", unique = true)
	private SavingAccount savingAccount;

	@Embedded
	private Address address;

	public Client() {
	}

    
    public Client(String lastName) {
    	this.lastName = lastName;
    }

	public Client(String firstName, String lastName, Address address, String noTel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.noTel = noTel;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNoTel() {
		return noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

}
