package org.formation.dto;

// Class to display the different accounts of one client
import org.formation.model.CurrentAccount;
import org.formation.model.SavingAccount;

public class AccountsDTO {
	private CurrentAccount currentAccount;
	private SavingAccount savingAccount;

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
