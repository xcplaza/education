package telran.items;

import telran.service.ICalculator;
import telran.view.InputOutput;

public class DisplayOperationsItem extends CalculatorItem {

	public DisplayOperationsItem(InputOutput inOut, ICalculator calculator) {
		super(inOut, calculator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String displayName() {
		return "Display operations codes";
	}

	@Override
	public void perform() {
		calculator.getOperationCodes().forEach(c -> inOut.output(c + " "));
	}

}
