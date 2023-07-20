import java.io.*;

public class OutputStreamAppl {

	public static void main(String[] args) throws Exception {
		OutputStream out = new FileOutputStream("file.txt", true);
		File node = new File("file");
		OutputStream out1 = new FileOutputStream(node);
		out1.close();

		String str = " Hello world ";
		out.write(str.charAt(0)); // H
		out.write(str.getBytes()); // Hello world
		out.write(str.getBytes(), 3, 5);
		out.close();
	}

}
