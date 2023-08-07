
public class Cat implements Runnable {
	private String name;
	private char sex;
	private int myau;

	public Cat(String name, char sex, int myau) {
		super();
		this.name = name;
		this.sex = sex;
		this.myau = myau;
	}

	@Override
	public void run() {
		for (int i = 0; i < myau; i++) {
			if (sex == 'M')
				System.out.println("Cat " + name + " say myau");
			else
				System.out.println("Pussy cat " + name + " say myau");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
