package currencyconverter.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import currencyconverter.ICurrencyConverter;
import currencyconverter.dto.CurrencyRates;

@Service
@ManagedResource
@EnableMBeanExport
public class CurrencyConverterImpl implements ICurrencyConverter
{
	static String url = "http://data.fixer.io/api/latest?access_key=826f2d71469efa55f0cf793cd6cf8014";
	static RestTemplate restTemplate = new RestTemplate();
	static LocalDateTime lastUpdate = LocalDateTime.now();
	static private CurrencyRates currencyRates = getRates();
	
	@Value("${refreshPeriod:2000}")
	int period;
	
	@ManagedAttribute	
	public int getPeriod()
	{
		return period;
	}

	@ManagedAttribute
	public void setPeriod(int period)
	{
		this.period = period;
	}

	private static CurrencyRates getRates()
	{
		ResponseEntity<CurrencyRates> responce = restTemplate.exchange(url, HttpMethod.GET, null, 
				CurrencyRates.class);
		lastUpdate = LocalDateTime.now();
		return responce.getBody();
	}
	
	private boolean refreshRequered()
	{
		return ChronoUnit.SECONDS.between(lastUpdate, LocalDateTime.now()) > period;
	}

	public String lastDateTimePresentation()
	{
		if(refreshRequered())
			currencyRates = getRates();
		
		Instant date = Instant.ofEpochSecond(currencyRates.timestamp);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime localDate = LocalDateTime.ofInstant(date, ZoneId.systemDefault());
		return localDate.format(formatter);
	}

	public Set<String> getCodes()
	{
		if(refreshRequered())
			currencyRates = getRates();
		
		return currencyRates.rates.keySet();
	}

	@ManagedOperation
	public double convert(String from, String to, double amount)
	{
		if (from == null || to == null)
			throw new IllegalArgumentException("Enter currency");
		
		if(refreshRequered())
			currencyRates = getRates();

		Double fromCur = currencyRates.rates.get(from);
		Double toCur = currencyRates.rates.get(to);
		
		if (fromCur == null || toCur == null)
			throw new IllegalArgumentException("Enter correct currency");
		
		return (toCur / fromCur * amount);
	}
}
