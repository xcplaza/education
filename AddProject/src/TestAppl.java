import java.util.List;
import java.util.stream.Stream;

public class TestAppl {

	public static void main(String[] args) {
		Condition condition = new Condition();
		Runnable r = () -> {
			condition.barrier();
			System.out.println("Worker: " + Thread.currentThread().threadId());
		};
		@SuppressWarnings("unused")
		List<Thread> list = Stream.generate(() -> new Thread(r)).limit(Condition.THREADS_COUNT).peek(Thread::start)
				.toList();
	}

}
