
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

}
