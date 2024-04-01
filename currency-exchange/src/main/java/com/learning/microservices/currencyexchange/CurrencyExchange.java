package com.learning.microservices.currencyexchange;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {
	@Id
	private Long id;
	private String fromcurr;
	private String tocurr;
	private BigDecimal conversionMultiple;
	private int environment;
	
	public CurrencyExchange() {
		super();
	}
	
	public CurrencyExchange(long id, String fromcurr, String tocurr, BigDecimal multi) {
		
		this.id = id;
		this.fromcurr = fromcurr;
		this.tocurr = tocurr;
		this.conversionMultiple = multi;
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromcurr() {
		return fromcurr;
	}
	public void setFromcurr(String fromcurr) {
		this.fromcurr = fromcurr;
	}
	public String getTocurr() {
		return tocurr;
	}
	public void setTocurr(String tocurr) {
		this.tocurr = tocurr;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}
	

}
