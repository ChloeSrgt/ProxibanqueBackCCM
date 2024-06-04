package org.formation.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.formation.dto.AccountsDTO;
import org.formation.model.Client;
import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;
import org.formation.repository.ClientRepository;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository repository;
	private final CurrentAccountRepository currentAccountRepository;
	private final SavingAccountRepository savingAccountRepository;

	private final Random random = new Random();

	public ClientServiceImpl(ClientRepository repository, CurrentAccountRepository currentAccountRepository,
			SavingAccountRepository savingAccountRepository) {
		this.repository = repository;
		this.currentAccountRepository = currentAccountRepository;
		this.savingAccountRepository = savingAccountRepository;
	}

	@Transactional
	@Override
	public Client save(Client client) {
		// Generate random balances for the accounts
		double currentAccountBalance = generateRandomBalance();
		double savingAccountBalance = generateRandomBalance();

		// Set the balances to the accounts
		client.getCurrentAccount().getInfoAccount().setSolde(currentAccountBalance);
		client.getSavingAccount().getInfoAccount().setSolde(savingAccountBalance);

		// Persist CurrentAccount and SavingAccount first
		CurrentAccount currentAccount = currentAccountRepository.save(client.getCurrentAccount());
		SavingAccount savingAccount = savingAccountRepository.save(client.getSavingAccount());

		// Set the persisted entities back to the client
		client.setCurrentAccount(currentAccount);
		client.setSavingAccount(savingAccount);

		// Persist the client
		return repository.save(client);
	}

	private double generateRandomBalance() {
		double balance = 1000 + (2200 - 1000) * random.nextDouble();
		return Math.round(balance * 100.0) / 100.0;
	}

	@Override
	public List<Client> getAll() {
		return repository.findAll();
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

	@Override
	public AccountsDTO getAccountsByClientId(long id) {
		Optional<Client> optionalClient = getClientById(id);
		if (optionalClient.isPresent()) {
			CurrentAccount currentAccount = currentAccountRepository.findByClientId(id);
			SavingAccount savingAccount = savingAccountRepository.findByClientId(id);
			AccountsDTO accountsDTO = new AccountsDTO();
			accountsDTO.setCurrentAccount(currentAccount);
			accountsDTO.setSavingAccount(savingAccount);
			return accountsDTO;
		}
		return null;
	}
}
