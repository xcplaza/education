
public class ArgsInrt {

	public static void main(String[] args) {
//		принимаем из вне данные mama myla ramu 32
		if (args.length == 0)
			System.out.println("Args is empty");
		System.out.println(args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

//		парсим число из строки 3 элемент и прибавляем 10
		int res = Integer.parseInt(args[3]);
		System.out.println(res + 10);

	}

}
