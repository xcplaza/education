import java.io.*;

public class DataStreamAppl {
	static final String FILE_NAME = "invoice.data";

	public static void main(String[] args) throws Exception {
		double[] prices = { 19.99, 9.99, 20., 3.99, 100 };
		int[] units = { 12, 8, 13, 29, 2 };
		String[] goods = { "milk", "bread", "juice", "benzin", "meet" };

		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
		for (int i = 0; i < prices.length; i++) {
			out.writeDouble(prices[i]);
			out.writeInt(units[i]);
			out.writeUTF(goods[i]);
		}
//		22byte -> 8double 4int 10string
		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)));
		double total = 0;
		double price = 0;
		int unit = 0;
		String good = null;
		try {
			while (true) {
				price = in.readDouble();
				unit = in.readInt();
				good = in.readUTF();
				System.out.printf("You ordered %d unit of %s at $%.2f\n", unit, good, price);
				total += unit * price;
			}
		} catch (EOFException e) {
			System.out.println("End: ");
		}
		System.out.println("Total sum " + total);
	}

}
