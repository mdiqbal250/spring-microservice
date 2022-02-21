package com.iqbal.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iqbal.microservices.entity.ExchangeValue;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
