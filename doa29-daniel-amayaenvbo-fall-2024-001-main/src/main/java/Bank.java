import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accounts;

	public Bank() {
		accounts = new HashMap<>();
	}

	public void addAccount(Account account) {
		accounts.put(account.getId(), account);
	}

	public Account getAccount(String id) {
		return accounts.get(id);
	}

	public void deposit(String id, double amount) {
		Account account = getAccount(id);
		if (account != null) {
			account.deposit(amount);
		}
	}

	public void withdraw(String id, double amount) {
		Account account = getAccount(id);
		if (account != null) {
			account.withdraw(amount);
		}
	}
}