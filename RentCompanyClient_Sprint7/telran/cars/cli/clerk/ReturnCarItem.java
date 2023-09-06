package telran.cars.cli.clerk;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class ReturnCarItem extends RentCompanyItem
{
	public ReturnCarItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Return car";
	}

	@Override
	public void perform()
	{
		String regNumber = getRegNumberIfExists();
		if (regNumber == null)
			return;
		
		Long licenseId = getLicenseIdIfExists();
		if (licenseId == null)
			return;
		
		if(!company.getCarsByDriver(licenseId).contains(company.getCar(regNumber)))
		{
			inOut.outputLine("This driver doesn't rent this car");
			return;
		}
		
		LocalDate returnDate = inOut.inputDate("Enter return date using format " + format, format);
		if (returnDate == null)
			return;
		
		Integer damages = inOut.inputInteger("Enter percent of damages", 0, 100);
		if (damages == null)
			return;
		
		Integer tankPercent = inOut.inputInteger("Enter tank percent", 0, 100);
		if (tankPercent == null)
			return;
		
		inOut.outputLine(company.returnCar(regNumber, licenseId, returnDate, damages, tankPercent));
	}
}
