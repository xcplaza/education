package telran.cars.cli.statist;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostPopularModelsItem extends RentCompanyItem
{
	
	private static final int AGE_FROM = 18;
	private static final int AGE_TO = 90;
	
	public GetMostPopularModelsItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Display most popular model names";
	}

	@Override
	public void perform()
	{
		fillFromToDates();
		if (fromDate == null || toDate == null)
			return;
		
		Integer fromAge = inOut.inputInteger(String.format("Enter age from in range %d-%d", AGE_FROM, AGE_TO), 
				AGE_FROM, AGE_TO);
		if (fromAge == null)
			return;
		
		Integer toAge = inOut.inputInteger(String.format("Enter age to in range %d-%d",AGE_FROM, AGE_TO), 
				AGE_FROM, AGE_TO);
		if (toAge == null)
			return;
		
		if (fromAge > toAge)
		{
			inOut.outputLine("\"from\" age can't be greater than \"to\"");
			return;
		}
		
		List<String> models = company.getMostPopularCarModels(fromDate, toDate, fromAge, toAge);
		if (models.isEmpty())
		{
			inOut.outputLine("No models to display");
			return;
		}
		
		models.forEach(inOut::outputLine);
	}
}
