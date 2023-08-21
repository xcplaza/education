
public class Point implements Cloneable {
	int x;
	int y;

	public Point() {
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

//	Стандартный clone
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

//	public Object clone() {
//		Point point = new Point();
//		point.x = this.x;
//		point.y = this.y;
//		return point;
//	}
}
