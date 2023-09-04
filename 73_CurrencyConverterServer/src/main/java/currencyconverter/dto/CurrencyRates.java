package currencyconverter.dto;

import java.util.HashMap;
import java.util.Map;

public class CurrencyRates
{
	public int timestamp;
	public Map<String, Double> rates = new HashMap<String, Double>();

	@Override
	public String toString()
	{
		return "CurrencyRates [timestamp=" + timestamp + ", rates=" + rates + "]";
	}
}
