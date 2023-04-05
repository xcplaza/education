
public class HW_07_drive {

	static final int JERUSALEM = 1;
	static final int TEL_AVIV = 2;
	static final int BEER_SHEVA = 3;
	static final int HAIFA = 4;

	public static void main(String[] args) {
		// выбор времени
		float time = 23.59f;
		
		// выбор города
		int city1 = JERUSALEM;
		int city2 = TEL_AVIV;
		int city3 = BEER_SHEVA;
		int city4 = HAIFA;
		
		int year = 2000; // выбор года
		int drive = 180; // чистое время в пути

		// Вычисление задержки в зависимости от времени выезда
		int delayByTime = intdelayTime(time);
		System.out.println("Задержка по времени: " + delayByTime + " минут");

		// Вычисление задержки в зависимости от города
		int delayByCity = delayOnCity(city2);
		System.out.println("Задержка по городу: " + delayByCity + " минут");

		// Вычисление задержки в зависимости от года выпуска автобуса
		int delayByYear = delayOnYear(year);
		System.out.println("Задержка по году выпуска автобуса: " + delayByYear + " минут");

		// Вычисление времени в пути с учетом задержек
		int timeOnRoute = timeOnRoute(drive, time, city2, year);
		System.out.println("Время в пути с учетом задержек: " + timeOnRoute + " минут");
	}
	
    public static int timeOnRoute(int pureTime, float time, int city, int year) {
    	int delayTime = intdelayTime(time);
    	int delayOnCity = delayOnCity(city);
    	int delayOnYear = delayOnYear(year);
    	
    	if (pureTime <=0 || delayTime == -1 || delayOnCity == -1 || delayOnYear == -1) {
    		System.out.println("Wrong pure time!");
    		return pureTime + delayTime + delayOnCity + delayOnYear;
    	}
//        int delay = intdelayTime(time) + delayOnCity(city) + delayOnYear(year);
//        return pureTime + delay;
		return pureTime;
    }

	public static int intdelayTime(float time) {
		if (time > 7. && time <=9.) {
			return 20;
		} else if (time >9. && time <= 11.) {
			return 10;
		} else if (time >=11. && time <= 13.) {
			return 5;
		} else if (time >= 0. && time <= 24.) {
			return 0;
		} else {
			System.out.println("Wrong time");
			return -1;
		}
	}
	    public static int delayOnCity(int city) {
	        switch (city) {
	            case JERUSALEM:
	                return 20;
	            case TEL_AVIV:
	                return 35;
	            case BEER_SHEVA:
	                return 15;
	            case HAIFA:
	                return 25;
	            default:
	                System.out.println("Wrong city");
	                return -1;
	              	}
	        }

	    public static int delayOnYear(int year) {
	        if (year >= 1950 && year <= 1995) {
	            return 15;
	        } else if (year > 1995 && year <= 2005) {
	            return 10;
	        } else if (year > 2005 && year <= 2017) {
	            return 5;
	        } else if (year > 2017 && year <= 2022) {
	            return 0;
	        } else {
	            System.out.println("Wrong year");
	            return -1;
	        }
	    }
	}
