package telran.cars.cli;

import telran.cars.model.IRentCompany;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class RentCompanyItem implements Item {
	protected InputOutput inOut;
	protected IRentCompany company;

	public RentCompanyItem(InputOutput inOut, IRentCompany company) {
		super();
		this.inOut = inOut;
		this.company = company;
	}

	public String getRegNumberIfNotExist() {
		String regNumber = inOut.inputString("Enter new registration number");
		if (regNumber == null)
			return null;
		if (company.getCar(regNumber) != null) {
			inOut.outputLine("Car already exists");
			return null;
		}
		return regNumber;
	}
}
