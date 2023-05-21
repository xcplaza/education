import java.util.Objects;

public class SaleManager extends Employee {
	double totalSale; // объем продаж,(ставка + бонус)
	double bonus; // бонус в процентах

	public SaleManager() {
	}

	public SaleManager(String name, int age, boolean married, String company, String position, double baseSalary,
			double totalSale, double bonus) {
		super(name, age, married, company, position, baseSalary);
		if (totalSale >= 0.)
			this.totalSale = totalSale;
		else {
			System.out.println("No total sale!");
		}
		if (bonus >= 0. && bonus <=100.)
			this.bonus = bonus;
		else {
			System.out.println("No bonus!");
		}
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		if (totalSale >= 0.)
			this.totalSale = totalSale;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		if (bonus >= 0.)
			this.bonus = bonus;
	}

	public void display() {
		String str = ("TotalSale: " + totalSale + "\nBonus: " + bonus + "\n=================================\n");
		System.out.println(str);
	}

	public double calculateSalary() {
		return baseSalary + (totalSale * bonus/100);
	}

	@Override
	public String toString() {
		return super.toString() + ", Sale: " + totalSale + ", Bonus: " + bonus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bonus, totalSale);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SaleManager))
			return false;
		SaleManager other = (SaleManager) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Double.doubleToLongBits(totalSale) == Double.doubleToLongBits(other.totalSale);
	}

}
