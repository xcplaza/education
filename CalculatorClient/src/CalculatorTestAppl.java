

import client.CalculatorClient;
import telran.view.*;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorTestAppl {
	static CalculatorClient cc;
	static InputOutput inOut;

	public static void main(String[] args) throws Exception {
		cc =  new CalculatorClient("localhost", 2000);
		inOut = new ConsoleInputOutput();
		Item[] items = { 
				new CalculatorItem(inOut, cc),
				new CloseExitItem(inOut, cc)
		};
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}
}
