package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Driver;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class AddDriverItem extends RentCompanyItem {

	public AddDriverItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Add driver";
	}

	@Override
	public void perform() {
		Long licenseId = inOut.inputLong("Enter license ID");
		if (licenseId == null)
			return;
		String driverName = inOut.inputString("Enter name driver");
		if (driverName == null)
			return;
		Integer birdthYear = inOut.inputInteger("Enter birdth year driver");
		if (birdthYear == null)
			return;
		String phoneNumber = inOut.inputString("Enter phone number");
		if (phoneNumber == null)
			return;
		Driver driver = new Driver(licenseId, driverName, birdthYear, phoneNumber);
		inOut.outputLine(company.addDriver(driver));
	}

}
