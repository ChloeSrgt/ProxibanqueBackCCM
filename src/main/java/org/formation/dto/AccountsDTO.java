package org.formation.dto;

import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;

public class AccountsDTO {
	private CurrentAccount currentAccount;
    private SavingAccount savingAccount;
    

    // Getters et setters
    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }
}