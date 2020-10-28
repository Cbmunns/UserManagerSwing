package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class LastNameTests extends TestCase {

	public void testValidLastName() {
		assertTrue(UserAccount.isFirstNameValid("Smith"));
	}

}
