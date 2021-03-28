package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.Account;

class AccountTest {

	@Test
	void catchLargePinNumberTest() {
		Account tooBigPinNumber = new Account("John Smith", 12345);
		assertFalse(tooBigPinNumber.checkPinValidity(tooBigPinNumber.getPinNumber()));
	}
	
	@Test
	void catchNegativePinNumberTest() {
		Account negativePinNumber = new Account("John Smith", -123);
		assertFalse(negativePinNumber.checkPinValidity(negativePinNumber.getPinNumber()));
	}
}
