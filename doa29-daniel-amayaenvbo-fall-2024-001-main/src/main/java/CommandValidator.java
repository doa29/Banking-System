public class CommandValidator {
	private Bank bank;

	public CommandValidator(Bank bank) {
		this.bank = bank;
	}

	public boolean validateCommand(String command) {
		if (command.startsWith("create")) {
			return validateAndExecuteCreateCommand(command);
		} else if (command.startsWith("deposit")) {
			return validateAndExecuteDepositCommand(command);
		}
		return false;
	}

	private boolean validateAndExecuteCreateCommand(String command) {
		String[] parts = command.split(" ");
		if (parts.length != 4) {
			return false;
		}

		String accountType = parts[1];
		String accountId = parts[2];
		double apr;

		try {
			apr = Double.parseDouble(parts[3]);
		} catch (NumberFormatException e) {
			return false;
		}

		if (!isValidAccountType(accountType) || !isValidAccountId(accountId) || apr < 0 || apr > 1) {
			return false;
		}

		if (accountType.equals("savings")) {
			bank.addAccount(new Savings(accountId, apr));
		} else if (accountType.equals("checking")) {
			bank.addAccount(new Checking(accountId, apr));
		} else if (accountType.equals("cd")) {
			bank.addAccount(new CD(accountId, apr, 1000));
		} else {
			return false;
		}
		return true;
	}

	private boolean validateAndExecuteDepositCommand(String command) {
		String[] parts = command.split(" ");
		if (parts.length != 3) {
			return false;
		}

		String accountId = parts[1];
		double amount;

		try {
			amount = Double.parseDouble(parts[2]);
		} catch (NumberFormatException e) {
			return false;
		}

		if (!isValidAccountId(accountId) || amount <= 0) {
			return false;
		}

		Account account = bank.getAccount(accountId);
		if (account == null) {
			return false;
		}

		bank.deposit(accountId, amount);
		return true;
	}

	private boolean isValidAccountType(String accountType) {
		return accountType.equals("savings") || accountType.equals("checking") || accountType.equals("cd");
	}

	private boolean isValidAccountId(String accountId) {
		return accountId.matches("\\d{8}");
	}
}
