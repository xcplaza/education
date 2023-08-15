import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBox {
	private String message;
	Lock lock;
	Condition producerWaitingCondition;
	Condition consumerWaitingCondition;

	public MessageBox() {
		lock = new ReentrantLock();
		producerWaitingCondition = lock.newCondition();
		consumerWaitingCondition = lock.newCondition();
	}

//	producer
	public void put(String message) {
		lock.lock();
		try {
			while (this.message != null) {
				try {
					producerWaitingCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.message = message;
			consumerWaitingCondition.signal();
		} finally {
			lock.unlock();
		}
	}

//	consumer
	public String take() throws InterruptedException {
		String res;
		lock.lock();
		try {
			while (this.message == null) {
				consumerWaitingCondition.await();
			}
			res = this.message;
			this.message = null;
			producerWaitingCondition.signal();
			return res;

		} finally {
			lock.unlock();
		}
	}

	public String pull() {
		lock.lock();
		try {
			String res = this.message;
			this.message = null;
			return res;
		} finally {
			lock.unlock();
		}
	}
}
