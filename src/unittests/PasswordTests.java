package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House"));
	}

}
