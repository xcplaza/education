package telran.abst.appl;
import telran.abst.dto.Animal;
import telran.abst.dto.Cat;
import telran.abst.dto.Dog;
public class PetsAppl {
	public static void main(String[] args) {
//		Animal a = new Animal("name1", 12, false); // ограничение при установке абстракции на объект Animal
		Animal[] animals = {
				new Dog("Tom", 10, true, true, "Bolonka"),
				new Dog("Boss", 7, true, false, "Boxer"),
				new Cat("Botya", 15, false, true, "Black"),
				new Cat("Barsik", 7, true, false, "White")
		};
		displayVoice(animals);
	}

	private static void displayVoice(Animal[] animals) {
		for(int i =0; i < animals.length; i++) {
//			if(animals[i] instanceof Dog)
//				((Dog)animals[i]).voice();
//			else if (animals[i] instanceof Cat)
//				((Cat)animals[i]).voice();
			animals[i].voice();
		}
	}
	
	
}
