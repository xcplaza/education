package telran.cars;

import telran.cars.cli.SaveAndExitItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubmenuItem;

public class RentCompanyAppl
{
	private static final String COMPANY_FILE = "company.data";
	static IRentCompany company;
	static InputOutput inOut = new ConsoleInputOutput();

	public static void main(String[] args)
	{
		company = RentCompanyEmbedded.restoreFromFile(COMPANY_FILE);
		Menu menu = new Menu(getMainMenuItems(), inOut);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems()
	{
		Item[] res =
			{
				new SubmenuItem("Manager", inOut, getManagerMenuItems()),
//				4 Submenuitems
				new SaveAndExitItem(inOut, company, COMPANY_FILE),
				new ExitItem()
			};
		return res;
	}

	private static Item[] getManagerMenuItems()
	{
		Item[] res =
			{
				new AddModelItem(inOut, company),
				new ExitItem()
			};
		return res;
	}

}
