
public class MyListAppl {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list .add(1);
		list.add(null);
		System.out.println(list.indexOf(1));
		System.out.println(list.indexOf(null));
		System.out.println(list.indexOf(2));
	}

}
