package currencyconverter.items;

import java.util.Set;

import currencyconverter.ICurrencyConverter;
import telran.view.InputOutput;

public class DisplayCurrencyCodeItem extends CurrencyItem
{
	private static final int CODES_PER_LINE = 20;

	public DisplayCurrencyCodeItem(InputOutput inputOutput, ICurrencyConverter converter)
	{
		super(inputOutput, converter);
	}

	public String displayedName()
	{
		return "Display currency code";
	}

	public void perform()
	{
		Set<String> codes = converter.getCodes();
		int counter = 0;
		StringBuilder line = new StringBuilder();
		for (String code : codes)
		{
			line.append(code).append(" ");
			if (++counter % CODES_PER_LINE == 0)
			{
				inputOutput.outputLine(line.toString());
				line.setLength(0);
			}
		}
		// display last line if not empty
		if (line.length() > 0)
			inputOutput.outputLine(line.toString());
	}
}
