package telran.cars.cli.clerk;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetCarsByModelItel extends RentCompanyItem {

	public GetCarsByModelItel(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Get cars by model";
	}

	@Override
	public void perform() {
		List<String> models = company.getModelNames();
		String modelName = inOut.InputString("Model: " + models, models);
		inOut.outputLine(company.getModelCars(modelName));
	}

}
