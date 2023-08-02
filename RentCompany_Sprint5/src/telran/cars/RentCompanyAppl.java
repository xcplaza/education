package telran.cars;

import telran.cars.cli.SaveAndExit;
import telran.cars.cli.manager.AddCarItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubMenu;

public class RentCompanyAppl {
	private static final String COMPANY_FILE = "company.data";
	static IRentCompany company;
	static InputOutput inOut;

	public static void main(String[] args) {
		inOut = new ConsoleInputOutput();
		company = RentCompanyEmbedded.restoreFromFile(COMPANY_FILE);
		Menu menu = new Menu(getMainMenuItems(), inOut);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[] res = {
				new SubMenu("Manager", inOut, getManagerMenuItems()),
				new SaveAndExit(inOut, company, COMPANY_FILE),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = {
				new AddModelItem(inOut, company),
				new AddCarItem(inOut, company),
				new ExitItem()
		};
		return res;
	}

}
