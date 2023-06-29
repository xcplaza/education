
@SuppressWarnings("serial")
public class MyException extends Exception {

	public MyException() {
	}

	public MyException(String message) { //пробрасываем в родителя сообщение
		super(message);
	}
}
