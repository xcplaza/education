package telran.cars.cli.statist;

import java.util.List;

import telran.cars.dto.Driver;
import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostActiveDriversItem extends RentCompanyItem
{

	public GetMostActiveDriversItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Display most active drivers";
	}

	@Override
	public void perform()
	{
		List<Driver> drivers = company.getMostActiveDriver();
		if (drivers.isEmpty())
		{
			inOut.outputLine("No drivers to display");
			return;
		}
		
		drivers.forEach(inOut::outputLine);
	}
}
