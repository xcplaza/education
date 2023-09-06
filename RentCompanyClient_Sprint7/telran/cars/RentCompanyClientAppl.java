package telran.cars;

import telran.cars.cli.clerk.*;
import telran.cars.cli.driver.*;
import telran.cars.cli.manager.*;
import telran.cars.cli.statist.*;
import telran.cars.cli.technitian.*;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyProxy;
import telran.view.*;

public class RentCompanyClientAppl {
	static IRentCompany company;
	static InputOutput inOut = new ConsoleInputOutput();
	static String hostname = "localhost";
	static int port = 2000;

	public static void main(String[] args) throws Exception {
		company = new RentCompanyProxy(hostname, port);
		Menu menu = new Menu(inOut, getMainMenuItems());
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[] res = { new SubMenu("Clerk", inOut, getClerkMenuItems()),
				new SubMenu("Driver", inOut, getDriverMenuItems()),
				new SubMenu("Manager", inOut, getManagerMenuItems()),
				new SubMenu("Statist", inOut, getStatistMenuItems()),
				new SubMenu("Technician", inOut, getTechnicianMenuItems()), new ExitItem() };
		return res;
	}

	private static Item[] getClerkMenuItems() {
		Item[] res = { new AddDriverItem(inOut, company), new GetModelCarsItem(inOut, company),
				new RentCarItem(inOut, company), new ReturnCarItem(inOut, company), new ExitItem() };
		return res;
	}

	private static Item[] getDriverMenuItems() {
		Item[] res = { new GetCarItem(inOut, company), new GetCarsByDriverItem(inOut, company),
				new GetDriverItem(inOut, company), new GetDriversByCarItem(inOut, company), new ExitItem() };
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = { new AddCarItem(inOut, company), new AddModelItem(inOut, company),
				new RemoveModelItem(inOut, company), new RemoveCarItem(inOut, company), new ExitItem() };
		return res;
	}

	private static Item[] getStatistMenuItems() {
		Item[] res = { new GetMostActiveDriversItem(inOut, company), new GetMostPopularModelsItem(inOut, company),
				new GetMostProfitableModelsItem(inOut, company), new ExitItem() };
		return res;
	}

	private static Item[] getTechnicianMenuItems() {
		Item[] res = { new GetRentRecordsAtDatesItem(inOut, company), new ExitItem() };
		return res;
	}

}
