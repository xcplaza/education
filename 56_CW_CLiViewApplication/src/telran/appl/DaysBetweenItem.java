package telran.appl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import telran.view.InputOutput;
import telran.view.Item;

public class DaysBetweenItem implements Item {
	static Map<String, BiFunction<LocalDate, Long, LocalDate>> mapOperations; 
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1.plusDays(o2));
		mapOperations.put("-", (o1, o2) -> o1.minusDays(o2));
	}
	InputOutput inOut;

	public DaysBetweenItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayName() {
		return "Display number days between two given dates";
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
