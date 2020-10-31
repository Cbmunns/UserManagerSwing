package acceptancetests;

//import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class LoginTests extends TestCase{

    private UserAccountManager userAccountManager;

    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();

        userAccountManager.registerNewUser("admin", "@umkcFH310",
                "@umkcFH310", "Scrum", "Master", "admin@umkc.edu",
                "9132835734");

        userAccountManager.registerNewUser("cbmunns", "!2Ghgh",
                "!2Ghgh", "chris", "Munns", "cbm@gmail.com",
                "5551234567");

        userAccountManager.registerNewUser("Can7een", "Rad4#a",
                "Rad4#a", "Kansas", "city", "kansascity@yahoo.gov",
                "5555558523");
    }
    // Both fields are left blank
    public void testBothLeftBlankFailure(){
        assertTrue(userAccountManager.login("","") == null);

        assertTrue(userAccountManager.login("","") == null);

        assertTrue(userAccountManager.login("","") == null);
    }
    // Username left blank
    public void testUserNameBlankFailure(){
        assertTrue(userAccountManager.login("","@umkcFH310") == null);

        assertTrue(userAccountManager.login("","!2Ghgh") == null);

        assertTrue(userAccountManager.login("","Rad4#a") == null);

    }
    // Username incorrect
    public void testUserNameNoMatchFailure(){
        assertTrue(userAccountManager.login("admi","@umkcFH310") == null);

        assertTrue(userAccountManager.login("cbunns","!2Ghgh") == null);

        assertTrue(userAccountManager.login("Can7en","Rad4#a") == null);

    }
    // Password left blank
    public void testPasswordBlankFailure(){
        assertTrue(userAccountManager.login("admin","") == null);

        assertTrue(userAccountManager.login("cbmunns","") == null);

        assertTrue(userAccountManager.login("Can7een","") == null);

    }
    // Password incorrect
    public void testPasswordNoMatchFailure(){
        assertTrue(userAccountManager.login("admin","@um10") == null);

        assertTrue(userAccountManager.login("cbmunns","!2gh") == null);

        assertTrue(userAccountManager.login("Can7een","Raa") == null);
    }
    // Username and Password are valid
    public void testSuccessfulLogin(){
        assertFalse(userAccountManager.login("admin","@umkcFH310") == null);

        assertFalse(userAccountManager.login("cbmunns","!2Ghgh") == null);

        assertFalse(userAccountManager.login("Can7een","Rad4#a") == null);

    }

}
