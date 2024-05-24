package org.formation.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	private String firstName;
	private String lastName;
	private String address;
	private String codPost;
	private String city;
	private String noTel;
	
	@OneToOne 
	@JoinColumn(name="card_id", unique=true) 
	private Card card;
	
	@OneToOne 
	@JoinColumn(name="current_account_id", unique=true) 
	private CurrentAccount currentAccount;
	
	@OneToOne 
	@JoinColumn(name="saving_account_id", unique=true) 
	private savingAccount savingAccount;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
	private List<BankAccount> listAccount;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;





	// Constructeurs
	public Client() {
	}

	public Client(String firstName, String lastName, String address, String codPost, String city, String noTel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.codPost = codPost;
		this.city = city;
		this.noTel = noTel;
	}

	// Getter et Setter
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCodPost() {
		return codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<BankAccount> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<BankAccount> listAccount) {
		this.listAccount = listAccount;
	}
	
	
}
