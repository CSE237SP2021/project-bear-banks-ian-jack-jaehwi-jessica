package bank;
import java.util.InputMismatchException;
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
	}
	
	private void displayEmployeeMenu() {
		System.out.println("(1) Lock the ATM");
	}
	
	private void processCustomerMenu(int CustomerOption) {
		
		if (CustomerOption == 1) {
			
			System.out.println("Please enter your name.");
			String accountOwner = getUserStringInput();
			
			System.out.println("Please choose a four-digit PIN number.");
			int pinNumber = getUserInput();
			
			Account newCustomerAccount = new Account();
			
			boolean pinIsValid = newCustomerAccount.checkPinValidity(pinNumber);
			
			while (!pinIsValid) {
				pinNumber = getUserInput();
				pinIsValid = newCustomerAccount.checkPinValidity(pinNumber);
			}
			
			newCustomerAccount = new Account(accountOwner, pinNumber);
			
			System.out.println("Success! We've created your new account.");
			System.out.println("Account name: " + newCustomerAccount.getAccountOwner());
			System.out.println("Pin Number: " + newCustomerAccount.getPinNumber());
			
			this.displayCustomerOptionsMenu();
		}
		else {
			System.out.println("You have to create an account! Please choose option (1).");
			int newCustomerOption = this.getUserInput();
			this.processCustomerMenu(newCustomerOption);
		}
	}
	
	public void displayCustomerOptionsMenu() {
		System.out.println("(1) View Balance");
		System.out.println("(2) Withdraw Cash");
		System.out.println("(3) Deposit Cash");
		
		int selectedOption = getUserInput();
		if (selectedOption == 1) {
			System.out.println("Additional functionality to implement later (viewing balance)");
		}
		else if (selectedOption == 2) {
			System.out.println("Additional functionality to implement later (withdrawing cash)");
		}
		else if (selectedOption == 3) {
			System.out.println("Additional functionality to implement later (depositing cash)");
		}
		else {
			System.out.println("Please select one of the available options.");
			displayCustomerOptionsMenu();
		}
	}

	private void processEmployeeMenu(int EmployeeOption) {
		if (EmployeeOption == 1) {
			System.out.println("Additional functionality to implement later (locking the ATM)");
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
	
	private String getUserStringInput() {
		String extraInput = keyboardIn.nextLine();
		return keyboardIn.nextLine();
	}
	
}
