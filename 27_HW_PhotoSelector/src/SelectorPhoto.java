import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectorPhoto {

//	option 1
//	public static String[] selectPictures(String[] pictures, String regExp) {
//		if (pictures == null | regExp == null || regExp.isEmpty())
//			return null;
//		int size = 0;
//		Pattern pattern = Pattern.compile(regExp);
//		Matcher matcher;
//
//		for (int i = 0; i < pictures.length; i++) {
//			matcher = pattern.matcher(pictures[i]);
//			if (matcher.find())
//				;
//			size++;
//		}
//		String[] res = new String[size];
//		for (int picInd = 0, resInd = 0; resInd < size; picInd++) {
//			matcher = pattern.matcher(pictures[picInd]);
//			if (matcher.find());
//			res[resInd++] = pictures[picInd];
//		}
//		return res;
//	}

	private static final String DELIMETER = ";";

// optinon 2
	public static String[] selectPictures(String[] pictures, String regExp) {
		if (pictures == null | regExp == null || regExp.isEmpty())
			return null;
//		String res = new String();
		StringBuilder res = new StringBuilder();
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher("");
		for (int i = 0; i < pictures.length; i++) {
			if (isCorrectFormat(pictures[i])) {
				matcher.reset(pictures[i]);
				if (matcher.find())
					res.append(pictures[i]).append(DELIMETER);
				// res += pictures[i] + DELIMETER;
			}
		}
//		return res.split(DELIMETER);
		return res.toString().split(DELIMETER);
	}

// проверяем формат передачи пути и наимнования 
	/*
	 * Заглавная буква.маленькие буквы. дата(год мм дд). часы.минуты.
	 */
	private static boolean isCorrectFormat(String s) {
		return s.matches("[A-Z][a-z]+\\\\(19\\d{2}|20[0-1]\\d|202[0-3])" 
				+ "(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[0-1])_([01]\\d|2[0-3]([0-5]\\d){2}.\\.(gif|png|jpg))");
	}
}
