package telran.cars.cli.manager;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveModelItem extends RentCompanyItem {

	public RemoveModelItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Remove model";
	}

	@Override
	public void perform() {
		List<String> models = company.getModelNames();
		String modelName = inOut.InputString("Enter model from" + models, models);
		if (modelName == null)
			return;
		inOut.outputLine(company.removeModel(modelName));
	}

}
