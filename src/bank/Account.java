package bank;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Account {
	
	private String accountOwner;
	private int pinNumber;
	private int accountBalance;
	private String accountInfoFileName;

	public Account() {}
	
	public Account(String accountOwner, int pinNumber) {
		this.accountOwner = accountOwner;
		this.pinNumber = pinNumber;
		this.accountBalance = 0;
		this.accountInfoFileName = accountOwner + "_" + pinNumber + ".txt";
	}
	
	public void initializeAccountDetails(Account customerAccount) {
		System.out.println("Please enter your name.");
		String accountOwner = getUserStringInput();
		
		System.out.println("Please choose a four-digit PIN number.");
		//int pinNumber = getUserInput();
		String pinNumberString = getUserStringInput();
		
		
				
		boolean pinIsValid = customerAccount.checkPinValidity(pinNumberString);
		
		while (!pinIsValid) {
			//pinNumber = getUserInput();
			pinNumberString = getUserStringInput();
			pinIsValid = customerAccount.checkPinValidity(pinNumberString);
		}
		pinNumber = Integer.parseInt(pinNumberString);
		customerAccount = new Account(accountOwner, pinNumber);
		
		System.out.println("Success! We've created your new account.");
		System.out.println("Account name: " + customerAccount.getAccountOwner());
		System.out.println("Pin Number: " + customerAccount.getPinNumber());
		if(pinNumber < 10) {
			System.out.println("Pin Number: 000" + customerAccount.getPinNumber());
		}
		else if (pinNumber < 100) {
			System.out.println("Pin Number: 00" + customerAccount.getPinNumber());
		}
		else if (pinNumber < 1000) {
			System.out.println("Pin Number: 0" + customerAccount.getPinNumber());
		}
	}

	public boolean checkPinValidity(String pinNumberString) {
		if(StringIsInt(pinNumberString)) {
			int pinNumber = Integer.parseInt(pinNumberString);  
		}
		else {
			System.out.println("Valid PIN numbers are positive, four-digit integers.");
			return false;
		}
		if (pinNumberString.length() != 4 || pinNumber > 9999 || pinNumber < 0) {
			System.out.println("Valid PIN numbers are positive, four-digit integers.");
			return false;
		}
		return true;
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
	
	
	
	private int getUserInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextInt();
	}
		
	private String getUserStringInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextLine();
	}
	
	private static boolean StringIsInt(String stringThatMayBeInt) {
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
	
	
	public String getAccountOwner() {
		return accountOwner;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	public int getBalance() {
		return this.accountBalance;
	}

	public static void main(String[] args) {
		
	
		
	}
}
