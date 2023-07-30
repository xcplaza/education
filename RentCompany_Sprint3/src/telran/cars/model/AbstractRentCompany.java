package telran.cars.model;

@SuppressWarnings("serial")
public abstract class AbstractRentCompany implements IRentCompany {
	protected int finePercent = 15;
	protected int gasPrice = 10;

	public int getFinePercent() {
		return finePercent;
	}

	@Override
	public void setFinePercent(int finePercent) {
		this.finePercent = finePercent;
	}

	@Override
	public int getGasPrice() {
		return gasPrice;
	}

	@Override
	public void setGasPrice(int gasPrice) {
		this.gasPrice = gasPrice;
	}

	@Override
	public String toString() {
		return "AbstractRentCompany [finePercent=" + finePercent + ", gasPrice=" + gasPrice + "]";
	}

}
