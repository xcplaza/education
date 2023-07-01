import java.util.Arrays;

@SuppressWarnings("serial")
public class IllegalPasswordException extends Exception {
	private String[] message;

	public IllegalPasswordException(String... message) {
		this.message = message;
	}

	public String[] getMessages() {
		return message;
	}

}
