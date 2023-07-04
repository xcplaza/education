package telran.treeSetAppl;
import java.util.Objects;

public class Cat implements Comparable<Cat> {
	private int age;
	private String name;
	private int id;

	public Cat() {
	}

	public Cat(int age, String name, int id) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cat age=" + age + ", name=" + name + ", id=" + id ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Cat o) {
		int res = name.compareTo(o.name);
		return res == 0 ? id - o.id : res;
	}

}
