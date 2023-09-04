package telran;

import telran.items.CalculationItem;
import telran.items.DisplayOperationsItem;
import telran.service.CalculatorProxy;
import telran.service.ICalculator;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CalculatorClientAppl
{
	static InputOutput inputOutput = new ConsoleInputOutput();
	static ICalculator calculator = new CalculatorProxy();

	public static void main(String[] args)
	{
		Item[] items = {
				new DisplayOperationsItem(inputOutput, calculator),
				new CalculationItem(inputOutput, calculator), 
				new ExitItem() 
				};
		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}

}
