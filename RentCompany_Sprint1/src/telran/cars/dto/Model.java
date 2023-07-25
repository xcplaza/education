package telran.cars.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Model implements Serializable {
	private String modelName;
	private int gasTank;
	private String company;
	private String counrty;
	private int priceDay;

	public Model() {
	}

	public Model(String modelName, int gasTank, String company, String counrty, int priceDay) {
		super();
		this.modelName = modelName;
		this.gasTank = gasTank;
		this.company = company;
		this.counrty = counrty;
		this.priceDay = priceDay;
	}

	public int getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(int priceDay) {
		this.priceDay = priceDay;
	}

	public String getModelName() {
		return modelName;
	}

	public int getGasTank() {
		return gasTank;
	}

	public String getCompany() {
		return company;
	}

	public String getCounrty() {
		return counrty;
	}

	@Override
	public String toString() {
		return "Model [modelName=" + modelName + ", gasTank=" + gasTank + ", company=" + company + ", counrty="
				+ counrty + ", priceDay=" + priceDay + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Model))
			return false;
		Model other = (Model) obj;
		return Objects.equals(modelName, other.modelName);
	}

}
