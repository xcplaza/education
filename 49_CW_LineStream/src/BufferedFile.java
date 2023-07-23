import java.io.*;

public class BufferedFile {

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new FileReader("file.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("file1.txt"));

		while (true) {
			String res = input.readLine();
			if (res == null) {
				break;
			}
			output.write(res + "\n");
		}
		input.close();
//		output.close();
		output.flush();

	}
}
