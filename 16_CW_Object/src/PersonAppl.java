
public class PersonAppl {

	public static void main(String[] args) {
//		Person p = new Person();
//		System.out.println(p.age);
//		System.out.println(p.id);
//		System.out.println(p.name);
//
//		p.age = 33;
//		p.id = 1234567;
//		p.name = "Peter";

//		System.out.println(p.age);
//		System.out.println(p.id);
//		System.out.println(p.name);

		Person p = new Person(40, "Ivan", 33222);
		p.dispaly();

		Person masha = new Person(29, "Masha", 1234);
		masha.dispaly();

//		p.age = 2345;
		p.setAge(23);
		p.dispaly();

		Person igor = new Person(-100, null, -123456);
		igor.dispaly();

	}

}
