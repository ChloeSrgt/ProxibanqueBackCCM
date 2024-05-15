package org.formation.model;

import java.util.List;

public class Agence {
	
	private String identificationNumber;
	private String createdDate;
	private List<Advisor> advisors;
	private String managerName;
	private List<Client> clients;
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public List<Advisor> getAdvisors() {
		return advisors;
	}
	public void setAdvisors(List<Advisor> advisors) {
		this.advisors = advisors;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Agence(String identificationNumber, String createdDate, List<Advisor> advisors, String managerName,
			List<Client> clients) {
		super();
		this.identificationNumber = identificationNumber;
		this.createdDate = createdDate;
		this.advisors = advisors;
		this.managerName = managerName;
		this.clients = clients;
	}
	
	

}
