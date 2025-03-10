package com.example.CurrencyWS.service;

import com.example.CurrencyWS.model.CurrencyPair;
import com.example.CurrencyWS.model.dto.CreateCurrencyPairRequest;
import com.example.CurrencyWS.model.dto.CurrencyPairDto;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyService {
    public List<CurrencyPair> getCurrencyPairs();
    public CurrencyPairDto addCurrencyPair(CreateCurrencyPairRequest request);
    public float getExchangeRate(Long currencyPairId, LocalDate date);
    public float getLatestExchangeRate(Long currencyPairId);


}
