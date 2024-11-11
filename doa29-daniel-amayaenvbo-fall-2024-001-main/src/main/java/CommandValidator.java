// Daniel Amayaenvbo, doa29
// Last Update: November 10th 2024

public class CommandValidator {
	private Bank bank; // Holds the Bank instance for account operations

	// Constructor that accepts a Bank instance and initializes the bank variable
	public CommandValidator(Bank bank) {
		this.bank = bank; // Assign the provided bank instance to the bank variable
	}

	// Validates the command and executes the appropriate action based on the command type
	public boolean validateCommand(String command) {
		// Check if the command is for creating an account
		if (command.startsWith("create")) {
			return validateAndExecuteCreateCommand(command);
		} 
		// Check if the command is for depositing money
		else if (command.startsWith("deposit")) {
			return validateAndExecuteDepositCommand(command);
		}
		// Return false for invalid commands
		return false;
	}

	// Validates and executes the 'create' command to create new accounts
	private boolean validateAndExecuteCreateCommand(String command) {
		String[] parts = command.split(" "); // Split the command into parts based on spaces
		// Ensure the command has the correct number of arguments
		if (parts.length != 4) {
			return false; // Invalid number of arguments
		}

		String accountType = parts[1]; // Extract the account type (e.g., savings, checking, cd)
		String accountId = parts[2]; // Extract the account ID
		double apr; // Store the APR value

		try {
			// Try to parse the APR from the command
			apr = Double.parseDouble(parts[3]);
		} catch (NumberFormatException e) {
			// Return false if APR is not a valid number
			return false;
		}

		// Validate account type, account ID, and APR range (0 to 1)
		if (!isValidAccountType(accountType) || !isValidAccountId(accountId) || apr < 0 || apr > 1) {
			return false; // Return false if any validation fails
		}

		// Create the appropriate account based on the account type
		if (accountType.equals("savings")) {
			bank.addAccount(new Savings(accountId, apr)); // Add a new savings account
		} else if (accountType.equals("checking")) {
			bank.addAccount(new Checking(accountId, apr)); // Add a new checking account
		} else if (accountType.equals("cd")) {
			bank.addAccount(new CD(accountId, apr, 1000)); // Add a new CD account with a minimum balance of 1000
		} else {
			return false; // Return false if account type is invalid
		}
		// Return true if the account was successfully created
		return true;
	}

	// Validates and executes the 'deposit' command to deposit money into an account
	private boolean validateAndExecuteDepositCommand(String command) {
		String[] parts = command.split(" "); // Split the command into parts
		// Ensure the command has the correct number of arguments
		if (parts.length != 3) {
			return false; // Invalid number of arguments
		}

		String accountId = parts[1]; // Extract the account ID
		double amount; // Store the deposit amount

		try {
			// Try to parse the deposit amount
			amount = Double.parseDouble(parts[2]);
		} catch (NumberFormatException e) {
			// Return false if the deposit amount is not a valid number
			return false;
		}

		// Validate account ID and ensure the deposit amount is positive
		if (!isValidAccountId(accountId) || amount <= 0) {
			return false; // Return false if validation fails
		}

		// Retrieve the account associated with the account ID
		Account account = bank.getAccount(accountId);
		// If the account doesn't exist, return false
		if (account == null) {
			return false;
		}

		// Deposit the amount into the account
		bank.deposit(accountId, amount);
		// Return true indicating the deposit was successful
		return true;
	}

	// Validates the account type (must be savings, checking, or cd)
	private boolean isValidAccountType(String accountType) {
		return accountType.equals("savings") || accountType.equals("checking") || accountType.equals("cd");
	}

	// Validates the account ID (must be exactly 8 digits)
	private boolean isValidAccountId(String accountId) {
		return accountId.matches("\\d{8}"); // Account ID should be a string of 8 digits
	}
}
