// Daniel Amayaenvbo,doa29
// Last Update: November 10, 2024

// Class representing a Certificate of Deposit (CD) account, extending the Account class
public class CD extends Account {

	// Constructor to initialize a CD account with an ID, APR, and initial balance
	public CD(String id, double apr, double initialBalance) {
		super(id, apr, initialBalance); // Call the constructor of the Account class to initialize common properties
	}
}
