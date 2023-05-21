import java.util.Objects;

public class WageEmployee extends Employee {
	double hours;
	double wage; // часовая ставка

	public WageEmployee() {
	}

	public WageEmployee(String name, int age, boolean married, String company, String position, double baseSalary,
			double hours, double wage) {
		super(name, age, married, company, position, baseSalary);
		if (hours >= 0.)
			this.hours = hours;
		else {
			System.out.println("No hours!");
		}
		if (wage >= 0.)
			this.wage = wage;
		else {
			System.out.println("No wage!");
		}
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours >= 0.)
			this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage >= 0.)
			this.wage = wage;
	}

	public void display() {
		String str = ("Hours: " + hours + "\nWage: " + wage + "\n=================================\n");
		System.out.println(str);
	}

	public double calculateSalary() {
		return baseSalary + (hours * wage);
	}

	@Override
	public String toString() {
		return super.toString() + ", WageEmployee: " + hours + ", Wage: " + wage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hours, wage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof WageEmployee))
			return false;
		WageEmployee other = (WageEmployee) obj;
		return Double.doubleToLongBits(hours) == Double.doubleToLongBits(other.hours)
				&& Double.doubleToLongBits(wage) == Double.doubleToLongBits(other.wage);
	}

}
