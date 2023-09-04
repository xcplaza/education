package telran.view;

public class Menu {
	Item[] items;
	InputOutput inOut;
	
	public Menu(InputOutput inOut, Item[] items) {
		super();
		this.inOut = inOut;
		this.items = items;
	}
	
	public void runMenu() {
		while (true) {
			for(int i = 0;i<items.length;i++) {
				inOut.outputLine((i+1) + ". " + items[i].displayedName());
			}
			Integer select = inOut.inputInteger("Type item number", 1, items.length);
			if(select == null)
				continue;
			items[select - 1].perform();
			if(items[select-1].isExit())
				return;
		}
	}

}
