import static org.junit.Assert.*;

import org.junit.Test;

public class WeightUnitTest {

	@Test
	public void testConverter() {
		assertEquals(1000., WeightUnit.TN.convert(WeightUnit.KG), 0.1);
		assertEquals(0.001, WeightUnit.KG.convert(WeightUnit.TN), 0.01);
	}

}
