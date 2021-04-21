package bank;
import java.util.Scanner;

public class Account {
	
	private String accountOwner;
	private int pinNumber;
	private int accountBalance;
	private static String receipt;

	public Account() {}
	
	public Account(String accountOwner, int pinNumber) {
		this.accountOwner = accountOwner;
		this.pinNumber = pinNumber;
		this.accountBalance = 0;
		receipt = "";
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
			receipt += "You deposited $" + depositAmount + ", making your balance $" + this.getBalance() + "." + "\n";
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
				receipt += "You withdrew $" + withdrawAmount + ", making your balance $" + this.getBalance() + "." + "\n";
			}
		}
	}
	
	public String printReceipt(Account customerAccount) {
		if("".equals(receipt)) {
			return "No transaction history to record.";
		}
		return receipt;
	}
	
	public void displayMealPoints() {
		System.out.println("Since you're a WashU student, we've calculated your balance in terms of meal plans...");
		System.out.println("If you have the Gold Meal Plan:");
		System.out.println("Your balance of $" + this.getBalance() + " equals " + mealPointsConversion("gold") + " meal points.");
		System.out.println("If you have the Silver Meal Plan:");
		System.out.println("Your balance of $" + this.getBalance() + " equals " + mealPointsConversion("silver") + " meal points.");
		System.out.println("If you have the Bronze Meal Plan:");
		System.out.println("Your balance of $" + this.getBalance() + " equals " + mealPointsConversion("bronze") + " meal points.");
		System.out.println();
	}
	
	public int mealPointsConversion(String planType) {
		int mealPoints = 0;
		if("gold".equals(planType)){
			mealPoints = (int)(this.getBalance() * (2450.0/3222));
		}
		if("silver".equals(planType)) {
			mealPoints = (int)(this.getBalance() * (1997.0/2775));
		}
		if("bronze".equals(planType)) {
			mealPoints = (int)(this.getBalance() * (1547.0/2319));
		}
		
		return mealPoints;
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
