package currencyconverter.controllers;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import currencyconverter.ConvertData;
import static currencyconverter.CurrencyConstantsApi.*;
import currencyconverter.ICurrencyConverter;

@RestController
@RequestMapping(CURRENCIES)
public class ConverterController
{
	@Autowired
	ICurrencyConverter convertor;

	@GetMapping()
	Set<String> getCurrencyCodes() 
	{
		return convertor.getCodes();
	}

	@GetMapping(TIMESTAMP)
	String latestDateTimePresentation() 
	{
		return convertor.lastDateTimePresentation();
	}

	@PostMapping(CONVERT)
	double convert(@RequestBody ConvertData data) 
	{
		return convertor.convert(data.getCurrencyFrom(), data.getCurrencyTo(), data.getAmount());
	}

	@GetMapping(EURO + "/{cur}")
	double getEuroValuePath(@PathVariable String cur){
		return convertor.euroValue(cur);
	}

	@GetMapping(EURO)
	double getEuroValueParams(@RequestParam String cur){
		return convertor.euroValue(cur);
	}
}
