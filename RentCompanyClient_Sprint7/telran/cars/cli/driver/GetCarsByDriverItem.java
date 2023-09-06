package telran.cars.cli.driver;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Car;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetCarsByDriverItem extends RentCompanyItem
{

	public GetCarsByDriverItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Display cars data driving a given driver";
	}

	@Override
	public void perform()
	{
		Long licenseId = getLicenseIdIfExists();
		if(licenseId == null)
			return;
		
		List<Car> res = company.getCarsByDriver(licenseId);
		if (res.isEmpty())
		{
			inOut.outputLine("No cars rented this driver");
			return;
		}
		res.forEach(inOut::outputLine);
	}
}
