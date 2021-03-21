package bank;
import java.util.Scanner;

public class Menu {
	
	private Scanner keyboardIn;
	
	public Menu() {
		 keyboardIn = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Menu bankMenu = new Menu();
		bankMenu.runMenu();
	}

	private void runMenu() {
		this.displayMainMenu();
		
		int selectedOption = this.getUserInput();
		
		this.processMainMenu(selectedOption);
		keyboardIn.close();
	}

	// check if input != 1, 2
	private void processMainMenu(int selectedOption) {
		if(selectedOption == 1) {
			this.displayCustomerMenu();
			 
			int CustomerOption = this.getUserInput();
			this.processCustomerMenu(CustomerOption);
		}
		else {
			this.displayEmployeeMenu();

			int EmployeeOption = this.getUserInput();
			this.processEmployeeMenu(EmployeeOption);
		}
	}
	
	private void processCustomerMenu(int CustomerOption) {
		// to modify
		
		if (CustomerOption == 1) {
			System.out.println("Viewing Balance");
		}
		else if (CustomerOption == 2) {
			System.out.println("Withdrawing Cash");
		}
		else if (CustomerOption == 3) {
			System.out.println("Depositing Cash");
		}
	}

	private void processEmployeeMenu(int EmployeeOption) {
		// to modify
		if(EmployeeOption == 1) {
			System.out.println("Locking the ATM");
		}
	}
	
	private void displayCustomerMenu() {
		System.out.println("(1) View Balance");
		System.out.println("(2) Withdraw Cash");
		System.out.println("(3) Deposit Cash");
	}
	
	private void displayEmployeeMenu() {
		System.out.println("(1) Lock the ATM");
		
		// to add: view customers, view balances, close accounts
	}

	private void displayMainMenu() {
		System.out.println("Welcome to Bear Banks!");
		System.out.println("I am a...");
		
		System.out.println("(1) Customer");
		System.out.println("(2) Employee");
	}
	
	private int getUserInput() {
		return keyboardIn.nextInt();
	}

	// createAccount();
	
}
