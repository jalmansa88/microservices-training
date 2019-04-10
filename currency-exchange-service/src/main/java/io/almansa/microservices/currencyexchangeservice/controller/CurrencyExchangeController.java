package io.almansa.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.almansa.microservices.currencyexchangeservice.bean.ExchangeValue;
import io.almansa.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository repo;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue value = repo.findByFromAndTo(from, to);
		value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		LOGGER.info("{}", value);
		
		return value;
	}
}
