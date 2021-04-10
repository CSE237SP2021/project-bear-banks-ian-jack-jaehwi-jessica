package bank;
import java.util.Scanner;

public class Employee {
	
	public Employee() {}
	
	public void displayEmployeeQuestionnaire() {
		
		System.out.println("To verify your identity as an employee, we will ask you three security questions.");
		
		displayQuestionOne();
		
		String input = getEmployeeStringInput();
		
		if(input.equals("A")) {
			displayQuestionTwo();
			
			input = getEmployeeStringInput();
			
			if(input.equals("B")) {
				displayQuestionThree();
				
				input = getEmployeeStringInput();
				
				if(input.equals("C")) {
					welcomeEmployee();
				}
				else {
					System.out.println("Answer to Q3 is incorrect!");
					displayEmployeeQuestionnaire();	
				}
				
			}
			else {
				System.out.println("Answer to Q2 is incorrect!");
				displayEmployeeQuestionnaire();
			}
			
		}
		else {
			System.out.println("Answer to Q1 is incorrect!");
			displayEmployeeQuestionnaire();
		}
		
	}

	private void displayQuestionOne() {
		System.out.println("1. When was Bear Banks founded?");
		System.out.println("A. 2021");
		System.out.println("B. 2022");
		System.out.println("C. 4200");
	} 

	private void displayQuestionTwo() {
		System.out.println("2. Who founded Bear Banks?");
		System.out.println("A. Professor Shook");
		System.out.println("B. Jaehwi, Jack, Ian, and Jessica");
		System.out.println("C. Aaron and Marc");
	}
	
	private void displayQuestionThree() {
		System.out.println("3. How many project iterations were there in total?");
		System.out.println("A. 0");
		System.out.println("B. 1");
		System.out.println("C. 3");
	}
	
	private void welcomeEmployee() {
		System.out.println("Welcome, Bear Banks employee!");
		System.out.println("To confirm you are not a computer, please enter the number '10' to lock the ATM.");
		
		String verificationNumber = getEmployeeStringInput();
		
		attemptToLockATM(verificationNumber);
	}
	
	public boolean attemptToLockATM(String verificationNumber) {
		
		if(verificationNumber.equals("10")) {
			System.out.println("Locking the ATM...");
			return true;
		}
		else {
			System.out.println("Failed to lock ATM.");
			return false;
		}
	}
	
	private String getEmployeeStringInput() {
		Scanner keyboardIn = new Scanner(System.in);
		return keyboardIn.nextLine();
	}
	
}
