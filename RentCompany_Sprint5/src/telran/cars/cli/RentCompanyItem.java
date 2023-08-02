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

}
