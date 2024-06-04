package org.formation.service;

import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

    private final CurrentAccountRepository currentAccountRepository;
    private final SavingAccountRepository savingAccountRepository;
    private static final Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    public TransferServiceImpl(CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository) {
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
    }

    @Transactional
    @Override
    public boolean transfer(double amount, long fromAccountId, long toAccountId) {
        logger.info("Attempting to transfer {} from account {} to account {}", amount, fromAccountId, toAccountId);
        CurrentAccount fromCurrentAccount = currentAccountRepository.findById(fromAccountId).orElse(null);
        SavingAccount fromSavingAccount = savingAccountRepository.findById(fromAccountId).orElse(null);
        CurrentAccount toCurrentAccount = currentAccountRepository.findById(toAccountId).orElse(null);
        SavingAccount toSavingAccount = savingAccountRepository.findById(toAccountId).orElse(null);

        if (fromCurrentAccount != null && toSavingAccount != null) {
            logger.info("Transferring from Current Account to Saving Account");
            if (fromCurrentAccount.getInfoAccount().getSolde() >= amount) {
                fromCurrentAccount.getInfoAccount().setSolde(fromCurrentAccount.getInfoAccount().getSolde() - amount);
                toSavingAccount.getInfoAccount().setSolde(toSavingAccount.getInfoAccount().getSolde() + amount);
                currentAccountRepository.save(fromCurrentAccount);
                savingAccountRepository.save(toSavingAccount);
                return true;
            } else {
                logger.warn("Insufficient funds in Current Account");
            }
        }

        if (fromSavingAccount != null && toCurrentAccount != null) {
            logger.info("Transferring from Saving Account to Current Account");
            if (fromSavingAccount.getInfoAccount().getSolde() >= amount) {
                fromSavingAccount.getInfoAccount().setSolde(fromSavingAccount.getInfoAccount().getSolde() - amount);
                toCurrentAccount.getInfoAccount().setSolde(toCurrentAccount.getInfoAccount().getSolde() + amount);
                savingAccountRepository.save(fromSavingAccount);
                currentAccountRepository.save(toCurrentAccount);
                return true;
            } else {
                logger.warn("Insufficient funds in Saving Account");
            }
        }

        logger.error("Transfer failed");
        return false;
    }
}

