import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

	private Bank bank;
	private String checkingId;
	private String cdId;

	private double initialCdBalance;
	private Checking checkingAccount;
	private CD cdAccount;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		checkingId = "11111111";
		cdId = "22222222";
		initialCdBalance = 1000.0;
		checkingAccount = new Checking(checkingId, 1.2);
		cdAccount = new CD(cdId, 2.0, initialCdBalance);
	}

	@Test
	void test_bank_starts_with_no_accounts() {
		assertNull(bank.getAccount(checkingId));
	}

	@Test
	void test_adding_one_account_to_bank() {
		bank.addAccount(checkingAccount);
		assertEquals(checkingAccount, bank.getAccount(checkingId));
	}

	@Test
	void test_adding_two_accounts_to_bank() {
		bank.addAccount(checkingAccount);
		bank.addAccount(cdAccount);
		assertEquals(checkingAccount, bank.getAccount(checkingId));
		assertEquals(cdAccount, bank.getAccount(cdId));
	}

	@Test
	void test_retrieve_correct_account_from_bank() {
		bank.addAccount(checkingAccount);
		bank.addAccount(cdAccount);
		assertEquals(checkingAccount, bank.getAccount(checkingId));
		assertEquals(cdAccount, bank.getAccount(cdId));
	}

	@Test
	void test_deposit_into_correct_account() {
		bank.addAccount(checkingAccount);
		bank.deposit(checkingId, 500);
		assertEquals(500, bank.getAccount(checkingId).getBalance());
	}

	@Test
	void test_withdraw_from_correct_account() {
		bank.addAccount(cdAccount);
		bank.withdraw(cdId, 500);
		assertEquals(initialCdBalance - 500, bank.getAccount(cdId).getBalance());
	}

	@Test
	void test_depositing_twice_works() {
		bank.addAccount(checkingAccount);
		bank.deposit(checkingId, 200);
		bank.deposit(checkingId, 300);
		assertEquals(500, bank.getAccount(checkingId).getBalance());
	}

	@Test
	void test_withdrawing_twice_works() {
		bank.addAccount(cdAccount);
		bank.withdraw(cdId, 400);
		bank.withdraw(cdId, 500);
		assertEquals(100, bank.getAccount(cdId).getBalance());
	}
}
