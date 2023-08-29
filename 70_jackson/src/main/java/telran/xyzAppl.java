package telran;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class xyzAppl {
	public static final String FILE_NAME = "xyz.data";

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Y[] array = { new Y(new X(1)), new Y(new X(2)), new Y(new X(1)) };

		File file = new File(FILE_NAME);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, new Z(array));

		Z z = mapper.readValue(file, Z.class);
		System.out.println(z);
	}
}
