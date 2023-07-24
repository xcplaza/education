import java.io.*;

public class DataStreamAppl {

	public static void main(String[] args) throws Exception {
		double[] prices = { 19.99, 9.99, 20., 3.99, 100 };
		int[] units = { 12, 8, 13, 29, 2 };
		String[] goods = { "milk", "bread", "juice", "benzin", "meet" };

		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("invoice.data")));
		for (int i = 0; i < prices.length; i++) {
			out.writeDouble(prices[i]);
			out.writeInt(units[i]);
			out.writeUTF(goods[i]);
		}
		out.close();
	}

}
