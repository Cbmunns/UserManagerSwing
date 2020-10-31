package acceptancetests;


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
        assertNull(userAccountManager.login("", ""));

        assertNull(userAccountManager.login("", ""));

        assertNull(userAccountManager.login("", ""));
    }
    // Username left blank
    public void testUserNameBlankFailure(){
        assertNull(userAccountManager.login("","@umkcFH310"));

        assertNull(userAccountManager.login("","!2Ghgh"));

        assertNull(userAccountManager.login("","Rad4#a"));

    }
    // Username incorrect
    public void testUserNameNoMatchFailure(){
        assertNull(userAccountManager.login("admi","@umkcFH310"));

        assertNull(userAccountManager.login("cbunns","!2Ghgh"));

        assertNull(userAccountManager.login("Can7en","Rad4#a"));

    }
    // Password left blank
    public void testPasswordBlankFailure(){
        assertNull(userAccountManager.login("admin",""));

        assertNull(userAccountManager.login("cbmunns",""));

        assertNull(userAccountManager.login("Can7een",""));

    }
    // Password incorrect
    public void testPasswordNoMatchFailure(){
        assertNull(userAccountManager.login("admin","@um10"));

        assertNull(userAccountManager.login("cbmunns","!2gh"));

        assertNull(userAccountManager.login("Can7een","Raa"));
    }
    // Username and Password are valid
    public void testSuccessfulLogin(){
        assertNotNull(userAccountManager.login("admin", "@umkcFH310"));

        assertNotNull(userAccountManager.login("cbmunns", "!2Ghgh"));

        assertNotNull(userAccountManager.login("Can7een", "Rad4#a"));

    }

}
