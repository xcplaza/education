package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveCarItem extends RentCompanyItem {

	public RemoveCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Remove car";
	}

	@Override
	public void perform() {
		inOut.outputLine(company.removeCar(getRegNumberIfNotExists()));
	}

}
