package telran.interfaces.dto;
import java.util.Objects;

public class Bird {
	String subspecies;

	public Bird() {
	}

	public Bird(String subspecies) {
		super();
		this.subspecies = subspecies;
	}

	public String getSubspecies() {
		return subspecies;
	}

	public void setSubspecies(String subspecies) {
		this.subspecies = subspecies;
	}

	@Override
	public String toString() {
		return "Bird [subspecies=" + subspecies + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(subspecies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Bird))
			return false;
		Bird other = (Bird) obj;
		return Objects.equals(subspecies, other.subspecies);
	}

}
