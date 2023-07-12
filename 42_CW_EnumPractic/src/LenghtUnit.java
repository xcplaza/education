
public enum LenghtUnit {

	MM(1), CM(10), IN(25.4), FT(304.8), M(1000);

	private double value;

	private LenghtUnit(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public double between(Lenght l1, Lenght l2) {
		double distanceMM = getLenghtInMM(l2) - getLenghtInMM(l1);
		return distanceMM / value;
	}

	private double getLenghtInMM(Lenght lenght) {
		return lenght.getNumber() * lenght.getUnit().getValue();
	}
}
