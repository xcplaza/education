package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import telran.net.TCPClientJava;

class StringTest extends TCPClientJava {

	public StringTest() throws Exception {
		super("localhost", 3000);
	}

	@Test
	void test() {
		String str = "123456";
		int length = sendRequestGetResponse("length", str);
		assertEquals(str.length(), length);

		String rev = sendRequestGetResponse("revers", str);
		assertEquals("654321", rev);

		try {
			close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
