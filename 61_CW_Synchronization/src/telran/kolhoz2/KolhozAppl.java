package telran.kolhoz2;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class KolhozAppl {
	private static final int N_TRACKS = 1000;
	private static final int LOAD = 1;
	private static final int N_LOADS = 1000;

	public static void main(String[] args) {
		Truck[] trucks = new Truck[N_TRACKS];
		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = new Truck(LOAD, N_LOADS);
			trucks[i].start();
		}
		Instant start = Instant.now();
		for (Truck t : trucks) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.printf("Runnig time is %d\nelevator 1 contains %d tons\nelevator 2 contains %d tons",
				ChronoUnit.MILLIS.between(start, Instant.now()), Truck.getElev1(), Truck.getElev2());
	}

}
