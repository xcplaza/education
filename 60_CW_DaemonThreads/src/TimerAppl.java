
public class TimerAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
//		timer.setDaemon(true);
		timer.setTimeFormate("HH:mm:ss a");
		timer.start();
		Thread.sleep(5000);
		System.out.println(timer.isInterrupted());
		timer.interrupt();
		Thread.sleep(2000);
		System.out.println(timer.isInterrupted());
		Thread.sleep(5000);
		
		timer = new Timer();
		timer.start();
		Thread.sleep(5000);
	}

}
