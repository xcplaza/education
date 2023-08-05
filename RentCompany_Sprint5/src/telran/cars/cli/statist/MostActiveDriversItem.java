package telran.cars.cli.statist;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Driver;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class MostActiveDriversItem extends RentCompanyItem {

	public MostActiveDriversItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Most active drivers";
	}

	@Override
	public void perform() {
		List<Driver> activeDrivers = company.getMostActiveDriver();
		if (activeDrivers.isEmpty() || activeDrivers == null)
			return;
		inOut.outputLine(company.getMostActiveDriver());
	}

}
