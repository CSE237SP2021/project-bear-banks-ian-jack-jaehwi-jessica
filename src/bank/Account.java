package bank;
import java.util.Scanner;

public class Account {
	
	private String accountOwner;
	private int pinNumber;
	private int accountBalance;

	public Account() {}
	
	public Account(String accountOwner, int pinNumber) {
		this.accountOwner = accountOwner;
		this.pinNumber = pinNumber;
		this.accountBalance = 0;
	}
	
	public void initializeAccountDetails(Account customerAccount) {
		
		System.out.println("Please enter your name.");
		String accountOwner = getUserStringInput();
		
		System.out.println("Please choose a four-digit PIN number.");
		String pinNumberString = getUserStringInput();
		
		boolean pinIsValid = customerAccount.checkPinValidity(pinNumberString);
		
		while (!pinIsValid) {
			pinNumberString = getUserStringInput();
			pinIsValid = customerAccount.checkPinValidity(pinNumberString);
		}
		pinNumber = Integer.parseInt(pinNumberString);
		customerAccount = new Account(accountOwner, pinNumber);

		System.out.println("Success! We've created your new account.");
		System.out.println("Account name: " + customerAccount.getAccountOwner());
		reformatPinNumber(customerAccount);
	}

	public boolean checkPinValidity(String pinNumberString) {
		if(!StringIsInt(pinNumberString)) {
			System.out.println("Please only enter digits when choosing a PIN number.");
			return false;
		}
		if (pinNumberString.length() != 4 || pinNumber > 9999 || pinNumber < 0) {
			System.out.println("Valid PIN numbers are positive, four-digit integers.");
			return false;
		}
		return true;
	}
	
	public static boolean StringIsInt(String stringThatMayBeInt) {
		int numIntegerFound = 0;
		for(int i = 0; i < stringThatMayBeInt.length(); i++) {
			if(Character.isDigit(stringThatMayBeInt.charAt(i))) {
				numIntegerFound++;
			}
		}
		if(numIntegerFound == stringThatMayBeInt.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reformatPinNumber(Account customerAccount) {
		if (pinNumber < 10) {
			System.out.println("Pin Number: 000" + customerAccount.getPinNumber());
		}
		else if (pinNumber < 100) {
			System.out.println("Pin Number: 00" + customerAccount.getPinNumber());
		}
		else if (pinNumber < 1000) {
			System.out.println("Pin Number: 0" + customerAccount.getPinNumber());
		}
		else {
			System.out.println("Pin Number: " + customerAccount.getPinNumber());
		}
	}
	
	public void depositCash(int depositAmount) {
		if (depositAmount <= 0) {
			System.out.println("Please enter an amount greater than $0.");
		} else {
			this.accountBalance += depositAmount;
			System.out.println("Your new balance is: $" + this.getBalance());
		}
	}
	
	public void withdrawCash(int withdrawAmount) {
		if (withdrawAmount <= 0) {
			System.out.println("Please enter an amount greater than $0.");
		} else {
			if (withdrawAmount > this.getBalance()) {
				System.out.println("Your account does not have that much cash!");
			} else {
				this.accountBalance -= withdrawAmount;
				System.out.println("Your new balance is: $" + this.getBalance());
			}
		}
	}
	
	public int getUserInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextInt();
	}
		
	public String getUserStringInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextLine();
	}
	
	public String getAccountOwner() {
		return accountOwner;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	public int getBalance() {
		return this.accountBalance;
	}
}
