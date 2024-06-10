package org.formation.service;

import java.util.List;

import java.util.Optional;

import org.formation.dto.AccountsDTO;
import org.formation.model.Client;

public interface ClientService {
	// Display a list of all clients
	List<Client> getAll();

	// Save a client
	Client save(Client client);
	
	// Display a client according to its id
	Optional<Client> getClientById(long id);

	// Delete a client according to its id
	void deleteById(long id);

	// Update a client
	Client update(Client client);

	// Display the different accounts of a client, according to its id
	AccountsDTO getAccountsByClientId(long id);
}
