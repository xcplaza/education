package persons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonsRestoreAppl {
	private static final String FILE_NAME = "persons.data";

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

//		0 solution
//		Person[] array = mapper.readValue(new File(FILE_NAME), Person[].class);
//		List<Person> array = mapper.readValue(new File(FILE_NAME), array);

//		1 solution
		JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Person.class);
		List<Person> array = mapper.readValue(new File(FILE_NAME), type);

//		2 solution
//		List<Person> array = mapper.readValue(new File(FILE_NAME), new TypeReference<List<Person>>() {});

//		for (Person p : array) {
//			System.out.println(p);
//		}

//		read Map - to JSON
		Map<String, Person> map = new HashMap<>();
		map.put("Masha", new Person(1, "Masha", null, null));
		map.put("Pasha", new Person(2, "Pasha", null, null));
		String json = mapper.writerFor(new TypeReference<Map<String, Person>>() {}).writeValueAsString(map);
//		System.out.println(json);

//		read tree - select parth
		JsonNode node = mapper.readTree(json);
		JsonNode pasha = node.get("Pasha");
		System.out.println(pasha);
	}
}
