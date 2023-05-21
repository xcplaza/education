
public class Person {
	String name;
	int age;
	boolean married;

	public Person() {
	}

	public Person(String name, int age, boolean married) {
		super();
		if (name != null && !name.isBlank())
			this.name = name;
		else {
			System.out.println("No name!");
		}
		if (age >= 0 && age <= 120)
			this.age = age;
		else {
			System.out.println("No age!");
		}
		setMarried(married);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isBlank())
			this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 120)
			this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public void display() {
		String str = ("Name: " + name + "\nAge: " + age + "\nMarried: " + married
				+ "\n=================================\n");
		System.out.println(str);
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Married: " + married;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (married ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (married != other.married)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
