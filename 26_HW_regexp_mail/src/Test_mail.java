import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Test_mail {

	@Test
	public void emailAddressTest() {
		// there must be @
		// before @ maybe any symbols except whitespace and comma
		// after @ may be any letters or digits or dashes
		// email address should ended either .co.il or .mail.ru
		assertTrue(StringExpressions.isEmailCoIlMailRu("t%u@12.co.il"));
		assertTrue(StringExpressions.isEmailCoIlMailRu("t#u@t.mail.ru"));
		assertTrue(StringExpressions.isEmailCoIlMailRu("12_5-6*@y.co.il"));
		assertFalse(StringExpressions.isEmailCoIlMailRu("t,u@co.il"));//
		assertFalse(StringExpressions.isEmailCoIlMailRu("t,u@12.co.il"));// ,-disallowed
		assertFalse(StringExpressions.isEmailCoIlMailRu("t u@12.co.il"));// space disallowed
		assertFalse(StringExpressions.isEmailCoIlMailRu("ttu@1#2.co.il"));// after @ the symbol # disallowed
		assertFalse(StringExpressions.isEmailCoIlMailRu("ttu@12.mail1ru"));// neither .co.il nor mail.ru
		assertFalse(StringExpressions.isEmailCoIlMailRu("ttu@12co.il"));// neither .co.il nor mail.ru
		// assertFalse(StringExpressions.isEmailCoIlMailRu("ttu12.co.il"));//
		// no @
		assertFalse(StringExpressions.isEmailCoIlMailRu("ttu@1_2.co.il"));// after @ the symbol _ disallowed
	}
}
