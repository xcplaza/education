package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class CompanySalary implements Serializable {
	private String companyName;
	private double avgSalary;

	public CompanySalary() {
	}

	public CompanySalary(String companyName, double avgSalary) {
		super();
		this.companyName = companyName;
		this.avgSalary = avgSalary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}

	@Override
	public String toString() {
		return "CompanySalary [companyName=" + companyName + ", avgSalary=" + avgSalary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CompanySalary))
			return false;
		CompanySalary other = (CompanySalary) obj;
		return Objects.equals(companyName, other.companyName);
	}

}
