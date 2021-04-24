package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bank.Menu;

import java.util.List;

class MenuTest {
	
	@Test
	void checkCorrectNumberOfMenuOptionsAfterDisplayCustomerMenu() {
		Menu bankMenu = new Menu();
		bankMenu.displayCustomerMenu();
		assertEquals(3, bankMenu.getHighestAcceptableInput());
	}
	
	@Test
	void checkCorrectNumberOfMenuOptionsAfterDisplayEmployeeMenu() {
		Menu bankMenu = new Menu();
		bankMenu.displayEmployeeMenu();
		assertEquals(3, bankMenu.getHighestAcceptableInput());
	}
}
