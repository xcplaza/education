package telran.cars.cli.manager;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveModelItem extends RentCompanyItem
{
	public RemoveModelItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Remove model";
	}

	@Override
	public void perform()
	{
		List<String> models = company.getModelNames();
		String modelName = inOut.inputString("Enter model name", models);
		if (modelName == null)
			return;
		
		company.removeCarsOfModel(modelName).forEach(inOut::outputLine);
	}
}
