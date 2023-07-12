
public class Lenght {
	private double number;
	private LenghtUnit unit;

	public Lenght(double number, LenghtUnit unit) {
		super();
		this.number = number;
		this.unit = unit;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public LenghtUnit getUnit() {
		return unit;
	}

	public void setUnit(LenghtUnit unit) {
		this.unit = unit;
	}

	public String toString() {
		return "" + number + unit;
	}

	public Lenght plus(Lenght otherLenght) {
		Lenght convLenght = otherLenght.convert(unit);
		return new Lenght(number + convLenght.number, unit);
	}

	public Lenght convert(LenghtUnit otherUnit) {
		return new Lenght(number * unit.getValue() / otherUnit.getValue(), otherUnit);
	}
	
	public Lenght minus(Lenght otherLenght) {
		Lenght convLenght = otherLenght.convert(unit);
		return new Lenght(convLenght.number - number, unit);
//		return plus(new Lenght(-lenght.number, lenght.unit))
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(number);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Lenght))
			return false;
		Lenght other = (Lenght) obj;
		if (Double.doubleToLongBits(number) != Double.doubleToLongBits(other.number))
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}
}
