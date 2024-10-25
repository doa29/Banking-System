import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionTest {

	private Checking checkingAccount;
	private Savings savingsAccount;
	private String checkingId;
	private String savingsId;

	@BeforeEach
	void setUp() {
		checkingId = "12345678";
		savingsId = "87654321";
		checkingAccount = new Checking(checkingId, 1.5);
		savingsAccount = new Savings(savingsId, 1.0);
	}

	@Test
	void deposit_twice_into_checking_account() {
		checkingAccount.deposit(500);
		assertEquals(500, checkingAccount.getBalance());

		checkingAccount.deposit(300.50);
		assertEquals(800.50, checkingAccount.getBalance());
	}

	@Test
	void withdraw_twice_from_savings_account() {
		savingsAccount.deposit(100);
		savingsAccount.withdraw(50);
		assertEquals(50, savingsAccount.getBalance());
		savingsAccount.withdraw(100);
		assertEquals(0, savingsAccount.getBalance());
	}
}
