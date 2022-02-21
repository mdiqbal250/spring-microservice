package com.iqbal.microservices.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExchangeValue {

	@Id
	private long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal exchangeValue;

}
