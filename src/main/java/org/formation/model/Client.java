package org.formation.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
    private String firstName;
    private String lastName;
    private String noTel;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<BankAccount> listAccount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Constructeurs, getters et setters...

    public Client() {}

    public Client(String firstName, String lastName, Address address, String noTel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.noTel = noTel;
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

    public List<BankAccount> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<BankAccount> listAccount) {
        this.listAccount = listAccount;
    }
}
