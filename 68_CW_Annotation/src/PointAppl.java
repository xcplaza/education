
public class PointAppl {

	public static void main(String[] args) throws CloneNotSupportedException {
		Point p = new Point(1, 1);
		Point p1 = (Point) p.clone();
		System.out.println(p == p1);

//		аннотация - не допускаем null
//		String str = (@NotNull String) str;

//		аннотация имплементирования листа без разрешения изменений (информативно)
//		public class UnmodifaibleList implements @Readonly List<T>

//		@Retention
//		RetentionPolicy.SOURCE
//		RetentionPolicy.CLASS
//		RetentionPolicy.RUNTIME

//		@Target - enumerator
//		ElementType.ANNOTATION_TYPE
//		ElementType.CONSTRUCTOR
//		ElementType.FIELD
//		ElementType.LOCAL_VARIABLE
//		ElementType.METHOD
//		ElementType.PARAMETER
//		ElementType.TYPE

//		@Retention(value = RetentionPolicy.RUNTIME)
//		@Target(value = {ElementType.TYPE})

//		@Getter / @Setter
//		@ToString
//		@EqualsAndHashCode
//		@NoArgsConstructor

//		@Data (объединяет джентельменский набор)

	}

}
