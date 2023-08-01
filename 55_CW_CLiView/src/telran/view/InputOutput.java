package telran.view;

import java.util.function.Function;

public interface InputOutput {
	void output(Object obj);

	String inputString(String prompt);

	default void outputLine(Object obj) {
		output(obj.toString());
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
}
