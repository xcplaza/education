package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveCarItem extends RentCompanyItem
{
	public RemoveCarItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Remove car item";
	}

	@Override
	public void perform()
	{
		String regNumber = getRegNumberIfExists();
		if (regNumber == null)
			return;
		
		inOut.outputLine(company.removeCar(regNumber));
	}
}
