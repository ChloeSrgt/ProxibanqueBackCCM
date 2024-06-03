package org.formation.service;

public interface TransferService {
    boolean transfer(double amount, long fromAccountId, long toAccountId);
}
