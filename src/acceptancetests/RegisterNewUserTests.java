package acceptancetests;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;


public class RegisterNewUserTests extends TestCase{

    private UserAccountManager userAccountManager;

    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser("admin", "@umkcFH310",
                "@umkcFH310", "Scrum", "Master", "admin@umkc.edu",
                "9132835734");
    }

    public void testUpToUserNameFailure(){
        // Username that starts with something other than a letter
        String registrationResult = userAccountManager.registerNewUser("2cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("2cbmunns"));
        // Username that contains something other than digits or letters
        registrationResult = userAccountManager.registerNewUser("cbm!@unns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("2cbmunns"));
        // Username that contains spaces
        registrationResult = userAccountManager.registerNewUser("cbm  unns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("2cbmunns"));
        // Username is blank
        registrationResult = userAccountManager.registerNewUser("", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("2cbmunns"));
    }

    public void testUpToPasswordFailure(){
        // Password with less than six characters
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!Gh", "!Gh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password with something other than letters, digits, or special characters
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2G  hgh", "!2G  hgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password with no capital letter
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2ghgh", "!2ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password with no lower case letter
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2GHGH", "!2GHGH", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password with no digit
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!!Ghgh", "!!Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password with no special character
        registrationResult = userAccountManager.registerNewUser("cbmunns", "22Ghgh", "22Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Password blank
        registrationResult = userAccountManager.registerNewUser("cbmunns", "", "", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));

    }

    public void testUpToReEnterPasswordFailure(){
        // Re enter left blank
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Re enter incorrect
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "5gfd5", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));

    }

    public void testUpToFirstNameFailure(){
        // First name contains something other than letters
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "!2chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // First name left blank
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "", "MuNns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
    }

    public void testUpToLastNameFailure(){
        // Last name contains something other than letters
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuN 45ns", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Last name blank
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "", "cbm@gmail.com", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
    }

    public void testUpToEmailFailure(){
        // Email not standard format
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", ".cru@fds2", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Email left blank
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "", "5551234567");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));

    }

    public void testUpToPhoneFailure(){
        // Phone number contains something other than digits
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "jgdr345678");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Phone number contains more than 10 digits
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5556284223345678");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Phone number contains less than 10 digits
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "345678");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));
        // Phone number left blank
        registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("cbmunns"));

    }

    public void testUserNameExistsFailure(){
        // Create valid user
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertTrue(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertTrue(userAccountManager.doesUserNameExist("cbmunns"));
        // Reusing username with different values
        String registrationResultTwo = userAccountManager.registerNewUser("cbmunns", "&6Jhjh", "&6Jhjh", "Roger", "smith", "rgs@gmail.com", "7654321555");
        assertFalse(registrationResultTwo.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertTrue(userAccountManager.doesUserNameExist("cbmunns"));
        // Username with capital letters
        registrationResultTwo = userAccountManager.registerNewUser("cBmunNs", "&6Jhjh", "&6Jhjh", "Roger", "smith", "rgs@gmail.com", "7654321555");
        assertFalse(registrationResultTwo.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertTrue(userAccountManager.doesUserNameExist("cbmunns"));
    }

    public void testSuccessfulRegistration(){
        String registrationResult = userAccountManager.registerNewUser("cbmunns", "!2Ghgh", "!2Ghgh", "chris", "MuNns", "cbm@gmail.com", "5551234567");
        assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
        UserAccount userAccount = userAccountManager.login("cbmunns", "!2Ghgh");
        assertNotNull(userAccount);
        assertTrue(userAccount.getUserName().equalsIgnoreCase("cbmunns"));
        assertTrue(userAccount.getEmail().equalsIgnoreCase("cbm@gmail.com"));
    }


}
