package telran.dto;
import java.util.Objects;

public abstract class MassMedia {
	String name;

	public MassMedia() {
	}

	public MassMedia(String name) {
		super();
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
		return "MassMedia [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MassMedia))
			return false;
		MassMedia other = (MassMedia) obj;
		return Objects.equals(name, other.name);
	}

	public abstract int getRating();

}
