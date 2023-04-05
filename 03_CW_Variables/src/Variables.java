
public class Variables {

	public static void main(String[] args) {
		byte B;
		short s;
		int i, i1;
		float f;
		long l;
		double d;
		char c;
		boolean b;
		String str, str1, str2;
		
//	Variable name	A-Z a-z 0-9 _ first_second firstSecond
		
		B = 100;
		b = true;
		c = 100;
		System.out.println(c);
		c = 'c';
		System.out.println(c);
		
		int res = 10;
		
		var number = 10.;
		
		B = (byte) 130; //так делать нельзя!!! результат будет 126!!
		System.out.println(B);
		
//		приведение типов (преобразование)
		i = B;
		s = (short) res;
		
		d = i;
		i = (int) d;
		
		float ff = 123.65f;
		long ll = 22222222222l;
		
		ll = (long) ff;
		System.out.println(ll);
	}

}
