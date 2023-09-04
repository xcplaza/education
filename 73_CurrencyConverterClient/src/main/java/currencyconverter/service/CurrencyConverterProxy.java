package currencyconverter.service;

import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import currencyconverter.ConvertData;
import static currencyconverter.CurrencyConstantsApi.*;
import currencyconverter.ICurrencyConverter;

public class CurrencyConverterProxy implements ICurrencyConverter
{
	String url = "http://localhost:8080";
	RestTemplate restTemplate = new RestTemplate();

	public String lastDateTimePresentation()
	{
		return restTemplate.exchange(url + CURRENCIES + TIMESTAMP, HttpMethod.GET, null, 
				String.class).getBody();
	}

	public Set<String> getCodes()
	{
		return restTemplate.exchange(url + CURRENCIES, HttpMethod.GET, null,
				new ParameterizedTypeReference<Set<String>>(){}).getBody();
	}

	public double convert(String from, String to, double amount)
	{
		if (from == null || to == null)
			throw new IllegalArgumentException();

		HttpEntity<ConvertData> requestEntity = 
				new HttpEntity<ConvertData>(new ConvertData(from, to, amount));
		return restTemplate.exchange(url + CURRENCIES + CONVERT, HttpMethod.POST, 
				requestEntity, Double.class).getBody();
	}
}
