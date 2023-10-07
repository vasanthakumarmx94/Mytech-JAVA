package com.neosoft.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired 
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment; // built in interface 
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(
			@PathVariable String from,@PathVariable String  to) {
		CurrencyExchange object= repository.findByFromAndTo(from, to);
		if(object==null)
			throw new RuntimeException("Unable to find data for "+from+"to "+to);
		
		String port=environment.getProperty("local.server.port");
		object.setEnvironment(port);
		return object;
		
		
	}
	
}
