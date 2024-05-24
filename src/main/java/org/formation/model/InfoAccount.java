package org.formation.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class InfoAccount {

	private String numAccount;
	private double solde;
	private String openDate;
	
}
