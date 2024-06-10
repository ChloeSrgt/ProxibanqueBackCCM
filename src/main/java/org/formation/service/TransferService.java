package org.formation.service;

public interface TransferService {
	// Money transfer from one account to another, according to the id
	boolean transfer(double amount, long fromAccountId, long toAccountId);
}
