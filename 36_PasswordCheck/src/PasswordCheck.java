import java.util.Arrays;
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
		String[] errors = new String[0];
		int indexError = 0;

		if (password.length() < 8) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(WRONG_LENGTH_MESSAGE);
		}
		if (Pattern.compile("\\s").matcher(password).find()) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(WRONG_SYMBOL_MESSAGE);
		}
		if (!Pattern.compile("[A-Z]").matcher(password).find()) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(NO_UPPER_CASE_MESSAGE);
		}
		if (!Pattern.compile("[a-z]").matcher(password).find()) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(NO_LOWER_CASE_MESSAGE);
		}
		if (!Pattern.compile("\\d").matcher(password).find()) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(NO_DIGIT_MESSAGE);
		}
		if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
			errors = Arrays.copyOf(errors, errors.length + 1);
			indexError++;
			throw new IllegalPasswordException(NO_SPEC_SYMBOL_MESSAGE);
		}
		if (indexError > 0) {
			System.arraycopy(errors, 0, errors, 0, indexError);
			throw new IllegalPasswordException(errors);
		}
	}
}
