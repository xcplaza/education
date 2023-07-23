import java.io.FileReader;
import java.io.FileWriter;

public class LineStreamAppl {

	public static void main(String[] args) {
		try (FileReader input = new FileReader("file.txt"); FileWriter output = new FileWriter("dest.txt");) {
			int c = 0;
			while ((c = input.read()) > 0) {
				output.write(c);
			}
		} catch (Exception e) {

		}
	}

}
