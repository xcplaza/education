package telran.cars.cli.driver;

import java.util.List;

import telran.cars.dto.Driver;
import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetDriversByCarItem extends RentCompanyItem
{
	public GetDriversByCarItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayName()
	{
		return "Display drivers data having been driving a given car";
	}

	@Override
	public void perform()
	{
		String regNumber = getRegNumberIfNotExists();
		if (regNumber == null)
			return;
		
		List<Driver> drivers = company.getCarDrivers(regNumber);
		if (drivers.isEmpty())
		{
			inOut.outputLine("No drivers of car with number " + regNumber);
			return;
		}
		
		drivers.forEach(inOut::outputLine);
	}
}
