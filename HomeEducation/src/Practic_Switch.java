
public class Practic_Switch {

	public static void main(String[] args) {

		int month = 3;
		String monthString;
		switch (month) {
		case 1:
			monthString = "Январь";
			break;
		case 2:
			monthString = "Февраль";
			break;
		case 3:
			monthString = "Март";
			break;
		case 4:
			monthString = "Апрель";
			break;
		case 5:
			monthString = "Май";
			break;
		case 6:
			monthString = "Июнь";
			break;
		case 7:
			monthString = "Июль";
			break;
		case 8:
			monthString = "Август";
			break;
		case 9:
			monthString = "Сентябрь";
			break;
		case 10:
			monthString = "Октябрь";
			break;
		case 11:
			monthString = "Ноябрь";
			break;
		case 12:
			monthString = "Декабрь";
			break;
		default:
			monthString = "Не знаем такого";
			break;
		}
		System.out.println(monthString);
		
		int i = -10 * -1 + (-2);
		int k = i < 0 ? -i : i;
		System.out.println(k);
	}

}
