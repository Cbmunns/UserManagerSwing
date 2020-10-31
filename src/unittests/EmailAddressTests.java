package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class EmailAddressTests extends TestCase {

	public void testValidEmailAddress() {

		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com"));
		assertTrue(UserAccount.isEmailValid("cbmunns@rehoo.com"));
		assertTrue(UserAccount.isEmailValid("yada0@yahoo.com"));

		assertFalse(UserAccount.isEmailValid("@fghh.com.fdsdfa"));
		assertFalse(UserAccount.isEmailValid(".com@nonon"));
	}

}
