import java.util.regex.Pattern;

public class PasswordCheck {

	public static final String WRONG_LENGTH_MESSAGE = "wrong length";
	public static final String NO_SPEC_SYMBOL_MESSAGE = "no symbol";
	public static final String NO_DIGIT_MESSAGE = "no digit";
	public static final String NO_UPPER_CASE_MESSAGE = "no upper case letter";
	public static final String NO_LOWER_CASE_MESSAGE = "no lower case letter";
	public static final String WRONG_SYMBOL_MESSAGE = "wrong symbol";

	public static void check(String password) throws IllegalPasswordException {
		if (password == null) {
			throw new IllegalArgumentException("null");
		}
		String[] errors = new String[6];
		int indexError = 0;

		if (password.length() < 8) {
			throw new IllegalPasswordException(new String[] { WRONG_LENGTH_MESSAGE });
		}
		if (Pattern.compile("\\s").matcher(password).find()) {
			throw new IllegalPasswordException(new String[] { WRONG_SYMBOL_MESSAGE });
		}
		if (!Pattern.compile("[A-Z]").matcher(password).find()) {
			throw new IllegalPasswordException(new String[] { NO_UPPER_CASE_MESSAGE });
		}
		if (!Pattern.compile("[a-z]").matcher(password).find()) {
			throw new IllegalPasswordException(new String[] { NO_LOWER_CASE_MESSAGE });
		}
		if (!Pattern.compile("\\d").matcher(password).find()) {
			throw new IllegalPasswordException(new String[] { NO_DIGIT_MESSAGE });
		}
		if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
			throw new IllegalPasswordException(new String[] { NO_SPEC_SYMBOL_MESSAGE });
		}
		if (indexError > 0) {
			String[] Errors = new String[indexError];
			System.arraycopy(errors, 0, Errors, 0, indexError);
			throw new IllegalPasswordException(Errors);
		}
	}
}
