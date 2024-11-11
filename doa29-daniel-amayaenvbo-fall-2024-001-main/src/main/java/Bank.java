// Daniel Amayaenvbo,doa29
// Last Update: November 10, 2024

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accounts; // Stores accounts by their unique ID

	// Constructor to initialize the accounts map
	public Bank() {
		accounts = new HashMap<>(); // Initialize the map for storing accounts
	}

	// Adds an account to the bank
	public void addAccount(Account account) {
		accounts.put(account.getId(), account); // Store account by its ID
	}

	// Retrieves an account by its ID
	public Account getAccount(String id) {
		return accounts.get(id); // Return the account associated with the provided ID
	}

	// Deposits a specified amount into the account with the given ID
	public void deposit(String id, double amount) {
		Account account = getAccount(id);
		if (account != null) {
			account.deposit(amount); // Deposit into the found account
		}
	}

	// Withdraws a specified amount from the account with the given ID
	public void withdraw(String id, double amount) {
		Account account = getAccount(id);
		if (account != null) {
			account.withdraw(amount); // Withdraw from the found account
		}
	}
}
