
public class Person {
	String name;
	int age;
	String surname;
	String title;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String surname, String title) {
		super();
		this.surname = surname;
		this.title = title;
	}

	public Person(int age, String surname) {
		super();
		this.age = age;
		this.surname = surname;
	}
//reflection error	- public Person (int.class, String.class)
	
//	public Person(int age, String title) {
//		super();
//		this.age = age;
//		this.title = title;
//	}

	
}
