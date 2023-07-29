package telran.abst.dto;

import java.util.Objects;

public abstract class Pet extends Animal {
	boolean trained;

	public Pet() {
	}

	public Pet(String name, int age, boolean gender, boolean trained) {
		super(name, age, gender);
		this.trained = trained;
	}

	public boolean isTrained() {
		return trained;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", gender=" + gender + ", trained=" + trained + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(trained);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Pet))
			return false;
		Pet other = (Pet) obj;
		return trained == other.trained;
	}
}
