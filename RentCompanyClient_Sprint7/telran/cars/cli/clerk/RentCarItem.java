package telran.cars.cli.clerk;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RentCarItem extends RentCompanyItem
{

	public RentCarItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	private static final int MIN_RENT_DAYS = 1;
	private static final int MAX_RENT_DAYS = 30;

	@Override
	public String displayedName()
	{
		return "Rent car";
	}

	@Override
	public void perform()
	{
		String regNumber = getRegNumberIfExists();
		if(regNumber == null)
			return;
		
		if(company.getCar(regNumber).isUse())
		{
			inOut.outputLine("Car is already in use");
			return;
		}
		
		Long licenseId = getLicenseIdIfExists();
		if(licenseId == null)
			return;
		
		LocalDate rentDate = inOut.inputDate("Enter rent date using format " + format, format);
		if(rentDate == null)
			return;
		
		Integer rentDays = inOut.inputInteger(String.format("Enter rent days from range [%d-%d]", 
				MIN_RENT_DAYS, MAX_RENT_DAYS), MIN_RENT_DAYS, MAX_RENT_DAYS);
		if(rentDays == null)
			return;
		
		inOut.outputLine(company.rentCar(regNumber, licenseId, rentDate, rentDays));
	}

}
