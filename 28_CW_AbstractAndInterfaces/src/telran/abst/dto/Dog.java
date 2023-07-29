package telran.abst.dto;

import java.util.Objects;

public class Dog extends Pet {
	String breed;

	public Dog() {
	}

	public Dog(String name, int age, boolean gender, boolean trained, String breed) {
		super(name, age, gender, trained);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [trained=" + trained + ", name=" + name + ", age=" + age + ", gender=" + gender + ", breed=" + breed
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(breed);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(breed, other.breed);
	}

	@Override
	public void voice() {
		System.out.println(name + " say: Gav - gav");
	}

}
