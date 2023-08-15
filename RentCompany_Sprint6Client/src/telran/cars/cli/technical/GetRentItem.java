package telran.cars.cli.technical;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetRentItem extends RentCompanyItem {

	public GetRentItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayName() {
		return "Get rent records at dates";
	}

	@Override
	public void perform() {
		LocalDate fromDate = null;
		LocalDate toDate = null;
		inOut.outputLine(company.getRentRecordsAtDates(fromDate, toDate));
	}

}
