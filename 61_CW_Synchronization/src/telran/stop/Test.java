package telran.stop;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		StopableTestThread t = new StopableTestThread();
		t.start();
		Thread.sleep(5000);
		t.askStop();
	}

}
