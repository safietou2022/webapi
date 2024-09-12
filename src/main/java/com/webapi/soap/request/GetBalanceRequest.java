package com.webapi.soap.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getBalanceRequest")
public class GetBalanceRequest {
    private Long accountId;

    // Getters et Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
