
public abstract class GroupSum {
	protected int[][] number; // мешки с гранатами

	public abstract long computeSum();

	public GroupSum(int[][] number) {
		super();
		this.number = number;
	}

	public int[][] getNumber() {
		return number;
	}

	public void setNumber(int[][] number) {
		this.number = number;
	}

		
}
