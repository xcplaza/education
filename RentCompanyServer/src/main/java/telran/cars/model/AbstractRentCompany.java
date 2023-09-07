package telran.cars.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@SuppressWarnings("serial")
@ManagedResource
public abstract class AbstractRentCompany implements IRentCompany
{
	@Value("${finePercent:15}")
	protected int finePercent;

	@Value("${gasPrice:10}")
	protected int gasPrice;

	@ManagedAttribute
	public int getGasPrice()
	{
		return gasPrice;
	}
	@ManagedAttribute
	public void setGasPrice(int price)
	{
		this.gasPrice = price;
	}
	@ManagedAttribute
	public int getFinePercent()
	{
		return finePercent;
	}
	@ManagedAttribute
	public void setFinePercent(int finePercent)
	{
		this.finePercent = finePercent;
	}
	
	protected double computeCost(int rentPrice, int rentDays, int delay, int tankPercent, int tankVolume)
	{
		double cost = rentPrice*rentDays;
		if(delay > 0)
			cost += delay * (rentPrice * (1 + (double) finePercent / 100));
		if(tankPercent < 100)
			cost += tankVolume * ((double) (100 - tankPercent) / 100) * gasPrice;
		return cost;
	}
}
