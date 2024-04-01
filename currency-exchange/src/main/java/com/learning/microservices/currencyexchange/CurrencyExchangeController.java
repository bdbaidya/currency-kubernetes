package com.learning.microservices.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private ServerProperties serverProperties;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{fromcurr}/to/{tocurr}")
	public CurrencyExchange retriveExchangeValu(
			@PathVariable String fromcurr,
			@PathVariable String tocurr ) {
				//CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(50));
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromcurrAndTocurr(fromcurr, tocurr);
		
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find Data");
		}
		
		int port = serverProperties.getPort();
		currencyExchange.setEnvironment(port);
		return currencyExchange;
		
	}

}
