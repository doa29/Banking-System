import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private Checking checkingAccount;
	private CD cdAccount;
	private String checkingId;
	private String cdId;
	private double initialCdBalance;

	@BeforeEach
	void setUp() {
		checkingId = "12345678";
		cdId = "87654321";
		initialCdBalance = 1000.0;
		checkingAccount = new Checking(checkingId, 1.5);
		cdAccount = new CD(cdId, 2.0, initialCdBalance);
	}

	@Test
	void checking_account_creation() {
		assertEquals(0, checkingAccount.getBalance());
		assertEquals(1.5, checkingAccount.getApr());
	}

	@Test
	void cd_account_creation() {
		assertEquals(initialCdBalance, cdAccount.getBalance());
		assertEquals(2.0, cdAccount.getApr());
	}

	@Test
	void deposit_into_checking_account() {
		checkingAccount.deposit(500);
		assertEquals(500, checkingAccount.getBalance());
	}

	@Test
	void deposit_into_cd_account() {
		cdAccount.deposit(500);
		assertEquals(1500, cdAccount.getBalance());
	}

	@Test
	void withdraw_from_checking_account() {
		checkingAccount.deposit(500);
		checkingAccount.withdraw(300);
		assertEquals(200, checkingAccount.getBalance());
	}

	@Test
	void withdraw_from_cd_account() {
		cdAccount.withdraw(500);
		assertEquals(500, cdAccount.getBalance());
	}

	@Test
	void withdraw_more_than_balance_from_checking_account() {
		checkingAccount.deposit(500);
		checkingAccount.withdraw(600);
		assertEquals(0, checkingAccount.getBalance());
	}

	@Test
	void withdraw_more_than_balance_from_cd_account() {
		cdAccount.withdraw(1500);
		assertEquals(0, cdAccount.getBalance());
	}
}
