package com.iqbal.microservices.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iqbal.microservices.entity.ExchangeValue;
import com.iqbal.microservices.repository.CurrencyExchangeRepo;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepo currencExchangeRepo;

	public ExchangeValue create(ExchangeValue exch) {
		return currencExchangeRepo.save(exch);
	}

	public ExchangeValue getRecord(long id) {
		return currencExchangeRepo.findById(id).get();
	}

	public List<ExchangeValue> getRecords() {
		return currencExchangeRepo.findAll();
	}

	public ExchangeValue getExchangeValueByFromTo(String fromCurrency, String toCurrency) {
		return currencExchangeRepo.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

	}
}
