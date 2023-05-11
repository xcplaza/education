
public class BankAccount {

	private long account;
	private String owner;
	private String bank;
	private int branch;
	private double amount;

	// пустой конструктор для DTO
	public BankAccount() {
	}

	// конструктор + 300
	public BankAccount(long account, String owner, String bank, int branch, double amount) {
		this.account = account;
		this.owner = owner;
		this.bank = bank;
		this.branch = branch;
		this.amount = amount + 300.;
	}

	// конструктор + 150
	public BankAccount(long account, String owner, String bank, int branch) {
		this.account = account;
		this.owner = owner;
		this.bank = bank;
		this.branch = branch;
		amount = 150.;
	}

	// конструктор аноним
	public BankAccount(long account, String bank, int branch, double amount) {
		this.account = account;
		this.bank = bank;
		this.branch = branch;
		this.amount = amount;
	}

	// конструктор аноним и без доп денег
	public BankAccount(long account, String bank, int branch) {
		this.account = account;
		this.bank = bank;
		this.branch = branch;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public long getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	public boolean debit(double sum) {
		if (sum <= 0.)
			return false;
		amount += sum;
		return true;
	}

	public boolean credit(double sum) {
		if (sum <= 0. || amount < sum)
			return false;
		amount -= sum;
		return true;
	}

	public void display() {
		String res;
		if (owner != null) {
			res = "Owner: " + owner;
		} else {
			res = "Owner: Anonymus ";
		}

		res += "\nAccount: " + account + "\nAmount: " + amount + "\nBank: " + bank + "\nBranch: " + branch
				+ "\n**************************\n";
		System.out.println(res);
	}

	public void display(boolean gender) {
		String res;
		if (gender) {
			res = "Mrs. ";
		} else {
			res = "Mr. ";
		}
		if (owner != null) {
			res += owner;
		} else {
			res += " Anonymus";
		}

		res += "\nAccount: " + account + "\nAmount: " + amount + "\nBank: " + bank + "\nBranch: " + branch
				+ "\n**************************\n";
		System.out.println(res);
	}

}
