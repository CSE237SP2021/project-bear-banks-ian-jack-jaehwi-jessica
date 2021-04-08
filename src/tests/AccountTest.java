package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.Account;

class AccountTest {

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
	void catchNegativeDepositTest() {
		Account negativeDeposit = new Account("John Smith", 1111);
		negativeDeposit.depositCash(-10);
		assertNotEquals(-10, negativeDeposit.getBalance());
	}
	
	@Test
	void catchPositiveDepositTest() {
		Account positiveDeposit = new Account("John Smith", 1111);
		positiveDeposit.depositCash(10);
		assertEquals(10, positiveDeposit.getBalance());
	}
	
	@Test
	void catchNegativeWithdrawTest() {
		Account negativeWithdraw = new Account("John Smith", 1111);
		negativeWithdraw.depositCash(20);
		negativeWithdraw.withdrawCash(-10);
		assertNotEquals(30, negativeWithdraw.getBalance());
	}
	
	@Test
	void catchExcessiveWithdrawTest() {
		Account excessiveWithdraw = new Account("John Smith", 1111);
		excessiveWithdraw.depositCash(20);
		excessiveWithdraw.withdrawCash(30);
		assertNotEquals(-10, excessiveWithdraw.getBalance());
	}
	
	@Test
	void catchCorrectWithdrawTest() {
		Account correctWithdraw = new Account("John Smith", 1111);
		correctWithdraw.depositCash(20);
		correctWithdraw.withdrawCash(10);
		assertEquals(10, correctWithdraw.getBalance());
	}
}