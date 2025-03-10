package com.example.CurrencyWS.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCurrencyPairRequest {
    private String baseCharcode;
    private String quotedCharcode;


    public CreateCurrencyPairRequest(String baseCharcode, String quotedCharcode, String description) {
        this.baseCharcode = baseCharcode;
        this.quotedCharcode = quotedCharcode;
    }


}
