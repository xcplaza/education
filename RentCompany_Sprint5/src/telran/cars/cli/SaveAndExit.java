package telran.cars.cli;

import telran.cars.model.IRentCompany;
import telran.util.Persistable;
import telran.view.InputOutput;

public class SaveAndExit extends RentCompanyItem {
	String fileName;

	public SaveAndExit(InputOutput inOut, IRentCompany company, String fileName) {
		super(inOut, company);
		this.fileName = fileName;
	}

	@Override
	public String displayName() {
		return "Save ane Exit";
	}

	@Override
	public void perform() {
		((Persistable) company).save(fileName);
	}

	@Override
	public boolean isExit() {
		return true;
	}
}
