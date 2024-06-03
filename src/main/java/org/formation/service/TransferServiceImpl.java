package org.formation.service;

import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

    private final CurrentAccountRepository currentAccountRepository;
    private final SavingAccountRepository savingAccountRepository;

    public TransferServiceImpl(CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository) {
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
    }

    @Transactional
    @Override
    public boolean transfer(double amount, long fromAccountId, long toAccountId) {
        CurrentAccount fromAccount = currentAccountRepository.findById(fromAccountId).orElse(null);
        SavingAccount toAccount = savingAccountRepository.findById(toAccountId).orElse(null);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getInfoAccount().getSolde() >= amount) {
                fromAccount.getInfoAccount().setSolde(fromAccount.getInfoAccount().getSolde() - amount);
                toAccount.getInfoAccount().setSolde(toAccount.getInfoAccount().getSolde() + amount);
                currentAccountRepository.save(fromAccount);
                savingAccountRepository.save(toAccount);
                return true;
            }
        }
        return false;
    }
}
