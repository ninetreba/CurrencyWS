package com.example.CurrencyWS.service;

import com.example.CurrencyWS.exception.NotFoundException;
import com.example.CurrencyWS.model.*;
import com.example.CurrencyWS.model.dto.CreateCurrencyPairRequest;
import com.example.CurrencyWS.model.dto.CurrencyPairDto;
import com.example.CurrencyWS.repository.CurrencyPairRepository;
import com.example.CurrencyWS.repository.ExchangeRateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImp implements CurrencyService{

    private final CurrencyPairRepository currencyPairRepository;
    private final ExchangeRateRepository exchangeRateRepository;



    public List<CurrencyPair> getCurrencyPairs() {
        return currencyPairRepository.findAll();
    }



    @Transactional
    public CurrencyPairDto addCurrencyPair(CreateCurrencyPairRequest request) {
        if (currencyPairRepository.findByBaseCharcodeAndQuotedCharcode(request.getBaseCharcode(), request.getQuotedCharcode()).isPresent()) {
            throw new IllegalArgumentException("Currency pair already exists");
        }
        CurrencyPair pair = new CurrencyPair();
        pair.setBaseCharcode(request.getBaseCharcode());
        pair.setQuotedCharcode(request.getQuotedCharcode());
        pair.setDescription(request.getBaseCharcode() + " to " + request.getQuotedCharcode());
        currencyPairRepository.save(pair);
        return new CurrencyPairDto(pair.getBaseCharcode(), pair.getQuotedCharcode(), pair.getDescription());
    }



    public float getExchangeRate(Long currencyPairId, LocalDate date) {
        return exchangeRateRepository.findByCurrencyPairAndRateDate(
                getCurrencyPairById(currencyPairId), date.atStartOfDay()
        ).get().getRateValue();
    }



    public float getLatestExchangeRate(Long currencyPairId) {
        return exchangeRateRepository.findTopByCurrencyPairOrderByRateDateDesc(getCurrencyPairById(currencyPairId)).get().getRateValue();
    }


    private CurrencyPair getCurrencyPairById(Long id){
        return currencyPairRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Currency pair not found")
        );
    }


}