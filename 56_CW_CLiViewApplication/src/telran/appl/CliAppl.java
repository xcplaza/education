package telran.appl;

import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CliAppl {

	public static void main(String[] args) {
		InputOutput inOut = new ConsoleInputOutput();
		Item[] items = { 
				new CalculatorItem(inOut),
				new DateAfterBeforeItem(inOut),
				new DaysBetweenItem(inOut),
				new ExitItem()
				};
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}

}
