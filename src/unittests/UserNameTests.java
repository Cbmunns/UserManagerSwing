package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin"));
	}

}
