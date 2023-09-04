package telran.items;



import telran.service.ICalculator;
import telran.view.InputOutput;

import java.util.ArrayList;

public class CalculationItem extends CalculatorItem
{

	public CalculationItem(InputOutput inOut, ICalculator calculator)
	{
		super(inOut, calculator);
	}

	@Override
	public String displayName()
	{
		return "Numbers calculator";
	}

	@Override
	public void perform()
	{
		Double op1 = inOut.inputDouble("Enter first number");
		if(op1 == null)
			return;
		
		Double op2 = inOut.inputDouble("Enter second number");
		if(op2 == null)
			return;

		String operator = inOut.InputString("Enter operator from ", new ArrayList<>(calculator.getOperationCodes()));
		if (operator == null)
			return;
		
		inOut.outputLine(calculator.calculate(op1, op2, operator));
	}
}
