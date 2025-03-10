package com.example.CurrencyWS.model.dto;


public class CurrencyPairDto {
    private String baseCharcode;
    private String quotedCharcode;
    private String description;

    public CurrencyPairDto() {
    }

    public CurrencyPairDto(String baseCharcode, String quotedCharcode, String description) {
        this.baseCharcode = baseCharcode;
        this.quotedCharcode = quotedCharcode;
        this.description = description;
    }

    public String getBaseCharcode() {
        return baseCharcode;
    }

    public void setBaseCharcode(String baseCharcode) {
        this.baseCharcode = baseCharcode;
    }

    public String getQuotedCharcode() {
        return quotedCharcode;
    }

    public void setQuotedCharcode(String quotedCharcode) {
        this.quotedCharcode = quotedCharcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
