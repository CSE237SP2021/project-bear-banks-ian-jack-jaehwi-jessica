package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.Account;

class AccountTest {
	
	@Test
	void checkStringIsIntTest() {
		assertTrue(Account.StringIsInt("10"));
	}
	
	@Test
	void checkStringIsNotIntTest() {
		assertFalse(Account.StringIsInt("notAnInt"));
	}
	
	@Test
	void catchLargePinNumberTest() {
		Account tooBigPinNumber = new Account("John Smith", 12345);
		assertFalse(tooBigPinNumber.checkPinValidity(Integer.toString(tooBigPinNumber.getPinNumber())));
	}
	
	@Test
	void catchNegativePinNumberTest() {
		Account negativePinNumber = new Account("John Smith", -123);
		assertFalse(negativePinNumber.checkPinValidity(Integer.toString(negativePinNumber.getPinNumber())));
	}
	
	@Test
	void catchExtraZeroPinNumberTest() {
		Account extraZeroPinNumber = new Account("John Smith", 00001234);
		assertFalse(extraZeroPinNumber.checkPinValidity(Integer.toString(extraZeroPinNumber.getPinNumber())));
	}
	
	@Test
	void checkAcceptablePinNumberTest() {
		Account acceptablePinNumber = new Account("John Smith", 1234);
		assertTrue(acceptablePinNumber.checkPinValidity(Integer.toString(acceptablePinNumber.getPinNumber())));
	}
	
	@Test
	void catchNegativeDepositTest() {
		Account negativeDeposit = new Account("John Smith", 1111);
		negativeDeposit.depositCash("-10");
		assertNotEquals(-10, negativeDeposit.getBalance());
	}
	
	@Test
	void catchPositiveDepositTest() {
		Account positiveDeposit = new Account("John Smith", 1111);
		positiveDeposit.depositCash("10");
		assertEquals(10, positiveDeposit.getBalance());
	}
	
	@Test
	void catchNegativeWithdrawTest() {
		Account negativeWithdraw = new Account("John Smith", 1111);
		negativeWithdraw.depositCash("20");
		negativeWithdraw.withdrawCash("-10");
		assertNotEquals(30, negativeWithdraw.getBalance());
	}
	
	@Test
	void catchExcessiveWithdrawTest() {
		Account excessiveWithdraw = new Account("John Smith", 1111);
		excessiveWithdraw.depositCash("20");
		excessiveWithdraw.withdrawCash("30");
		assertNotEquals(-10, excessiveWithdraw.getBalance());
	}
	
	@Test
	void catchCorrectWithdrawTest() {
		Account correctWithdraw = new Account("John Smith", 1111);
		correctWithdraw.depositCash("20");
		correctWithdraw.withdrawCash("10");
		assertEquals(10, correctWithdraw.getBalance());
	}
	
	@Test
	void checkEmptyReceipt() {
		Account noTransactions = new Account("John Smith", 1111);
		assertEquals("No transaction history to record.", noTransactions.printReceipt(noTransactions));
	}
	
	@Test
	void depositReceipt() {
		Account depositReceipt = new Account("John Smith", 0111);
		depositReceipt.depositCash("20");
		depositReceipt.depositCash("30");
		String correctReceipt = "You deposited $20, making your balance $20." + "\n"
				+ "You deposited $30, making your balance $50." + "\n";
		assertEquals(correctReceipt, depositReceipt.printReceipt(depositReceipt));
	}
	
	@Test
	void compoundReceipt() {
		Account compoundReceipt = new Account("John Smith", 0111);
		compoundReceipt.depositCash("20");
		compoundReceipt.depositCash("30");
		compoundReceipt.withdrawCash("10");
		compoundReceipt.withdrawCash("5");
		String correctReceipt = "You deposited $20, making your balance $20." + "\n"
				+ "You deposited $30, making your balance $50." + "\n"
				+ "You withdrew $10, making your balance $40." + "\n"
				+ "You withdrew $5, making your balance $35." + "\n";
		assertEquals(correctReceipt, compoundReceipt.printReceipt(compoundReceipt));
	}
	
	@Test
	void checkMealPointsConversionGold() {
		Account preMealPoints = new Account("John Smith", 0111);
		preMealPoints.depositCash("1000");
		assertEquals(760,preMealPoints.mealPointsConversion("gold"));
	}
	
	@Test
	void checkMealPointsConversionSilver() {
		Account preMealPoints = new Account("John Smith", 0111);
		preMealPoints.depositCash("1000");
		assertEquals(719,preMealPoints.mealPointsConversion("silver"));
	}
	
	@Test
	void checkMealPointsConversionBronze() {
		Account preMealPoints = new Account("John Smith", 0111);
		preMealPoints.depositCash("1000");
		assertEquals(667,preMealPoints.mealPointsConversion("bronze"));
	}
	
	
	
	@Test
	void catchStringDepositTest() {
		Account stringDeposit = new Account("John Smith", 1111);
		stringDeposit.depositCash("this is a string");
		assertEquals(0, stringDeposit.getBalance());
	}
	
	@Test
	void catchDoubleDepositTest() {
		Account doubleDeposit = new Account("John Smith", 1111);
		doubleDeposit.depositCash("10.5");
		assertEquals(0, doubleDeposit.getBalance());
	}
	
	@Test
	void catchStringWithdrawTest() {
		Account stringWithdraw = new Account("John Smith", 1111);
		stringWithdraw.depositCash("20");
		stringWithdraw.withdrawCash("this is a string");
		assertEquals(20, stringWithdraw.getBalance());
	}
	
	@Test
	void catchDoubleWithdrawTest() {
		Account doubleWithdraw = new Account("John Smith", 1111);
		doubleWithdraw.depositCash("20");
		doubleWithdraw.withdrawCash("10.5");
		assertEquals(20, doubleWithdraw.getBalance());
	}
	
	@Test
	void checkNumberOfSampleItemsCustomerCanBuyTest() {
		Account customerAccount = new Account("John Smith", 1111);
		customerAccount.depositCash("40");
		assertEquals(4, customerAccount.displayAffordableWashUApparel());
	}

}