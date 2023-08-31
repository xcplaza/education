package telran.items;

import lombok.AllArgsConstructor;
import telran.service.ICalculator;
import telran.view.InputOutput;
import telran.view.Item;

@AllArgsConstructor
public abstract class CalculatorItem implements Item {
	protected InputOutput inOut;
	protected ICalculator calculator;
}
