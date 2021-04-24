package bank;
import java.util.Scanner;

public class Menu {
		
	private Scanner keyboardIn;
	private Account customerAccount;
	private Employee employee;
	private static int highestAcceptableInput;
	
	public Menu() {
		 keyboardIn = new Scanner(System.in);
		 customerAccount = new Account();
		 employee = new Employee();
		 highestAcceptableInput = 0;
	}

	public static void main(String[] args) {
		Menu bankMenu = new Menu();
		highestAcceptableInput = 2;
		bankMenu.runMenu();
	}

	public void runMenu() {
		
		this.displayMainMenu();
		
		int selectedOption = this.getUserInput();
		
		this.processMainMenu(selectedOption);
		keyboardIn.close();
	}
	
	
	public void displayMainMenu() {
		System.out.println("Welcome to Bear Banks!");
		System.out.println("I am a...");
		
		System.out.println("(1) Customer");
		System.out.println("(2) Employee");
	}

	public void processMainMenu(int selectedOption) {
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
			selectedOption = this.getUserInput();
			
			this.processMainMenu(selectedOption);
		}
	}
	
	public void displayCustomerMenu() {
		System.out.println("(1) Create Account");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");

		highestAcceptableInput = 3;

	}
	
	public void displayEmployeeMenu() {
		System.out.println("(1) Lock the ATM");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");

		highestAcceptableInput = 3;
	}
	
	public void processCustomerMenu(int CustomerOption) {
		
		if (CustomerOption == 1) {
			customerAccount.initializeAccountDetails(customerAccount);
			this.displayCustomerOptionsMenu();
		}
		else if (CustomerOption == 2) {
			exitProgram();
		}
		else if (CustomerOption == 3) {
			highestAcceptableInput = 2;
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
		
		highestAcceptableInput = 5;
		processCustomerOptionsMenu();
	}

	public void processCustomerOptionsMenu() {
		int selectedOption = getUserInput();
		if (selectedOption == 1) {
			System.out.println("Your current balance is: $" + customerAccount.getBalance());
			displayCustomerOptionsMenu();
		}
		else if (selectedOption == 2) {
			System.out.println("How much cash would you like to deposit?");
			String depositAmountString = getUserStringInput();
			customerAccount.depositCash(depositAmountString);
			displayCustomerOptionsMenu();
		}
		else if (selectedOption == 3) {
			System.out.println("How much cash would you like to withdraw?");
			String withdrawAmountString = getUserStringInput();
			customerAccount.withdrawCash(withdrawAmountString);
			displayCustomerOptionsMenu();
		}
		else if (selectedOption == 4) {
			exitProgram();
		}
		else if (selectedOption == 5) {
			displayCustomerMenu();
			
			highestAcceptableInput = 3;
			processCustomerMenu(this.getUserInput());
		}
		else {
			System.out.println("Please select one of the available options.");
			displayCustomerOptionsMenu();
		}
	}

	public void processEmployeeMenu(int EmployeeOption) {
		if (EmployeeOption == 1) {
			employee.displayEmployeeQuestionnaire();
		}
		else if (EmployeeOption == 2) {
			System.out.println("Exiting the program");
			return;
		}
		else if (EmployeeOption == 3) {
			highestAcceptableInput = 2;
			runMenu();
		}
		else {
			System.out.println("Please select one of the available options.");
			displayEmployeeMenu();
			EmployeeOption = this.getUserInput();
			this.processEmployeeMenu(EmployeeOption);
		}
	}
	
	public int getUserInput() {
		try {
			int selectedOption = keyboardIn.nextInt();
			
			if (selectedOption > 0 && selectedOption <= highestAcceptableInput) {
				return selectedOption;
			}
			else {
				System.out.println("Please choose an option from 1 to " + highestAcceptableInput + ".");
				return getUserInput();
			}
		}
		
		catch(Exception e) {
			keyboardIn.nextLine();
			System.out.println("Please choose an option from 1 to " + highestAcceptableInput + ".");
			return getUserInput();
		}
	}
	
	public void exitProgram() {
		System.out.println(customerAccount.printReceipt(customerAccount));
		customerAccount.displayMealPoints();
		System.out.println("Exiting the program...");
		System.exit(0);
	}
	
	public int getMoneyInput() {
		return keyboardIn.nextInt();
	}
	
	public String getUserStringInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextLine();
	}
	
	public int getHighestAcceptableInput() {
		return highestAcceptableInput;
	}
	
}

