package telran.cars.cli;

import java.time.LocalDate;

import telran.cars.model.IRentCompany;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class RentCompanyItem implements Item
{
	protected InputOutput inOut;
	protected IRentCompany company;
	
	protected String format = "dd/MM/yyyy";
	protected LocalDate fromDate;
	protected LocalDate toDate;
	
	public RentCompanyItem(InputOutput inOut, IRentCompany company)
	{
		super();
		this.inOut = inOut;
		this.company = company;
	}
	
	public String getRegNumberIfNotExists()
	{
		String regNumber = inOut.inputString("Enter new registration number");
		if(regNumber == null)
			return null;
		if(company.getCar(regNumber) != null)
		{
			inOut.outputLine("Car already exsists");
			return null; 
		}
		return regNumber;
	}
	
	public Long getLicenseIdIfNotExists()
	{
		Long licenseId = inOut.inputLong("Enter license id");
		if(licenseId == null)
			return null;
		if(company.getDriver(licenseId) != null)
		{
			inOut.outputLine("Driver is already exists");
			return null;
		}
		return licenseId;
	}

	public String getRegNumberIfExists()
	{
		String regNumber = inOut.inputString("Enter new registration number");
		if(regNumber == null)
			return null;
		if(company.getCar(regNumber) == null)
		{
			inOut.outputLine("Car is not exists");
			return null; 
		}
		return regNumber;
	}
	
	public Long getLicenseIdIfExists()
	{
		Long licenseId = inOut.inputLong("Enter license id");
		if(licenseId == null)
			return null;
		if(company.getDriver(licenseId) == null)
		{
			inOut.outputLine("Driver is not exists");
			return null;
		}
		return licenseId;
	}
	
	protected void fillFromToDates()
	{
		fromDate = inOut.inputDate("Enter date from using format " + format, format);
		if(fromDate == null)
			return;
		
		toDate = inOut.inputDate("Enter date to using format " + format, format);
		if(toDate == null)
			return;
		
		if(fromDate.isAfter(toDate))
		{
			inOut.outputLine("Date from can`t be after date to");
			fromDate = toDate = null;
			return;
		}
	}
}



