package business;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccount {
	
	private String userName;
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public UserAccount() {	
	}
	
	public static String checkInputError(String userName, String password, String firstName, String lastName, String email, String phone){
		String errorMessage ="";
		if (!isUserNameValid(userName))
				errorMessage += "Invalid user name.\n";
		if (!isPasswordValid(password))
				errorMessage += "Invalid password.\n";	
		if (!isFirstNameValid(firstName))
			errorMessage += "Invalid first name.\n";
		if (!isLastNameValid(lastName))
			errorMessage += "Invalid last name.\n";
		if (!isEmailValid(email))
			errorMessage += "Invalid email.\n";
		if (!isPhoneNumberValid(phone))
			errorMessage += "Invalid phone number.\n";
		return errorMessage;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	// you need to complete this method
	public static boolean isUserNameValid(String userName){

		if(userName.equals(""))
			return false;

		if(!Character.isLetter(userName.charAt(0)))
			return false;

		for (int i=0; i < userName.length(); i++ ){
			if (!Character.isLetter(userName.charAt(i)) && !Character.isDigit(userName.charAt(i)))
				return false;
		}

		// check if userName is valid	 
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	// you need to complete this method
	public static boolean isPasswordValid(String password){
		boolean upper = false;
		boolean lower = false;
		boolean digit = false;
		boolean special = false;

		if(password.equals(""))
			return false;

		if(password.length() < 6)
			return false;

		for (int i=0; i < password.length(); i++ ){
			if (password.charAt(i) == ' ')
				return false;
			if (Character.isLetter(password.charAt(i)))
				if(Character.isUpperCase(password.charAt(i)))
					upper = true;
				else
					lower = true;
			else if (Character.isDigit(password.charAt(i)))
				digit = true;
			else
				special = true;
		}

		if(!upper || !lower || !digit || !special)
			return false;


		// check if password is valid
		return true;
	}

    public boolean isValidCredential(String userName, String password) {
         return matchUserName(userName) && matchPassword(password);
    }
    
    public boolean matchUserName(String userName) {
         return userName != null && userName.equalsIgnoreCase(this.userName);
    }
    
    private boolean matchPassword(String password) {
        return password != null && password.equals(this.password);
   }

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	// you need to complete this method
	public static boolean isFirstNameValid(String firstName){

		if(firstName.equals(""))
			return false;

		for (int i=0; i < firstName.length(); i++ ){
			if(firstName.charAt(i) == ' ')
				return false;
			if (!Character.isLetter(firstName.charAt(i)))
				return false;
		}
		// check if firstName is valid
		return true;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}


	// you need to complete this method
	public static boolean isLastNameValid(String lastName){
		if(lastName.equals(""))
			return false;
		if (lastName.charAt(0) == ' ')
			return false;
		for (int i=0; i < lastName.length(); i++ ){
			if(lastName.charAt(i) == ' ')
				return false;
			if (!Character.isLetter(lastName.charAt(i)))
				return false;
		}



		// check if lastName is valid
		return true;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public static boolean isValidEmail(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	// you need to complete this method
	public static boolean isEmailValid(String email){
		if(email.equals(""))
			return false;

		if(!isValidEmail(email))
			return false;

		// check if email is valid
		return true;
	}

	public String getPhoneNumber(){
		return phone;
	}

	public void setPhoneNumber(String phone){
		this.phone = phone;
	}

	// you need to complete this method
	public static boolean isPhoneNumberValid(String phone) {



		if (phone.equals(""))
			return false;

		if (phone.length() != 10)
			return false;

		for (int i=0; i < phone.length(); i++ ){
			if (!Character.isDigit(phone.charAt(i)))
				return false;
		}


		// check if phone (number) is valid
		return true;
	}


}
