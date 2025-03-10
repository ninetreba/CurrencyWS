package com.example.CurrencyWS.controller;


import com.example.CurrencyWS.model.CurrencyPair;
import com.example.CurrencyWS.model.dto.CreateCurrencyPairRequest;
import com.example.CurrencyWS.model.dto.CurrencyPairDto;
import com.example.CurrencyWS.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;



    @GetMapping("/pairs")
    public List<CurrencyPair> getCurrencyPairs() {
        return currencyService.getCurrencyPairs();
    }



    @PostMapping("/pairs")
    public CurrencyPairDto addCurrencyPair(@RequestBody CreateCurrencyPairRequest request) {
        return currencyService.addCurrencyPair(request);
    }


    @GetMapping("/{currencyPairId}/date/{rateDate}")
    public float getExchangeRate(
            @PathVariable Long currencyPairId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate rateDate) {
        return currencyService.getExchangeRate(currencyPairId, rateDate);
    }




    @GetMapping("/rate/latest2/{currencyPairId}")
    public float getLatestExchangeRate(@PathVariable Long currencyPairId) {
        return currencyService.getLatestExchangeRate(currencyPairId);
    }




}
