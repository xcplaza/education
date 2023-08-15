package telran.cars.cli;

import java.time.LocalDate;
import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class ReturnCarItem extends RentCompanyItem {

	public ReturnCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Return car";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfNotExist();
		if (regNumber == null)
			return;
		List<Long> license = company.getLicenseDriver();
		if (license == null)
			return;
		if (license.isEmpty()) {
			System.out.println("License driver is empty!");
			return;
		}
		Long licenseId = inOut.inputLong("Enter license ID" + license);
		if (licenseId == null)
			return;
		LocalDate localDate = LocalDate.now();
		if (localDate == null)
			return;
		Integer damages = inOut.inputInteger("Enter damages");
		if (damages == null)
			return;
		Integer tankPercent = inOut.inputInteger("Enter tank percent");
		if (tankPercent == null)
			return;
		inOut.outputLine(company.returnCar(regNumber, licenseId, localDate, damages, tankPercent));
	}

}
