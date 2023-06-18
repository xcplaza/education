import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherIntr {

	public static void main(String[] args) {
		String str = "Don't trouble trouble until trouble troubles you";
		String regex = "[Tt]rouble";
		System.out.println(str.matches(str));
//		===============================================

		Pattern p = Pattern.compile(regex);
		System.out.println(p.pattern()); // .pattern- выводит строковое выражение
		System.out.println(p.toString());
		Pattern p2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); // CASE_INSENSITIVE - сопоставление без учета
																		// регистра
		System.out.println(p2.flags());
		System.out.println(p2.pattern());
		System.out.println(Pattern.matches(regex, str)); // сравнение на полное совпадение
//		===============================================

		p = Pattern.compile("a*b");
		Matcher matcher = p.matcher("qqaaaaaaabjhdsjkfhsaab"); // строка в короой будет осуществляться поиск
		System.out.println(matcher.find()); // начинает искать совпадения внутри строки (помнит где искал) - нашел
											// aaaaaaab
		System.out.println(matcher.find()); // aab
		System.out.println(matcher.find()); // строка кончилась
		System.out.println(matcher.find(6)); // индекс с которого он начнет искать
		System.out.println(matcher.matches()); // проверяет полное совпадение
		System.out.println(matcher.lookingAt()); // метод сопоставляет шаблон (регулярку) с текстом
		matcher.reset(); // сбрасываем у find index где он находил сравнение со строкой
		matcher.find();
		System.out.println("Start: " + matcher.start()); // индекс первого элемента в совпадении
		matcher.find();
		System.out.println("Start2: " + matcher.start()); // индекс следующего элемента в совпадении
		matcher.reset();
		matcher.find();
		System.out.println("End: " + matcher.end()); // индекс следующий после первого сопадения (найденого)
		matcher.find();
		System.out.println("End2: " + matcher.end());

		System.out.println(matcher.group()); // возвращает строку совпадения
		matcher.reset();
		matcher.find();
		System.out.println(matcher.group());
//		===============================================

		matcher.reset();
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.err.println(matcher.group());
			System.out.println(matcher.end());
			System.out.println("------------n/");
		}
		System.out.println("==============n/");
		
		String res = matcher.replaceAll("Hello");
		System.out.println(res);
		res = matcher.replaceFirst("Bye");
		System.out.println(res);
	}

}
