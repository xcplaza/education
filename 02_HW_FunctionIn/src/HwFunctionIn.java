
public class HwFunctionIn {

	public static void main(String[] args) {

//		call percent
		float a = 200;
		int per = 10;
		float result = percent(a, per);
		System.out.println("1.percent = " + result);

//		call circleLength
		float radius = result;
		float circleLengthName = circleLength(radius);
//		System.out.println("2.radius = " + circleLengthName);
		System.out.printf("2.radius = %.2f cm\n", circleLengthName); //out 2 symbol after ,

//		call housePrice
		float area = a;
		float price = 10560;
		float cost = housePrice(area, price);
		System.out.println("3.cost = " + cost + " NIS");

//		call salary
		float hours = a;
		float wage = 100;
		int bonus = per;
		float salary = salary(hours, wage, bonus);
		System.out.println("4.sum = " + salary);

//		call cashe
		float kg = 15;
		float priceKg = 120;
		float discount = per;
		float cashe = cashe(kg, priceKg, discount);
		System.out.println("5.cashe = " + cashe);
	}

//	method percent
	public static float percent(float a, float per) {
		return (a * per) / 100;
	}

//	method circleLength
	public static float circleLength(float radius) {
		return (float) (2 * Math.PI * radius);
	}

//	method housePrice
	public static float housePrice(float area, float price) {
		return area * price;
	}

//	method salary
	public static float salary(float hours, float wage, float bonus) {
		float sum = hours * wage;
		return sum + (bonus * sum) / 100;
	}

//	method cashe
	public static float cashe(float kg, float priceKg, float discount) {
		float pay = kg * priceKg;
		return pay - (discount * pay) / 100;
	}
}
