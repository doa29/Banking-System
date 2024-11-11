// Daniel Amayaenvbo, doa29
// Last Update: November 10th 2024

// Class representing a Checking account, extending the Account class
public class Checking extends Account {

	// Constructor to initialize a Checking account with an ID and APR, setting initial balance to 0
	public Checking(String id, double apr) {
		super(id, apr, 0); // Call the constructor of the Account class with an initial balance of 0
	}
}
