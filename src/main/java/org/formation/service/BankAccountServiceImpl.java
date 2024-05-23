package org.formation.service;

import java.util.List;

import org.formation.model.BankAccount;
import org.formation.repository.BankAccountRepository;

public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;

	@Override
	public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
	}
	
	
}
