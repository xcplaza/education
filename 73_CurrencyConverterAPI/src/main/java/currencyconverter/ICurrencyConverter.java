package currencyconverter;

import java.util.Set;

public interface ICurrencyConverter
{
	String lastDateTimePresentation();
	Set<String> getCodes();
	double convert(String from, String to, double amount);
}
