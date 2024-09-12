package com.webapi.soap.domain;

import javax.xml.bind.annotation.XmlRootElement;

import webapi.entity.Transaction;

import java.util.List;

@XmlRootElement(name = "Account")
public class Account {

    private Long id;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
