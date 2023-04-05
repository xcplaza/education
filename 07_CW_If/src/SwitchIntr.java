
public class SwitchIntr {

	public static void main(String[] args) {
		int a = 4;
		markWithOutSwitch(a);
		markWithSwitch(a);
	    int week = 10;
	    String currentTeam = jobWeeks(week);
	    System.out.println(currentTeam);
	}

//	private static void jobWeeks(int week) {
//		// 1 - John, 2 - Peter, 3 - Natalya, 4 - Sarah
////		передать номер недели в этот метод от 1 до 52 включительно? если 1 = john
////		вернуть какая бригада сейчас работает (при использовании)
//		
//	}
	
	private static String jobWeeks(int week) {
	    // определяем команду, работающую в заданную неделю
	    int team = (week - 1) % 4 + 1;

	    // возвращаем название команды
	    switch (team) {
	        case 1:
	            return "John работает";
	        case 2:
	            return "Peter работает";
	        case 3:
	            return "Natalya работает";
	        case 4:
	            return "Sarah работает";
	        default:
	            return "Никто не работает";
	    }
	}

	
	

	public static void markWithOutSwitch(int mark) {
		if (mark == 5)
			System.out.println("Excellent");
		else if (mark == 4)
			System.out.println("Good");
		else if (mark == 3)
			System.out.println("Satisfactory");
		else if (mark == 2)
			System.out.println("Bad");
		else
			System.out.println("Invalid mark");
	}

	public static void markWithSwitch(int mark) {
		switch (mark) {
		case 5:
			System.out.println("Excellent");
			break;
		case 4:
			System.out.println("Good");
			break;
		case 3:
			System.out.println("Satisfactory");
			break;
		case 2:
			System.out.println("Bad");
			break;

		default:
			System.out.println("Invalid mark");
			break;
		}

	}

}
