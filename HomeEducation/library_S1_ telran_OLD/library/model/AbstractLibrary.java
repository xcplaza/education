package telran.library.model;

@SuppressWarnings("serial")
public abstract class AbstractLibrary implements ILibrary {
	protected int maxPickPeriod = 30;
	protected int minPickPeriod = 3;

	public int getMaxPickPeriod() {
		return maxPickPeriod;
	}

	public void setMaxPickPeriod(int maxPickPeriod) {
		this.maxPickPeriod = maxPickPeriod;
	}

	public int getMinPickPeriod() {
		return minPickPeriod;
	}

	public void setMinPickPeriod(int minPickPeriod) {
		this.minPickPeriod = minPickPeriod;
	}

	@Override
	public String toString() {
		return "AbstractLibrary [maxPickPeriod=" + maxPickPeriod + ", minPickPeriod=" + minPickPeriod + "]";
	}

}
