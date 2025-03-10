package com.example.CurrencyWS.exception;

public class ExchangeRateUpdateException extends RuntimeException{
    public ExchangeRateUpdateException(String message) {
        super(message);
    }
}
