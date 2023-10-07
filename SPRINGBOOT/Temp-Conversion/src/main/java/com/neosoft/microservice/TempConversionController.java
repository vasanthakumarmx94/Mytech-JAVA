package com.neosoft.microservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TempConversionController {


	@Autowired
	TempExchangeProxy proxy;
	
	@GetMapping("/temp-conversion/from/{from}/to/{to}/value/{value}")
	public TempConversion calculateTempConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		
		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<TempConversion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8765/temp-exchange/from/{from}/to/{to}", TempConversion.class, uriVariable);
		
		TempConversion tempConversion =proxy.getExchangeValues(from, to);
		if(from.equals("dg")) {
			
			return new TempConversion(tempConversion.getId(), from, to, value,
					tempConversion.getConversionMultiple(),
					value.multiply(tempConversion.getConversionMultiple()).add(BigDecimal.valueOf(32)),
					tempConversion.getEnvironment() + " " + "rest template");
		}
		else {
			return new TempConversion(tempConversion.getId(), from, to, value,
					tempConversion.getConversionMultiple(),
					value.subtract(BigDecimal.valueOf(32)).multiply(tempConversion.getConversionMultiple()),
					tempConversion.getEnvironment() + " " + "rest template");

		}
		
				// (0°C × 9/5) + 32 = 32°F       -- 9/5=1.80
				// (32°F − 32) × 5/9 = 0°C		-- 5/9=0.55
	}
	
}
