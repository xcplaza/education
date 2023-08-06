
import java.io.IOException;

import client.CalculatorClient;
import telran.view.InputOutput;

public class CloseExitItem extends CalculatorItem {

	public CloseExitItem(InputOutput inOut, CalculatorClient cc) {
		super(inOut, cc);
	}

	@Override
	public String displayName() {
		return "Exit";
	}

	@Override
	public void perform() {
		try {
			cc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isExit() {
		return true;
	}
}
