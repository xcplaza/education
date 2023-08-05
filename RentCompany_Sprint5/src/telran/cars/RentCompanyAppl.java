package telran.cars;

import telran.cars.cli.SaveAndExit;
import telran.cars.cli.clerk.AddDriverItem;
import telran.cars.cli.clerk.GetCarsByModelItel;
import telran.cars.cli.clerk.RentCarItem;
import telran.cars.cli.manager.AddCarItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.cli.manager.RemoveCarItem;
import telran.cars.cli.manager.RemoveModelItem;
import telran.cars.cli.statist.MostActiveDriversItem;
import telran.cars.cli.statist.MostPopularModelsItem;
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
				new SubMenu("Clerk", inOut, getClerkMenuItems()),
				new SubMenu("Driver", inOut, getDriverMenuItems()),
				new SubMenu("Manager", inOut, getManagerMenuItems()),
				new SubMenu("Statist", inOut, getStatistMenuItems()),
				new SubMenu("Technic", inOut, getTechMenuItems()),
				new SaveAndExit(inOut, company, COMPANY_FILE),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getTechMenuItems() {
		Item[] res = {
				new ExitItem()	
		};
		return res;
	}

	private static Item[] getStatistMenuItems() {
		Item[] res = {
				new MostActiveDriversItem(inOut, company),
				new MostPopularModelsItem(inOut, company),
				new ExitItem()	
		};
		return res;
	}

	private static Item[] getDriverMenuItems() {
		Item[] res = {
				new ExitItem()	
		};
		return res;
	}

	private static Item[] getClerkMenuItems() {
		Item[] res = {
				new AddDriverItem(inOut, company),
				new GetCarsByModelItel(inOut, company),
				new RentCarItem(inOut, company),
				new ReturnCarItem(inOut, company),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = {
				new AddModelItem(inOut, company),
				new AddCarItem(inOut, company),
				new RemoveModelItem(inOut, company),
				new RemoveCarItem(inOut, company),
				new ExitItem()
		};
		return res;
	}

}
