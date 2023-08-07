
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class ThreadsRaceAppl {

	public static void main(String[] args) {
		InputOutput inOut = new ConsoleInputOutput();
		Item[] items = { 
				new ThreadsRaceItem(inOut),
				new ExitItem(),
		};
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}

}
