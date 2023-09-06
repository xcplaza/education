package telran.cars.cli.technitian;

import java.util.List;

import telran.cars.dto.RentRecord;
import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetRentRecordsAtDatesItem extends RentCompanyItem
{

	public GetRentRecordsAtDatesItem(InputOutput inputOutput, IRentCompany company)
	{
		super(inputOutput, company);
	}

	@Override
	public String displayedName()
	{
		return "Display records at dates";
	}

	@Override
	public void perform()
	{
		fillFromToDates();
		if(fromDate == null || toDate == null)
			return;
		
		List<RentRecord> res = company.getRentRecordsAtDates(fromDate, toDate);
		
		if(res.isEmpty())
		{
			inOut.outputLine("No records to display");
			return;
		}
		
		res.forEach(inOut::outputLine);
	}
}
