package br.qziul.restful.dto;

import br.qziul.restful.model.Card;

import java.math.BigDecimal;

public class CardDTO {
    private String number;
    private BigDecimal limit;

    public Card convertToCard() {
        return new Card(this.number, this.limit);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
