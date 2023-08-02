package telran.appl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item {
	static Map<String, BinaryOperator<Double>> mapOperations;
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1 + o2);
		mapOperations.put("-", (o1, o2) -> o1 - o2);
		mapOperations.put("*", (o1, o2) -> o1 * o2);
		mapOperations.put("/", (o1, o2) -> o2 == 0 ? null : o1 / o2);
	}

	InputOutput inOut;

	public CalculatorItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayName() {
		return "Double numbers calculator";
	}

	@Override
	public void perform() {
		Double op1 = inOut.inputDouble("Enter first number");
		if (op1 == null)
			return;
		Double op2 = inOut.inputDouble("Enter second number");
		if (op2 == null)
			return;
		String operator = inOut.inputString("Enter operator from " + mapOperations.keySet(),
				new ArrayList<>(mapOperations.keySet()));
		if (operator == null)
			return;
		inOut.outputLine(mapOperations.get(operator).apply(op1, op2));
	}

}
