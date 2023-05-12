
public class Employee {
	private String company;
	private double baseSalary;
	private int position;
	private String name;
	private int id;
	private int age;

	public Employee() {};

	public Employee(String company, double baseSalary, int position, String name, int id, int age) {
		this.company = company;
		this.baseSalary = baseSalary;
		this.position = position;
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		if (company != null && !company.isEmpty())
			this.company = company;
		else
			this.company = "No company!";
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 6000. || baseSalary > 50000.)
			this.baseSalary = baseSalary;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		if (position < 1 || position > 7)
			this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty())
			this.name = name;
		else
			this.name = "No name!";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 18 || age > 80)
			this.age = age;
	}

	public int getId() {
		return id;
	}

	public int salary() {
		int str = position;
		int sumSalary = (int) baseSalary;

		switch (str) {
		case 1:
			sumSalary = (int) (baseSalary + baseSalary * 0.1);
			break;
		case 2:
			sumSalary = (int) (baseSalary + baseSalary * 0.15);
			break;
		case 3:
			sumSalary = (int) (baseSalary + baseSalary * 0.2);
			break;
		case 4:
			sumSalary = (int) (baseSalary + baseSalary * 0.25);
			break;
		case 5:
			sumSalary = (int) (baseSalary + baseSalary * 0.3);
			break;
		case 6:
			sumSalary = (int) (baseSalary + baseSalary * 0.35);
			break;
		default:
			sumSalary = (int) baseSalary;
			break;
		}
		return sumSalary;
	}

	public void display() {
		String str = ("Company: " + company + "\nPosition: " + position + "\nName: " + name + "\nId: " + id + "\nAge: "
				+ age + "\n----------------------------\n");
		System.out.println(str);
	}

	public void display(boolean tax) {
		String res;
		if (!tax) {
			res = ("Company: " + company + "\nSalary: " + salary() + "\nPosition: " + position + "\nName: " + name
					+ "\nId: " + id + "\nAge: " + age + "\n----------------------------\n");
		} else {
			res = ("Company: " + company + "\nSalary: " + (salary() - (salary() * 0.3)) + "\nPosition: " + position
					+ "\nName: " + name + "\nId: " + id + "\nAge: " + age + "\n----------------------------\n");
		}
		System.out.println(res);
	}

}
