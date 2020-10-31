package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House"));
		assertTrue(UserAccount.isPasswordValid("!2Ghgh"));
		assertTrue(UserAccount.isPasswordValid("Radda@1"));

		assertFalse(UserAccount.isPasswordValid(""));
		assertFalse(UserAccount.isPasswordValid("@W"));
		assertFalse(UserAccount.isPasswordValid("@White  0House"));
		assertFalse(UserAccount.isPasswordValid("@hitefdouse"));
		assertFalse(UserAccount.isPasswordValid("1234680"));




	}

}
