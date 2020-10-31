package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin"));
		assertTrue(UserAccount.isUserNameValid("cbmunns"));
		assertTrue(UserAccount.isUserNameValid("aDMin"));

		assertFalse(UserAccount.isUserNameValid(""));
		assertFalse(UserAccount.isUserNameValid("21ghdsak"));
		assertFalse(UserAccount.isUserNameValid("gh@# "));
		assertFalse(UserAccount.isUserNameValid("@3fdsd"));

	}

}
