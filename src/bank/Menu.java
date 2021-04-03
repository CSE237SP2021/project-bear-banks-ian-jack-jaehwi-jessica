package bank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
		
	private Scanner keyboardIn;
	private Account customerAccount;
	
	public Menu() {
		 keyboardIn = new Scanner(System.in);
		 customerAccount = new Account();
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
	
	
	private void displayMainMenu() {
		System.out.println("Welcome to Bear Banks!");
		System.out.println("I am a...");
		
		System.out.println("(1) Customer");
		System.out.println("(2) Employee");
	}

	private void processMainMenu(int selectedOption) {
		if (selectedOption == 1) {
			this.displayCustomerMenu();
			 
			int CustomerOption = this.getUserInput();
			this.processCustomerMenu(CustomerOption);
		}
		else if (selectedOption == 2) {
			this.displayEmployeeMenu();

			int EmployeeOption = this.getUserInput();
			this.processEmployeeMenu(EmployeeOption);
		}
		else {
			System.out.println("Please select option (1) or (2).");
			selectedOption = this.getUserInput();
			
			this.processMainMenu(selectedOption);
		}
	}
	
	private void displayCustomerMenu() {
		System.out.println("(1) Create Account");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");
	}
	
	private void displayEmployeeMenu() {
		System.out.println("(1) Lock the ATM");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");
	}
	
	private void processCustomerMenu(int CustomerOption) {
		
		if (CustomerOption == 1) {
			customerAccount.initializeAccountDetails(customerAccount);
			this.displayCustomerOptionsMenu();
		} else if (CustomerOption == 2) {
			exitProgram();
		} else if (CustomerOption == 3) {
			runMenu();
		}
		
		else {
			System.out.println("Please select one of the available options.");
			int newCustomerOption = this.getUserInput();
			this.processCustomerMenu(newCustomerOption);
		}
	}
	
	public void displayCustomerOptionsMenu() {
		System.out.println("(1) View Balance");
		System.out.println("(2) Deposit Cash");
		System.out.println("(3) Withdraw Cash");
		System.out.println("(4) Exit");
		System.out.println("(5) Go Back");
		
		int selectedOption = getUserInput();
		if (selectedOption == 1) {
			System.out.println("Your current balance is: $" + customerAccount.getBalance());
		}
		else if (selectedOption == 2) {
			System.out.println("How much cash would you like to deposit?");
			int depositAmount = getUserInput();
			customerAccount.depositCash(depositAmount);
		}
		else if (selectedOption == 3) {
			System.out.println("How much cash would you like to withdraw?");
			int withdrawAmount = getUserInput();
			customerAccount.withdrawCash(withdrawAmount);
		}
		else if (selectedOption == 4) {
			exitProgram();
		}
		else if (selectedOption == 5) {
			displayCustomerMenu();
			processCustomerMenu(this.getUserInput());
		}
		else {
			System.out.println("Please select one of the available options.");
		}
		displayCustomerOptionsMenu();
	}

	private void exitProgram() {
		System.out.println("Exiting the program...");
		System.exit(0);
	}

	private void processEmployeeMenu(int EmployeeOption) {
		if (EmployeeOption == 1) {
			System.out.println("Additional functionality to implement later (locking the ATM)");
		} else if (EmployeeOption == 2) {
			System.out.println("Exiting the program");
			return;
		} else if (EmployeeOption == 3) {
			runMenu();
		}
		else {
			System.out.println("Please select one of the available options.");
			displayEmployeeMenu();
			EmployeeOption = this.getUserInput();
			this.processEmployeeMenu(EmployeeOption);
		}
	}
	
	private int getUserInput() {
		return keyboardIn.nextInt();
	}
}
