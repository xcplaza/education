import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	private long timeUnit = 1000;
	private String timeFormate = "HH:mm:ss";

	public Timer() {
		setDaemon(true);
	}

	public void setTimeUnit(long timeUnit) {
		this.timeUnit = timeUnit;
	}

	public void setTimeFormate(String timeFormate) {
		this.timeFormate = timeFormate;
	}

	@Override
	public void run() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timeFormate);
		LocalTime lt = null;
		while (true) {
			lt = LocalTime.now();
			System.out.println(lt.format(dtf));
			try {
				sleep(timeUnit);
			} catch (InterruptedException e) {
				break;
			}
		}

	}
}
