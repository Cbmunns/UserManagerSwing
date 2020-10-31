package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class FirstNameTests extends TestCase {

	public void testValidFirstName() {
		assertTrue(UserAccount.isLastNameValid("john"));
		assertTrue(UserAccount.isLastNameValid("chris"));
		assertTrue(UserAccount.isLastNameValid("phil"));

		assertFalse(UserAccount.isLastNameValid(""));
		assertFalse(UserAccount.isLastNameValid("    "));
		assertFalse(UserAccount.isLastNameValid("12@3dfs"));
		assertFalse(UserAccount.isLastNameValid("john54*7"));



	}

}
