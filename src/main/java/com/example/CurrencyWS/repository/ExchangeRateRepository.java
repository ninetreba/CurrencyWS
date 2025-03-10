package com.example.CurrencyWS.repository;

import com.example.CurrencyWS.model.CurrencyPair;
import com.example.CurrencyWS.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findTopByCurrencyPairOrderByRateDateDesc(CurrencyPair currencyPair);
    Optional<ExchangeRate> findByCurrencyPairAndRateDate(CurrencyPair currencyPair, LocalDateTime rateDate);

}