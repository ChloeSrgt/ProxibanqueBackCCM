package org.formation.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CurrentAccount {
	
	@Embedded
	private InfoAccount infoAccount;
	private double overDrawn=1000;

	@OneToOne(mappedBy = "currentAccount")
	private Client client;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public CurrentAccount() {
		
	}
	
	public double getOverDrawn() {
		return overDrawn;
	}


	public void setOverDrawn(double overDrawn) {
		this.overDrawn = overDrawn;
	}

	public InfoAccount getInfoAccount() {
		return infoAccount;
	}

	public void setInfoAccount(InfoAccount infoAccount) {
		this.infoAccount = infoAccount;
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

	
	
	

	
	
	
}
