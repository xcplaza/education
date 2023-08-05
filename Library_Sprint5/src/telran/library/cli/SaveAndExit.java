package telran.library.cli;

import telran.library.model.ILibrary;
import telran.utils.Persistable;
import telran.view.InputOutput;

public class SaveAndExit extends LibraryItem {
	String fileName;

	public SaveAndExit(InputOutput inOut, ILibrary library, String fileName) {
		super(inOut, library);
		this.fileName = fileName;
	}

	@Override
	public String displayName() {
		return "Save ane Exit";
	}

	@Override
	public void perform() {
		((Persistable) library).save(fileName);
	}

	@Override
	public boolean isExit() {
		return true;
	}
}
