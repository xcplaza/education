
public class CatsAppl {
	private static final int N_MYAU = 4;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Cat cat1 = new Cat("Bogdana", 'F', N_MYAU);
		Cat cat2 = new Cat("Leopold", 'M', N_MYAU);
		Cat cat3 = new Cat("Snow", 'M', N_MYAU);
		Cat cat4 = new Cat("Pussy", 'F', N_MYAU);

//		no multi threads
		cat1.run();
		cat2.run();
		cat3.run();
		cat4.run();

		System.out.println("==========================");

//		start multi threads
		Thread t1 = new Thread(cat1);
		Thread t2 = new Thread(cat2);
		Thread t3 = new Thread(cat3);
		Thread t4 = new Thread(cat4);
		Thread[] cats = { t1, t2, t3, t4 };
		for (Thread t : cats) {
			t.start();
			System.out.println(t.getName());
			System.out.println(t.getId());
//			t.setName("111111111");
//			System.out.println(t.getName());
			System.out.println(t.getName() + " " + t.isAlive());
		}
		System.out.println("==========================");
		boolean res = cats[0].isAlive();
		System.out.println(res);

		System.out.println("==========================");
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("t1 " + t1.getPriority());
	}

}
