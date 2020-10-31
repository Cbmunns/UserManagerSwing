package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class LastNameTests extends TestCase {

	public void testValidLastName() {
		assertTrue(UserAccount.isFirstNameValid("Smith"));
		assertTrue(UserAccount.isLastNameValid("Munns"));
		assertTrue(UserAccount.isLastNameValid("Obama"));
		assertTrue(UserAccount.isLastNameValid("brockington"));

		assertFalse(UserAccount.isLastNameValid(""));
		assertFalse(UserAccount.isLastNameValid("    "));
		assertFalse(UserAccount.isLastNameValid("12@3dfs"));
		assertFalse(UserAccount.isLastNameValid("smith54*7"));
	}

}
