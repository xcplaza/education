package telran.interfaces.dto;
import java.util.Objects;

public class Crow extends Bird implements ICroakable{
	int age;

	public Crow() {
	}

	public Crow(String subspecies, int age) {
		super(subspecies);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Crow [subspecies=" + subspecies + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(age);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Crow))
			return false;
		Crow other = (Crow) obj;
		return age == other.age;
	}

	@Override
	public void croak() {
		System.out.println("Crow say: Kaaar");
	}

}
