
public class MessageBox {
	private String message;

//	producer
	synchronized public void put(String message) {
		while (this.message != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		this.message = message;
		this.notify();
	}

//	consumer
	synchronized public String take() throws InterruptedException {
		while (this.message == null) {
				this.wait();
		}
		String res = this.message;
		this.message = null;
		this.notifyAll();
		return res;
	}

	public synchronized String pull() {
		String res = this.message;
		this.message = null;
		return res;
	}
}
