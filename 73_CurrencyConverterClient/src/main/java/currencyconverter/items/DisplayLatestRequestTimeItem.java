package currencyconverter.items;

import currencyconverter.ICurrencyConverter;
import telran.view.InputOutput;

public class DisplayLatestRequestTimeItem extends CurrencyItem
{

	public DisplayLatestRequestTimeItem(InputOutput inputOutput, ICurrencyConverter converter)
	{
		super(inputOutput, converter);
	}

	public String displayedName()
	{
		return "Display  time of latest request";
	}

	public void perform()
	{
		inputOutput.outputLine(converter.lastDateTimePresentation());
	}
}
