// Daniel Amayaenvbo, doa29
// Last Update: November 10th 2024

// Class representing a Savings account, extending the Account class
public class Savings extends Account {

	// Constructor to initialize a Savings account with an ID and APR, setting the initial balance to 0
	public Savings(String id, double apr) {
		super(id, apr, 0); // Call the constructor of the Account class with an initial balance of 0
	}
}
