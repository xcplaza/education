package practics;
import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testWrongExpressions() {
		assertNull(Calculator.computeExpression("25+100/"));
		assertNull(Calculator.computeExpression("&25+100"));
		assertNull(Calculator.computeExpression("25 100"));
		assertNull(Calculator.computeExpression("25?100"));
	}

	@Test
	public void testRightExpressions() {
		assertEquals((Integer) 10, Calculator.computeExpression(" 10 +10-10"));
		assertEquals((Integer) 10, Calculator.computeExpression(" 10 *10/10"));
		assertEquals((Integer) 10, Calculator.computeExpression(" 10 *10/10 +10 -10 "));
		assertEquals((Integer) 10, Calculator.computeExpression("10*10/10+10-10"));
	}

}
