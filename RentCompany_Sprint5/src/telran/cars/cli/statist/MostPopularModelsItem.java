package telran.cars.cli.statist;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class MostPopularModelsItem extends RentCompanyItem {

	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 120;

	public MostPopularModelsItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Most popular models";
	}

	@Override
	public void perform() {
		LocalDate fromDate = inOut.inputDate("Enter from date yyyy-MM-dd", "yyyy-MM-dd");
		if (fromDate == null)
			return;
		LocalDate toDate = inOut.inputDate("Enter to date yyyy-MM-dd", "yyyy-MM-dd");
		if (toDate == null)
			return;
		Integer Age = inOut.inputInteger(String.format("Enter age from range [%d - %d]", MIN_AGE, MAX_AGE),
				MIN_AGE, MAX_AGE);
		if (Age == null)
			return;
		inOut.outputLine(company.getMostPopularCarModels(fromDate, toDate, Age, Age));
	}

}
