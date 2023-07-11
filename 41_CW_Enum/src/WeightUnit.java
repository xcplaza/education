
public enum WeightUnit {
	GR(1), KG(1_000), TN(1_000_000);

	private double gramAmount;

	private WeightUnit(double gramAmount) {
		this.gramAmount = gramAmount;
	}

	double convert(WeightUnit other) {
		return gramAmount / other.gramAmount;
	}

}
