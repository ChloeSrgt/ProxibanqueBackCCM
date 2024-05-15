package org.formation.service;

import java.util.List;


import java.util.Optional;

import org.formation.model.Client;



public interface ClientService {
	List<Client> getAll();
	Client save(Client client);
	Optional<Client> getClientById(long id);
	void deleteById(long id);
	Client update(Client client);
}