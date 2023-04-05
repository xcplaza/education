//	private static void jobWeeks(int week) {
//	// 1 - John, 2 - Peter, 3 - Natalya, 4 - Sarah
////	передать номер недели в этот метод от 1 до 52 включительно, если 1 = john  и тд
////	вернуть какая бригада сейчас работает
//}

public class HW_07_brig {

	public static void main(String[] args) {
		int week = 53;
		String currentTeam = jobWeeks(week);
		System.out.println(currentTeam);
	}
	
	public static void week(int w) {
		if (w > 0 && w <=52) {
			return;
		} else {
			System.out.println("Wrong week");
			return;
		}
	}

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

}
