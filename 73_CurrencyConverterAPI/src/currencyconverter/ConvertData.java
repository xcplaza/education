package currencyconverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConvertData
{
	private String currencyFrom;
	private String currencyTo;
	private double amount;
}
