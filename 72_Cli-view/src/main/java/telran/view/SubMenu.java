package telran.view;

public class SubMenu implements Item{
	String displayedName;
	InputOutput inOut;
	Item[] items;
	
	public SubMenu(String displayedName, InputOutput inOut, Item[] items) {
		super();
		this.displayedName = displayedName;
		this.inOut = inOut;
		this.items = items;
	}

	@Override
	public String displayedName() {	
		return displayedName;
	}

	@Override
	public void perform() {
		Menu menu = new Menu(inOut, items);
		menu.runMenu();
	}

}
