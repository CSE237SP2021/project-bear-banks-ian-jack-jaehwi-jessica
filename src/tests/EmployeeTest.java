package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.Employee;

class EmployeeTest {

	@Test
	void CheckLockedATM() {
		Employee checkEmployee = new Employee();
		assertTrue(checkEmployee.attemptToLockATM("10"));
	}
	
	@Test
	void CheckNotLockedATM() {
		Employee checkEmployee = new Employee();
		assertFalse(checkEmployee.attemptToLockATM("asdf"));
		
	}

}
