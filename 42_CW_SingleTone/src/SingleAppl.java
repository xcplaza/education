
public class SingleAppl {

	public static void main(String[] args) {
		MySingleTone obj1 = MySingleTone.ISTANCE;
		MySingleTone obj2 = MySingleTone.ISTANCE;
		obj1.dispaly();
		System.out.println(obj1 == obj2);

		MySingleTone2 obj3 = MySingleTone2.getInstance();
		MySingleTone2 obj4 = MySingleTone2.getInstance();
		obj3.dispaly();
		System.out.println(obj3 == obj4);
	}

}
