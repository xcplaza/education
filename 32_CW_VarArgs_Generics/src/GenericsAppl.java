
public class GenericsAppl {

	public static void main(String[] args) {
		Box<String> box1 = new Box<String>("Hello");
		String str = box1.getValue();
		System.out.println(str);
		box1.setValue("Preved");
		System.out.println(box1.getValue());
//		box1.setValue(10);
		System.out.println(str);
//		============================================

		Box<Integer> box2 = new Box<Integer>(10);
		Integer num = box2.getValue();
		System.out.println(num + 10);
		box2.setValue(100500);
		System.out.println(box2.getValue() + 10);
	}

}
