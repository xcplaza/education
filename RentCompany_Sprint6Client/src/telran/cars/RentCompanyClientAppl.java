package telran.cars;

import telran.cars.cli.*;
import telran.cars.cli.clerk.*;
import telran.cars.cli.manager.*;
import telran.cars.cli.statist.*;
import telran.cars.model.*;
import telran.view.*;

public class RentCompanyClientAppl {
	static IRentCompany company; // прокси компании для обмена из клиента
	static InputOutput inOut = new ConsoleInputOutput();
	static String hostname = "localhost";
	static int port = 2000;

	public static void main(String[] args) throws Exception {
		company = new RentCompanyProxy(hostname, port);
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
