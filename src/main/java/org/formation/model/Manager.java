package org.formation.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Manager {
	
	private String lastName;
	private String firstName;
	private String email;
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//Getter et Setter
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Constructor
	public Manager(String lastName, String firstName, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}


}
