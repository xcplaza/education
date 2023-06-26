import java.util.Objects;

public class Cats implements Comparable<Cats>{
	String name;
	int age;
	String color;
	double price;

	public Cats() {
	}

	public Cats(String name, int age, String color, double price) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cats))
			return false;
		Cats other = (Cats) obj;
		return age == other.age && Objects.equals(color, other.color) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "Cats [name=" + name + ", age=" + age + ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Cats o) {
		/*
		 * this > o -> +
		 * this = o -> 0
		 * this < o -> -
		 */ 
//		return this.age - o.age; // прамая сортировка
//		return o.age - this.age; // обратная сортировка
//		return Integer.compare(this.age, o.age); // сравнение по возрасту
//		return name.compareTo(o.name); // прамая сортировка по имени
//		return o.name.compareTo(this.name); // обратная сортировка по имени
		
//		return (int) (this.price - o.price); - WRONG!
//		=================================================
//		if(this.price > o.price)
//			return 1;
//		else if(this.price < o.price)
//			return -1;
//		else
//			return 0;
//		=================================================
//		return Double.compare(this.price, o.price);
//		=================================================
		int res = this.age - o.age;
		return res == 0 ? Double.compare(o.price, this.price) : res;
	}
}
