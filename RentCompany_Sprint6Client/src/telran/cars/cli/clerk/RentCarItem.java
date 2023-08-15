package telran.cars.cli.clerk;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RentCarItem extends RentCompanyItem {
	private static final int MIN_DAYS = 1;
	private static final int MAX_DAYS = 365;

	public RentCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Rent car";
	}

	@Override
	public void perform() {
		
		String regNumber = getRegNumberIfNotExists();
		if (regNumber == null)
			return;
		Long licenseId = inOut.inputLong("Enter licence ID");
		if (licenseId == null)
			return;
		LocalDate rentDate = LocalDate.now();
		if (rentDate == null)
			return;
		Integer rentDays = inOut.inputInteger(String.format("Enter rent day from range [%d - %d]", MIN_DAYS, MAX_DAYS),
				MIN_DAYS, MAX_DAYS);
		if (rentDays == null)
			return;
		inOut.outputLine(company.rentCar(regNumber, licenseId, rentDate, rentDays));
	}

}
