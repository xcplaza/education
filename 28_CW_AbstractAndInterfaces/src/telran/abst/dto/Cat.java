package telran.abst.dto;

import java.util.Objects;

public class Cat extends Pet {
	String color;

	public Cat() {
	}

	public Cat(String name, int age, boolean gender, boolean trained, String color) {
		super(name, age, gender, trained);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [trained=" + trained + ", name=" + name + ", age=" + age + ", gender=" + gender + ", color=" + color
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(color);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(color, other.color);
	}
	
	@Override
	public void voice() {
		System.out.println(name + " say: Myaauu");
	}

}
