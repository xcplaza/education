package persons;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonsRestoreAppl {
	private static final String FILE_NAME = "persons.data";

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		Person[] array = mapper.readValue(new File(FILE_NAME), Person[].class);
		for (Person p : array) {
			System.out.println(p);
		}
	}
}
