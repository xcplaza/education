package calculator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public class CalculatorMap implements ICalculator {
	static Map<String, BinaryOperator<Double>> mapOperations;
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1 + o2);
		mapOperations.put("-", (o1, o2) -> o1 - o2);
		mapOperations.put("*", (o1, o2) -> o1 * o2);
		mapOperations.put("/", (o1, o2) -> o2 == 0 ? null : o1 / o2);
	}

	@Override
	public Set<String> getOperationCodes() {
		return mapOperations.keySet();
	}

	@Override
	public double calculate(double op1, double op2, String operation) {
		try {
			return mapOperations.get(operation).apply(op1, op2);
		} catch (Exception e) {
			return Double.MAX_VALUE;
		}
	}

}
