package telran.cars.cli.statist;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostProfitableModelsItem extends RentCompanyItem
{
	public GetMostProfitableModelsItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Most profitable model names";
	}

	@Override
	public void perform()
	{
		fillFromToDates();
		if (fromDate == null || toDate == null)
			return;
		
		List<String> models = company.getMostProfitableCarModels(fromDate, toDate);
		if (models.isEmpty())
		{
			inOut.outputLine("no models");
			return;
		}
		
		models.forEach(inOut::outputLine);
	}
}
