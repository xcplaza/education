
public class CarAppl {

	public static void main(String[] args) {

		Car[] cars = { new Car("BMW X5", "Black", 2008, 3.0), new Car("Mercedes-Benz C-Class", "Silver", 1990, 2.0),
				new Car("Audi A1", "White", 2017, 1.5), new Car("Toyota Camry", "Red", 2021, 2.5),
				new Car("Mustag Musculcar", "Blue", 1990, 3.5) };

		/*
		 * Car car1 = new Car("BMW X5", "Black", 2008, 3.0); Car car2 = new
		 * Car("Mercedes-Benz C-Class", "Silver", 1990, 2.0); Car car3 = new
		 * Car("Audi A1", "White", 2017, 1.5); Car car4 = new Car("Toyota Camry", "Red",
		 * 2021, 2.5); Car car5 = new Car("Mustag Musculcar", "Blue", 1945, 3.5);
		 */

//		Car[] cars = { car1, car2, car3, car4, car5 };

		allCars(cars);
		System.out.println();

		System.out.println(" 2 ///////////////////////////////////");
		cars2L(cars);

	}

	/*
	 * метод выводящий информацию о всех машинах массива на консоль
	 */
	public static void allCars(Car[] cars) {
		if (cars == null || cars.length == 0) {
			System.out.println("Wrong arrays!");
		}
		for (int i = 0; i < cars.length; i++) {
//			if (cars[i] != null)
//				cars[i].display();
			if (cars[i] == null) {
				continue;
			}
			cars[i].display();
		}

	}

	/*
	 * метод выводящий на консоль информацию только о тех машинах объем которых
	 * более 2 литров
	 */
	public static void cars2L(Car[] cars) {
		if (cars == null || cars.length == 0) {
			System.out.println("Wrong arrays!");
		}
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null && cars[i].getMotorValue() >= 2.)
				cars[i].display();
		}
	}

}
