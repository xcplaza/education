import java.util.Iterator;

public class BankAppl {

	public static void main(String[] args) {

		BankAccount[] bank = { new BankAccount(12345, "Vasya", "Leumi", 900, 1000.),
				new BankAccount(56980, "Peter", "Leumi", 903), new BankAccount(98952, "Leumi", 678, 234000.),
				new BankAccount(55555, "Leumi", 456) };

		bank[0].display(true);
		bank[1].display();
		
		bank[3].debit(35000.);
		boolean b = bank[3].debit(35000.);
		System.out.println(b);
		double res = getMoneyAnonymus(bank);
		System.out.println(res);
	}

	private static double getMoneyAnonymus(BankAccount[] bank) {
		double res = 0.;
		for (int i = 0; i < bank.length; i++) {
			if (bank[i].getOwner() == null)
				res += bank[i].getAccount();
		}
		return res;
	}
	
	

}
