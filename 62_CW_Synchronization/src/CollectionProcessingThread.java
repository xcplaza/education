import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CollectionProcessingThread extends Thread {
	private Collection<Integer> collection;
	private int nRuns;
	private int proUpdate;

	private static ReentrantReadWriteLock lock;
	private static Lock readLock;
	private static Lock writeLock;
	public static AtomicLong countLock = new AtomicLong();

	static {
		lock = new ReentrantReadWriteLock();
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}

	public CollectionProcessingThread(Collection<Integer> collection, int nRuns, int proUpdate) {
		super();
		this.collection = collection;
		this.nRuns = nRuns;
		this.proUpdate = proUpdate;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			if (getRandomNumber(1, 100) <= proUpdate)
				update();
			else
				read();
		}
	}

	private void read() {
		tryDoLock(readLock);
		try {
			collection.forEach(n -> getRandomNumber(1, n));
		} finally {
			readLock.unlock();
			;
		}
	}

	private void tryDoLock(Lock lock) {
		while (!lock.tryLock()) {
			countLock.getAndIncrement();
		}
	}

	private void update() {
		tryDoLock(writeLock);
		try {
			int number = getRandomNumber(1, 100);
			collection.add(number);
			collection.remove(number);
		} finally {
			writeLock.unlock();
			;
		}
	}

	private int getRandomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
