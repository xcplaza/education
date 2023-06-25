import java.lang.reflect.Array;
import java.util.Arrays;

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
//		============================================

		Pair<String, Integer> pair1 = new Pair<String, Integer>("Hello", 10);
		String str2 = pair1.getKey();
		Integer num2 = pair1.getValue();
		pair1.setKey("Bye");
		pair1.setValue(123);

		Pair<String, String> pair2 = new Pair<String, String>("Black", "Orange");
		System.out.println(pair2.getKey() + " : " + pair2.getValue());
//		============================================

		Pair<int[], String> pair3 = new Pair<int[], String>(new int[] { 1, 2, 3 }, "Ba");
		System.out.println(Arrays.toString(pair3.getKey()) + pair3.getValue());

		Pair<String, String> pair4 = new Pair<String, String>("White", "Banana");
		boolean res = compare(pair2, pair4);
		System.out.println(res);
	}

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

}
