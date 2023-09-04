package currencyconverter.items;

import java.util.ArrayList;

import currencyconverter.ICurrencyConverter;
import telran.view.InputOutput;

public class ConvertCurrencyItem extends CurrencyItem
{
	public ConvertCurrencyItem(InputOutput inputOutput, ICurrencyConverter converter)
	{
		super(inputOutput, converter);
	}

	public String displayedName()
	{
		return "Convert Currency";
	}

	public void perform()
	{
		ArrayList<String> codesList = new ArrayList<String>(converter.getCodes());
		
		String fromCurrency = inputOutput.inputString("Please enter currency From", codesList);
		if(fromCurrency == null)
			return;
		
		String toCurrency = inputOutput.inputString("Please enter currency To", codesList);
		if(toCurrency == null)
			return;
		
		Double fromAmount = inputOutput.inputDouble("Please enter currency amount");
		if(fromAmount == null)
			return;
		
		double toAmount = converter.convert(fromCurrency, toCurrency, fromAmount);
		inputOutput.outputLine(String.format("%.2f %s = %.2f %s", fromAmount, 
				fromCurrency, toAmount, toCurrency));
	}
}
