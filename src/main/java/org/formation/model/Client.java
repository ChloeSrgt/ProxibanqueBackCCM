package org.formation.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Client {
	
	private String firstName;
	private String lastName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	
	//Constructeurs
	public Client() {
		
	}

	public Client(String firstName, String lastName, long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	
	
	//Getters setters

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	
}
