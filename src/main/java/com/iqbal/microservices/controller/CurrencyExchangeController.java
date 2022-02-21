package com.iqbal.microservices.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iqbal.microservices.entity.ExchangeValue;
import com.iqbal.microservices.service.CurrencyExchangeService;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {

	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping(path = "/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info("Exchange Value");
		ExchangeValue exchangeValue = currencyExchangeService.getExchangeValueByFromTo(from, to);
		return exchangeValue;
	}

	@PostMapping(path = "/create")
	public ExchangeValue createExchangeValue(@RequestBody ExchangeValue exch) {
		return currencyExchangeService.create(exch);
	}

	@GetMapping(path = "/exchange-lists")
	public List<ExchangeValue> retriveExchangeValues() {
		return currencyExchangeService.getRecords();
	}
}
