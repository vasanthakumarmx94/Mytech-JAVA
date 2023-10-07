package com.neosoft.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TempExchangecController {

	
	@Autowired
	private TempExchangeRepository tempRepository;
	
	@Autowired
	private Environment environment; // built in interface 
	
	@GetMapping("/temp-exchange/from/{from}/to/{to}")
	public TempExchange getExchangeValue(@PathVariable String from,@PathVariable String  to) {
		
		TempExchange object= tempRepository.findByFromAndTo(from, to);
		if(object==null)
			throw new RuntimeException("Unable to find data for "+from+" to "+to);
		
		String port=environment.getProperty("local.server.port");
		object.setEnvironment(port);
		return object;
		
		
	}
	
	
}
