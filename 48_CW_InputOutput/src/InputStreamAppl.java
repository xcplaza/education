import java.io.*;

public class InputStreamAppl {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("file.txt");
//		System.out.println(in.read()); // ASCII - first element
//		System.out.printf("%c", in.read()); //H
//		System.out.printf("%c", in.read()); //H
//		System.out.printf("%c", in.read()); //e
//		System.out.printf("%c", in.read()); //l

//		int c;
//		while ((c = in.read()) > 0) {
//			System.out.printf("%c", c);
//		}
//		System.out.println(in.read()); // -1 из-за сдвига корретки

//		byte[] buffer = new byte[in.available()];
//		in.read(buffer);
//		System.out.println(new String(buffer));

		byte[] buffer = new byte[4];
		int c;
		String res = "";

		while ((c = in.read(buffer)) > 0) {
			res += new String(buffer, 0, c);
			System.out.println(c);
			System.out.println(res);

		}
		in.close();
	}
}
