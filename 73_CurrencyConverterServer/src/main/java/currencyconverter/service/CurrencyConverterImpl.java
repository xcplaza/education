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
	static String url = "http://data.fixer.io/api/latest?access_key=PgCpCuH9FXIvqGr3OAG8DqqNi58d40Nv";
	static LocalDateTime lastUpdate = LocalDateTime.now();
	static private CurrencyRates currencyRates = getRates();

	private static CurrencyRates getRaes() {
		ResponseEntity<CurrencyRates> responce = restTemplate.exchange(url, HttpMethod.GET, null,
				CurrencyRates.class);
		lastUpdate = LocalDateTime.now();
		return responce.getBody();
	}

	static RestTemplate restTemplate = new RestTemplate();

	@Value("${refreshPeriod:2000}")
	int period;

	public String lastDateTimePresentation()
	{
		Instant date = Instant.ofEpochSecond(currencyRates.timestamp);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime localDate = LocalDateTime.ofInstant(date, ZoneId.systemDefault());
		return localDate.format(formatter);
	}
	@ManagedAttribute
	public static String getUrl() {
		return url;
	}
	@ManagedAttribute
	public static void setUrl(String url) {
		CurrencyConverterImpl.url = url;
	}

	private boolean refreshPeriod(){
		return ChronoUnit.SECONDS.between(lastUpdate, LocalDateTime.now()) > period;
	}
	public Set<String> getCodes()
	{
		return currencyRates.rates.keySet();
	}
	public double convert(String from, String to, double amount)
	{
		if (from == null || to == null)
			throw new IllegalArgumentException("Enter currency");

		Double fromCur = currencyRates.rates.get(from);
		Double toCur = currencyRates.rates.get(to);
		
		if (fromCur == null || toCur == null)
			throw new IllegalArgumentException("Enter correct currency");
		
		return (toCur / fromCur * amount);
	}
}
