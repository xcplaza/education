import java.time.LocalDate;

//@Table(name = "persons")
public class Person
{
//	@Id
	int id;
	@Index
	@Id
	int salary;
	@Index(unique = true)
	int mail;
	@Index
	LocalDate birthDate;
}
