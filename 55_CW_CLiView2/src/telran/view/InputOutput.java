package telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {
	void output(Object obj);

	String inputString(String prompt);

	default void outputLine(Object obj) {
		output(obj);
	}

	default <R> R inputObject(String prompt, String errorPromt, Function<String, R> mapper) {
		while (true) {
			String text = inputString(prompt);
			if (text == null)
				return null;
			R res = mapper.apply(text);
			if (res != null)
				return res;
			outputLine(errorPromt);
		}
	}

	default Integer inputInteger(String promt) {
		return inputObject(promt, "It's not Integer number!", s -> {
			try {
				Integer res = Integer.parseInt(s);
				return res;
			} catch (Exception e) {
				return null;
			}
		});
	}

	default Integer inputInteger(String prompt, Integer min, Integer max) {
		return inputObject(prompt, String.format("It's not Integer number in range [%d - %d]", min, max), s -> {
			try {
				Integer res = Integer.parseInt(s);
				return res >= min && res <= max ? res : null;
			} catch (Exception e) {
				return null;
			}
		});
	}

	default String InputString(String prompt, List<String> options) {
		return inputObject(prompt, "String is not in options", s -> options.contains(s) ? s : null);
	}

	default Double inputDouble(String prompt) {
		return inputObject(prompt, "It's not a double number", s -> {
			try {
				Double number = Double.parseDouble(s);
				return number;
			} catch (Exception e) {
				return null;
			}
		});
	}

	default Long inputLong(String prompt) {
		return inputObject(prompt, "It's not a long number", s -> {
			try {
				Long number = Long.parseLong(s);
				return number;
			} catch (Exception e) {
				return null;
			}
		});
	}

	default LocalDate inputDate(String prompt, String format) {
		return inputObject(prompt, "Wrong date " + format, s -> {
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
				return LocalDate.parse(s, dtf);
			} catch (Exception e) {
				return null;
			}
		});
	}
}
