package telran;
import java.lang.reflect.Field;
import java.util.*;

public class TableInfoRunner
{
	public static void runInfo(Object obj)
	{
		Class<?> clazz = obj.getClass();
		Table tableAnn = clazz.getAnnotation(Table.class);
		String tableName = tableAnn == null ? clazz.getSimpleName() : tableAnn.name();
		
		ArrayList<String> uniqueIndexes = new ArrayList<>();
		ArrayList<String> nonuniqueIndexes = new ArrayList<>();
		
		Field[] fields = clazz.getDeclaredFields();
		String idField = null;
		
		for (Field field : fields)
		{
			if (field.isAnnotationPresent(Id.class))
			{
				if (idField != null)
					throw new RuntimeException("Id duplication");
				idField = field.getName();
			}
			
			Index indexAnn = field.getAnnotation(Index.class);
			if (indexAnn != null)
			{
				if (indexAnn.unique())
					uniqueIndexes.add(field.getName());
				else
					nonuniqueIndexes.add(field.getName());
			}
		}
		
		if (idField == null)
			throw new RuntimeException("No Id is defined");
		
		displayInfo(tableName, idField, uniqueIndexes, nonuniqueIndexes);
	}

	private static void displayInfo(String tableName, String indexField, ArrayList<String> uniqueIndexes,
			ArrayList<String> nonuniqueIndexes)
	{
		System.out.println("Table: " + tableName);
		System.out.println("Id: " + indexField);
		System.out.println("Unique indexes: " + uniqueIndexes);
		System.out.println("Nonunique indexes: " + nonuniqueIndexes);
	}
}
