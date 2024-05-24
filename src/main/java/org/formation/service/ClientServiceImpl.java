package org.formation.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.formation.model.Client;
import org.formation.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Service
public class ClientServiceImpl implements ClientService {
	
	private List<Client> clients = new ArrayList<>();
	
	private ClientRepository repository;
	
	
	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}



	@Override
	public List<Client> getAll() {
		return repository.findAll();
	}

	@Override
	public Client save(Client client) {
//		for (BankAccount account : client.getListAccount()) {
//            account.setClient(client);
//        }
		return repository.save(client);
	}

	@Override
	public Optional<Client> getClientById(long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public Client update(Client client) {
		return repository.save(client);
	}

	

}
