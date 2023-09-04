package currencyconverter.controllers;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
