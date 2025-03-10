package com.example.CurrencyWS.repository;

import com.example.CurrencyWS.model.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Long> {
    Optional<CurrencyPair> findByBaseCharcodeAndQuotedCharcode(String base, String quoted);
}