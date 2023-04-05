
public class CW_09_IntDecrSrc {

	public static void main(String[] args) {
		int i = 5;
//		increment
//		i = i + 1;
		i++;
//		decrement
//		i = i - 1;
		i--;

//		постфиксный инкремент
		System.out.println(i++); // возмет i = 5 и добавит +1 к нему и оставит в переменной i
		System.out.println(i); // вывод из переменной в предыдущей
		int res = i++;
		System.out.println("res = " + res);
		System.out.println("i = " + i);

		double f = 3.5;
		f++;
		System.out.println(f);

//		префиксный инкермент
		System.out.println(++i); // возмет i = 6 (из переменной) и добавит + 1

		i = 5;
		System.out.println(i--); // postfix decr
		System.out.println(i);

		System.out.println(--i); // prefix decr
		System.out.println(i);

//		sintax sugar
		i = 5;
		i += 10; // i = i + 10;
		System.out.println(i);
		i %= 2; // i = i % 2;
		System.out.println(i);
		i *= 5; // i = i * 5;
		System.out.println(i);

	}

}
