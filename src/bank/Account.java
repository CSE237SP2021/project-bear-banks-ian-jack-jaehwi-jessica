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
	
	public boolean checkPinValidity(int pinNumber) {
		while (Integer.toString(pinNumber).length() != 4 || (pinNumber < 0)) {
			System.out.println("Valid PIN numbers are positive, four-digit integers.");
			return false;
		}
		return true;
	}
	
	
	
		//creates a file with "accountInfoFileName" with the contents below:
			// line 0: client name
			// line 1: pin number
			// line 2: balance ($0 initially)		
		public void createAccountInfoFile() {
			try {
				FileWriter myWriter = new FileWriter(this.accountInfoFileName);
				myWriter.write(this.accountOwner + "\n");
				myWriter.write(this.pinNumber + "\n");
				myWriter.write("0\n");
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		
		
		
		//reference: https://stackoverflow.com/questions/4614227/how-to-add-a-new-line-of-text-to-an-existing-file-in-java
		//this adds the new balance (after withdrawal or depositing) as a new line on the file
		//check the file after running this method, you'll find that the file is updated with whatever the "newBalance" is
		public void updateBalanceOnFile(int newBalance) {
			try {
				FileWriter myWriter = new FileWriter(this.accountInfoFileName, true);
				Writer writer = new BufferedWriter(myWriter);
				writer.append(newBalance + "\n");
				writer.close();
				myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		//read the last line of the file, which is the current balance
		//returns a string (I wish it would return int, but lines are read as strings rather than integers)
		public String readBalance() {
			String last = "";

			try {
				File myObj = new File(this.accountInfoFileName);
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					//System.out.println(data);
					last = data;
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			return last;
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
		
		Account account1 = new Account ("jack", 1234);
		System.out.println(account1.accountInfoFileName);
		
		
		//try the lines below (ONE BY ONE! Uncomment after using the method to avoid conflict)
		
		//the file you create using .createAccountInfoFile() will be listed in the repository directory (on the command line)
		
		//1.
		//account1.createAccountInfoFile();
			//file content result: 
				//		jack
				//		1234
				//		0
		
		
		//2.
		//account1.updateBalanceOnFile(500);
			//file content result:
				//		jack
				//		1234
				//		0
				//		500
		
		//3.
		//String mostRecentBalance = account1.readBalance();
		//System.out.println("Your current balance is $" + mostRecentBalance);
		
	}
}