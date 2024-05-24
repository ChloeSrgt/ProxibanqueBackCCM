package org.formation.model;



import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	private String firstName;
	private String lastName;

	@OneToOne 
	@JoinColumn(name="card_id", unique=true) 
	private Card card;
	
	@OneToOne 
	@JoinColumn(name="current_account_id", unique=true) 
	private CurrentAccount currentAccount;
	
	@OneToOne 
	@JoinColumn(name="saving_account_id", unique=true) 
	private SavingAccount savingAccount;
	
	@Embedded
    private Address address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 


    // Constructeurs, getters et setters...

    public Client() {}

    public Client(String firstName, String lastName, Address address, String noTel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Getters et setters
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
