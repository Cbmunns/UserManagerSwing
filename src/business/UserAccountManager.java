package business;
import java.util.ArrayList;



public class
UserAccountManager {
	
	public static final String NOINPUTERROR ="";
	public static final String NONMATCHINGPASSWORDERROR = "Passwords don't match \n";
	public static final String USERNAMEEXISTSERROR = "Username exists \n";

	private String checkErrors;

    private ArrayList<UserAccount> userAccounts;
    
    public UserAccountManager() {
        userAccounts = new ArrayList<UserAccount>();
    }
        
    // You need to complete this method
    public String registerNewUser(String userName, String password, String reenteredPassword, 
    		String firstName, String lastName, String email, String phone){
    		// Check if all main fields are valid, if not add their error
    		checkErrors = UserAccount.checkInputError(userName, password, firstName, lastName, email, phone);
			// If passwords don't match add error
    		if(!reenteredPassword.equals(password))
				checkErrors += NONMATCHINGPASSWORDERROR;
    		// If username already exists add error
			if(doesUserNameExist(userName))
				checkErrors += USERNAMEEXISTSERROR;
			// If errors exist return them
    		if(!checkErrors.equals(""))
				return checkErrors;

			// Otherwise create the account and return no error
			UserAccount newAccount = new UserAccount();
			setAccountProfile(newAccount, userName, password, firstName, lastName, email, phone);
			userAccounts.add(newAccount);
			return NOINPUTERROR;

    		// check if userName, password, firstName, lastName, email, or phone is invalid 
    		// if invalid, return error message
    		// if reenteredPassword does not match password
    		// return an error message;
    		// if userName already exists
    		// return an error message;
    }

    private void setAccountProfile(UserAccount userAccount, String userName, String password, String firstName, String lastName, String email, String phone){
		userAccount.setUserName(userName);
		userAccount.setPassword(password);
		userAccount.setFirstName(firstName);
		userAccount.setLastName(lastName);
		userAccount.setEmail(email);
		userAccount.setPhoneNumber(phone);
    }
    
    // return the user account if the given userName and password are correct
    // otherwise null
    public UserAccount login(String userName, String password) {
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.isValidCredential(userName, password))    
    				return userAccount;   
    		return null;
    }
    
    public boolean doesUserNameExist(String userName){
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.matchUserName(userName))   
    				return true;   
    		return false;
    }
    
}
