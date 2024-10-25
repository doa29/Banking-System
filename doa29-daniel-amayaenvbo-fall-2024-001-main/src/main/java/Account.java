public abstract class Account {
	private String id;
	private double balance;
	private double apr;

	public Account(String id, double apr, double initialBalance) {
		this.id = id;
		this.apr = apr;
		this.balance = initialBalance;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public double getApr() {
		return apr;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			balance = 0;
		} else if (amount > 0) {
			balance -= amount;
		}
	}
}
