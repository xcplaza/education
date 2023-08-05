package telran.cars.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Model implements Serializable
{
	private String modelName;
	private int gasTank;
	private String company;
	private String country;
	private int priceDay;
	
	public int getPriceDay()
	{
		return priceDay;
	}

	@Override
	public String toString()
	{
		return "Model [modelName=" + modelName + ", gasTank=" + gasTank + ", company=" + company + ", country="
				+ country + ", priceDay=" + priceDay + "]";
	}

	public void setPriceDay(int priceDay)
	{
		this.priceDay = priceDay;
	}

	public String getModelName()
	{
		return modelName;
	}

	public int getGasTank()
	{
		return gasTank;
	}

	public String getCompany()
	{
		return company;
	}

	public String getCountry()
	{
		return country;
	}

	public Model()
	{
		// TODO Auto-generated constructor stub
	}

	public Model(String modelName, int gasTank, String company, String country, int priceDay)
	{
		super();
		this.modelName = modelName;
		this.gasTank = gasTank;
		this.company = company;
		this.country = country;
		this.priceDay = priceDay;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (modelName == null)
		{
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}
	
	
}
