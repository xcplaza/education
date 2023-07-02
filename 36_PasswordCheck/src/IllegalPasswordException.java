
@SuppressWarnings("serial")
public class IllegalPasswordException extends Exception {
	private String[] message;

	public IllegalPasswordException(String[] message) {
		super();
		this.message = message;
	}

	public String[] getMessages() {
		return message;
	}

}
