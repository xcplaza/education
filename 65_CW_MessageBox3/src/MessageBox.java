
public class MessageBox {
	private String message;
	private Object monitor = new Object();

//	producer
	public void put(String message) {
		synchronized (this) {
			while (this.message != null) {
				try {
					this.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			this.message = message;

		}
		synchronized (monitor) {
			monitor.notify();
		}
	}

//	consumer
	public String take() throws InterruptedException {
		String res;
		synchronized (monitor) {
			while (this.message == null) {
				monitor.wait();
			}
			synchronized (this) {
				res = this.message;
				this.message = null;
				this.notify();
			}
		}
		return res;
	}

	public synchronized String pull() {
		String res = this.message;
		this.message = null;
		return res;
	}
}
