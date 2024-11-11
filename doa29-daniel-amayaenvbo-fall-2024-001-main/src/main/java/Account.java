// Daniel Amayaenvbo,doa29
// Last Update: November 10, 2024

// Abstract class for representing a basic Account
public abstract class Account {
    
    private String id; // Unique identifier for the account
    private double balance; // Current balance of the account
    private double apr; // Annual percentage rate (APR) applied to the account

    // Constructor to initialize the account with an ID, APR, and initial balance
    public Account(String id, double apr, double initialBalance) {
        this.id = id;
        this.apr = apr;
        this.balance = initialBalance;
    }

    // Returns the account's unique identifier
    public String getId() {
        return id;
    }

    // Returns the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Returns the annual percentage rate (APR) of the account
    public double getApr() {
        return apr;
    }

    // Deposits a specified amount into the account if the amount is positive
    public void deposit(double amount) {
        // Ensure the deposit amount is positive
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraws a specified amount from the account
    // If the withdrawal amount exceeds the balance, the balance is set to 0
    public void withdraw(double amount) {
        // If withdrawal amount exceeds balance, set balance to 0
        if (amount > balance) {
            balance = 0;
        } else if (amount > 0) {
            balance -= amount;
        }
    }
}
