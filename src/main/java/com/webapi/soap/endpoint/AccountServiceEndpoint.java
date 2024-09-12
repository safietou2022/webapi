package com.webapi.soap.endpoint;


import com.webapi.soap.domain.Account;
import com.webapi.soap.domain.Transaction;
import com.webapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class AccountServiceEndpoint {

    private static final String NAMESPACE_URI = "http://webapi.com/soap";

    @Autowired
    private AccountService accountService;

    // Consultation du solde du compte
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBalanceRequest")
    @ResponsePayload
    public GetBalanceResponse getBalance(@RequestPayload GetBalanceRequest request) {
        GetBalanceResponse response = new GetBalanceResponse();
        response.setBalance(accountService.getBalance(request.getAccountId()));
        return response;
    }

    // Historique des transactions avec pagination
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTransactionsRequest")
    @ResponsePayload
    public GetTransactionsResponse getTransactions(@RequestPayload GetTransactionsRequest request) {
        GetTransactionsResponse response = new GetTransactionsResponse();
        List<Transaction> transactions = accountService.getAccountTransactions(request.getAccountId(), request.getPageNumber(), request.getPageSize()).getContent();
        response.setTransactions(transactions);
        return response;
    }

    // Effectuer un virement
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "transferFundsRequest")
    @ResponsePayload
    public TransferFundsResponse transferFunds(@RequestPayload TransferFundsRequest request) {
        accountService.transfer(request.getCreditorId(), request.getDebtorId(), request.getAmount(), request.getCurrency());
        TransferFundsResponse response = new TransferFundsResponse();
        response.setStatus("Success");
        return response;
    }
}
