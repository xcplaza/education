package telran.employee.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CompanySalary implements Serializable
{
	private String companyName;
	private double avgSalary;

	public CompanySalary()
	{
		// TODO Auto-generated constructor stub
	}

	public CompanySalary(String companyName, double avgSalary)
	{
		super();
		this.companyName = companyName;
		this.avgSalary = avgSalary;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public double getAvgSalary()
	{
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary)
	{
		this.avgSalary = avgSalary;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
		CompanySalary other = (CompanySalary) obj;
		if (Double.doubleToLongBits(avgSalary) != Double.doubleToLongBits(other.avgSalary))
			return false;
		if (companyName == null)
		{
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "CompanySalary [companyName=" + companyName + ", avgSalary=" + avgSalary + "]";
	}

}
