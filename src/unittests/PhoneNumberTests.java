package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
	}

}
