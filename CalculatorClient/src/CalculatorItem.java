
import client.CalculatorClient;
import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item {
	InputOutput inOut;
	CalculatorClient cc;

	public CalculatorItem(InputOutput inOut, CalculatorClient cc) {
		super();
		this.inOut = inOut;
		this.cc = cc;
	}

	@Override
	public String displayName() {
		return "Arithmetic calculator";
	}

	@Override
	public void perform() {
		Double op1 = inOut.inputDouble("Enter first number");
		if (op1 == null)
			return;
		Double op2 = inOut.inputDouble("Enter second number");
		if (op2 == null)
			return;
		String oper = inOut.inputString("Enter operator");
		if (oper == null)
			return;
		Double res = cc.calculate(op1, op2, oper);
		inOut.outputLine(res);
	}
}
