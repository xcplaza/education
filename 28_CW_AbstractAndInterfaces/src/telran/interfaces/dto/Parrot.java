package telran.interfaces.dto;

import java.util.Objects;

public class Parrot extends Bird implements IChirikable, ICroakable {
	String name;

	public Parrot() {
	}

	public Parrot(String subspecies, String name) {
		super(subspecies);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parrot [subspecies=" + subspecies + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Parrot))
			return false;
		Parrot other = (Parrot) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public void chirik() {
		System.out.println("Parrot say: Chirik Chirik");
	}

	@Override
	public void croak() {
		System.out.println("Parrot say: Chirik - ckaaaaar - chirik");
	}

}
