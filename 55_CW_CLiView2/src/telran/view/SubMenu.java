package telran.view;

public class SubMenu implements Item {
	String dispayedName;
	InputOutput inOut;
	Item[] items;

	public SubMenu(String dispayedName, InputOutput inOut, Item[] items) {
		super();
		this.dispayedName = dispayedName;
		this.inOut = inOut;
		this.items = items;
	}

	@Override
	public String displayName() {
		return dispayedName;
	}

	@Override
	public void perform() {
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}
}
