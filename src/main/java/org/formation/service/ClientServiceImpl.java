package org.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.formation.dto.AccountsDTO;
import org.formation.model.Client;
import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;
import org.formation.repository.ClientRepository;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private List<Client> clients = new ArrayList<>();

    private ClientRepository repository;
    private CurrentAccountRepository currentAccountRepository;
    private SavingAccountRepository savingAccountRepository;

    public ClientServiceImpl(ClientRepository repository, CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository) {
        this.repository = repository;
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
    }


    @Override
	public Client save(Client client) {
//		for (BankAccount account : client.getListAccount()) {
//            account.setClient(client);
//        }
		return repository.save(client);
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
    public Client update(Long id, Client client) {
        Optional<Client> optionalClient = repository.findById(id);
        if(optionalClient.isPresent()) {
        	Client existingClient = optionalClient.get();
        	existingClient.setAddress(client.getAddress());
        	existingClient.setCard(client.getCard());
        	existingClient.setCurrentAccount(client.getCurrentAccount());
        	existingClient.setSavingAccount(client.getSavingAccount());
        	existingClient.setFirstName(client.getFirstName());
        	existingClient.setLastName(client.getLastName());
        	existingClient.setId(client.getId());
        	existingClient.setNoTel(client.getNoTel());
        	return repository.save(existingClient);
        	} else {
        		throw new RuntimeException("Client non trouvé avec cet id :" +id);
        	} 
    };


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
