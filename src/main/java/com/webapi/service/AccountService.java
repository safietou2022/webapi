package com.webapi.service;

import com.webapi.entity.Account;
import com.webapi.entity.Transaction;
import com.webapi.repository.AccountRepository;
import com.webapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Méthode pour obtenir le solde d'un compte
    public double getBalance(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.map(Account::getBalance).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
    }

    // Méthode pour obtenir l'historique des transactions avec pagination
    public Page<Transaction> getAccountTransactions(Long accountId, int page, int size) {
        return transactionRepository.findByAccountId(accountId, PageRequest.of(page, size));
    }

    // Méthode pour effectuer un virement
    public void transfer(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }
}
