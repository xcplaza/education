
public class Person {
//	public int age;
//	public String name;
//	public int id;

	private int age;
	private String name;
	private int id;

//	конструктор
	public Person(int age1, String name1, int id1) {
		if (age1 >= 0 && age1 <= 120)
			age = age1;
		else
			age = -1;
		if (name1 != null && !name1.isBlank())
			name = name1;
		else
			name = "No name";
		if (id1 > 0)
			id = id1;
	}

//	поведение
	public void dispaly() {
		System.out.println("Name: " + name + "\nAge: " + age + "\nID: " + id);
	}

//	получение данных геттеры начинаются с get!
	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

//	передача данных геттеры начинаются с set!
	public void setAge(int age1) {
		if (age1 >= 0 && age1 <= 120)
			age = age1;
	}

	public void setName(String name1) {
		if (name1 != null && !name1.isBlank())
			name = name1;
	}

}
