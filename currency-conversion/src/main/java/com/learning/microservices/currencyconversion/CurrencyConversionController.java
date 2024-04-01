package com.learning.microservices.currencyconversion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/qn/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		return new CurrencyConversion(10001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
	}
	
	
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/qn/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		CurrencyConversion currencyConversion = currencyExchangeProxy.retriveExchangeValue(from, to);
		
		CurrencyConversion conversionResult = new CurrencyConversion(
				currencyConversion.getId(),
				from, to, quantity,
				currencyConversion.getConversionMultiple(),
				//quantity.multiply(currencyConversion.getConversionMultiple()),
				quantity,
				currencyConversion.getEnvironment());
		
		return conversionResult;
	}

}
