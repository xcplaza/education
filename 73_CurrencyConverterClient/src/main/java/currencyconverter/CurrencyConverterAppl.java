package currencyconverter;

import currencyconverter.items.ConvertCurrencyItem;
import currencyconverter.items.DisplayCurrencyCodeItem;
import currencyconverter.items.DisplayLatestRequestTimeItem;
import currencyconverter.service.CurrencyConverterProxy;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CurrencyConverterAppl
{

	public static void main(String[] args)
	{
		InputOutput inputOutput = new ConsoleInputOutput();
		ICurrencyConverter convertor = new CurrencyConverterProxy();

		Item[] items = 
			{ 
					new DisplayCurrencyCodeItem(inputOutput, convertor),
					new DisplayLatestRequestTimeItem(inputOutput, convertor),
					new ConvertCurrencyItem(inputOutput, convertor), 
					new ExitItem() 
			};
		Menu menu = new Menu(inputOutput, items);
		menu.runMenu();
	}
}
