package currencyconverter.items;

import currencyconverter.ICurrencyConverter;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class CurrencyItem implements Item
{
	protected InputOutput inputOutput;
	protected ICurrencyConverter converter;

	public CurrencyItem(InputOutput inputOutput, ICurrencyConverter converter)
	{
		super();
		this.inputOutput = inputOutput;
		this.converter = converter;
	}
}
