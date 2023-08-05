package telran.cars.cli.clerk;

import java.util.List;

import telran.cars.dto.Car;
import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.*;

public class GetModelCarsItem extends RentCompanyItem
{
	public GetModelCarsItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Display free cars of a given car model";
	}

	@Override
	public void perform()
	{
		List<String> modelNames = company.getModelNames();
		String modelName = inOut.inputString("Enter model name from " + modelNames, modelNames);
		if (modelName == null)
			return;

		List<Car> models = company.getCarsByModel(modelName);
		if (models.isEmpty())
		{
			inOut.outputLine("No cars of " + modelName);
			return;
		}

		models.forEach(inOut::outputLine);
	}
}
