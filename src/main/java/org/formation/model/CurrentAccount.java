package org.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CurrentAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numAccount", column = @Column(name = "num_account")),
			@AttributeOverride(name = "openDate", column = @Column(name = "open_date")),
			@AttributeOverride(name = "solde", column = @Column(name = "solde")) })
	private InfoAccount infoAccount;

	@Column(name = "over_drawn")
	private double overDrawn = 1000;

	@JsonIgnore
	@OneToOne(mappedBy = "currentAccount")
	private Client client;

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
