package br.qziul.restful.dto;

import br.qziul.restful.model.Account;

import java.math.BigDecimal;

public class AccountDTO {
    private String number;
    private String agency;
    private BigDecimal balance;
    private BigDecimal limit;

    public Account convertToAccount() {
        return new Account(this.number, this.agency, this.balance, this.limit);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
