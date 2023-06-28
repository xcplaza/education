
public class ForEachAppl {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6 };
		for (Integer n : ar) {
			System.out.println(n + " ");
		}
		System.out.println();
		int sum = 0;
		for (Integer n : ar) {
			sum += n;
		}
		System.out.println(sum);
//		=====================================
		MyString ms = new MyString("Hello");
		for (Character c : ms) {
			System.out.print(c + " ");
		}
		System.out.println();
//		=====================================
//		ms.remove('l');
//		System.out.println(ms.getStr());

//		for (Character character : ms) {
//			if (character == 'l')
//				ms.remove(character);
//		}
//		System.out.println(ms.getStr());
//	}

		MyStringIterator iter = (MyStringIterator) ms.iterator();
		while (iter.hasNext()) {
			if (iter.next() == 'l')
				iter.remove();
		}
		System.out.println(ms.getStr());

		MyStringIteratorRevers iter2 = new MyStringIteratorRevers(new MyString("Hello2").getStrBuild());
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + " ");
		}
		System.out.println();
	}
}
