package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bank.Menu;

import java.util.List;

class MenuTest {

	@Test
	void GoodSimulatedUserInputTest() {
		List<Integer> correctOptions = new ArrayList<Integer>();
		correctOptions.add(1);
		int userInput = 1;
		assertTrue(correctOptions.contains(userInput));
	}
	
	@Test
	void BadIntSimulatedUserInputTest() {
		List<Integer> correctOptions = new ArrayList<Integer>();
		correctOptions.add(1);
		int userInput = 10;
		assertFalse(correctOptions.contains(userInput));
	}

	@Test
	void StringSimulatedUserInputTest() {
		List<Integer> correctOptions = new ArrayList<Integer>();
		correctOptions.add(1);
		String userInput = "notAnInt";
		assertFalse(correctOptions.contains(userInput));
	}
}
