package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
		assertTrue(UserAccount.isPhoneNumberValid("1800259873"));
		assertTrue(UserAccount.isPhoneNumberValid("5553259682"));


		assertFalse(UserAccount.isPhoneNumberValid(""));
		assertFalse(UserAccount.isPhoneNumberValid("     "));
		assertFalse(UserAccount.isPhoneNumberValid("123"));
		assertFalse(UserAccount.isPhoneNumberValid("475893726389493762983"));





	}

}
