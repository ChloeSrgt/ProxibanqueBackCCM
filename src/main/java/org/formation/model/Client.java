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
    
    @Embedded
    private Address address;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 


    public Client() {}

    public Client(String firstName, String lastName, Address address, String noTel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.noTel = noTel; // Ajoutez cette ligne
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
}
