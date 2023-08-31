package telran.items;

import java.util.ArrayList;

import telran.service.ICalculator;
import telran.view.InputOutput;

public class CalculationItem extends CalculatorItem {

	public CalculationItem(InputOutput inOut, ICalculator calculator) {
		super(inOut, calculator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String displayName() {
		return "Integer numbers calculator";
	}

	@Override
	public void perform() {
		Double op1 = inOut.inputDouble("Enter first number");
		if (op1 == null)
			return;

		Double op2 = inOut.inputDouble("Enter second number");
		if (op2 == null)
			return;

		String operator = inOut.InputString("Enter operator from ", new ArrayList<>(calculator.getOperationCodes()));
		if (operator == null)
			return;

		inOut.outputLine(calculator.calculate(op1, op2, operator));
	}
}
