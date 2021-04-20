package bank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
		
	private Scanner keyboardIn;
	private Account customerAccount;
	private Employee employee;
	private static List<Integer> correctInputs;
	
	public Menu() {
		 keyboardIn = new Scanner(System.in);
		 customerAccount = new Account();
		 employee = new Employee();
		 correctInputs = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		Menu bankMenu = new Menu();
		correctInputs.add(1);
		correctInputs.add(2);
		bankMenu.runMenu();
	}

	public void runMenu() {
		
		this.displayMainMenu();
		
		int selectedOption = this.getUserInput(correctInputs);
		
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
			 
			int CustomerOption = this.getUserInput(correctInputs);
			this.processCustomerMenu(CustomerOption);
		}
		else if (selectedOption == 2) {
			this.displayEmployeeMenu();

			int EmployeeOption = this.getUserInput(correctInputs);
			this.processEmployeeMenu(EmployeeOption);
		}
		else {
			selectedOption = this.getUserInput(correctInputs);
			
			this.processMainMenu(selectedOption);
		}
	}
	
	public void displayCustomerMenu() {
		System.out.println("(1) Create Account");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");

		correctInputs.add(3);

	}
	
	public void displayEmployeeMenu() {
		System.out.println("(1) Lock the ATM");
		System.out.println("(2) Exit");
		System.out.println("(3) Go Back");

		correctInputs.add(3);
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
			correctInputs.remove(2);
			runMenu();
		}
		
		else {
			System.out.println("Please select one of the available options.");
			int newCustomerOption = this.getUserInput(correctInputs);
			this.processCustomerMenu(newCustomerOption);
		}
	}
	
	public void displayCustomerOptionsMenu() {
		System.out.println("(1) View Balance");
		System.out.println("(2) Deposit Cash");
		System.out.println("(3) Withdraw Cash");
		System.out.println("(4) Exit");
		System.out.println("(5) Go Back");
		
		if (!correctInputs.contains(4) && !correctInputs.contains(5)) {
			correctInputs.add(4);
			correctInputs.add(5);
		}
		
		processCustomerOptionsMenu();
	}

	public void processCustomerOptionsMenu() {
		int selectedOption = getUserInput(correctInputs);
		if (selectedOption == 1) {
			System.out.println("Your current balance is: $" + customerAccount.getBalance());
		}
		else if (selectedOption == 2) {
			System.out.println("How much cash would you like to deposit?");
			int depositAmount = getMoneyInput();
			customerAccount.depositCash(depositAmount);
		}
		else if (selectedOption == 3) {
			System.out.println("How much cash would you like to withdraw?");
			int withdrawAmount = getMoneyInput();
			customerAccount.withdrawCash(withdrawAmount);
		}
		else if (selectedOption == 4) {
			exitProgram();
		}
		else if (selectedOption == 5) {
			
			displayCustomerMenu();
			
			correctInputs.remove(4);
			correctInputs.remove(3);
			correctInputs.remove(2);
			processCustomerMenu(this.getUserInput(correctInputs));
		}
		else {
			System.out.println("Please select one of the available options.");
		}
		displayCustomerOptionsMenu();
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
			correctInputs.remove(2);
			runMenu();
		}
		else {
			System.out.println("Please select one of the available options.");
			displayEmployeeMenu();
			EmployeeOption = this.getUserInput(correctInputs);
			this.processEmployeeMenu(EmployeeOption);
		}
	}
	
	public int getUserInput(List<Integer> correctInputs) {
		try {
			int selectedOption = keyboardIn.nextInt();
			
			if (correctInputs.contains(selectedOption)) {
				return selectedOption;
			}
			else {
				System.out.println("Please choose an option from " + correctInputs.get(0) + " to " + 
									correctInputs.get(correctInputs.size() - 1) + ".");
				return getUserInput(correctInputs);
			}
		}
		
		catch(Exception e) {
			keyboardIn.nextLine();
			System.out.println("Please choose an option from " + correctInputs.get(0) + " to " + 
								correctInputs.get(correctInputs.size() - 1) + ".");
			return getUserInput(correctInputs);
		}
	}
	
	public int getMoneyInput() {
		return keyboardIn.nextInt();
	}
	
	public void exitProgram() {
		System.out.println(customerAccount.printReceipt(customerAccount));
		customerAccount.displayMealPoints();
		System.out.println("Exiting the program...");
		System.exit(0);
	}
}

