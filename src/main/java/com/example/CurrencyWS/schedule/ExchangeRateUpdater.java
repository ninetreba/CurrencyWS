package com.example.CurrencyWS.schedule;

import com.example.CurrencyWS.model.CurrencyPair;
import com.example.CurrencyWS.model.ExchangeRate;
import com.example.CurrencyWS.repository.CurrencyPairRepository;
import com.example.CurrencyWS.repository.ExchangeRateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ExchangeRateUpdater {
    private CurrencyPairRepository currencyPairRepository;
    private ExchangeRateRepository exchangeRateRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void updateExchangeRates() {
        List<CurrencyPair> pairs = currencyPairRepository.findAll();
        for (CurrencyPair pair : pairs) {
            String url = "https://api.frankfurter.app/latest?from=" + pair.getBaseCharcode() + "&to=" + pair.getQuotedCharcode();
            try {
                ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
                float rate = response.getBody().get("rates").get(pair.getQuotedCharcode()).floatValue();
                exchangeRateRepository.save(new ExchangeRate(LocalDateTime.now(), rate, pair));
            } catch (Exception e) {
                System.err.println("Ошибка обновления курса: " + e.getMessage());
            }
        }
    }
}
