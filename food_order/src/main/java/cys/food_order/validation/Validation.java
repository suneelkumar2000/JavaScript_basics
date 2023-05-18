package cys.food_order.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean nameValidation(String name) {
		Pattern p = Pattern.compile("[a-zA-Z ]+");
		Matcher m = p.matcher(name);
		boolean b = m.matches();
		if (b && name != null) {
			return true;
		} else
			return false;
	}
	
	public boolean usernameValidation(String name) {
		Pattern p = Pattern.compile("^[A-Za-z]\\w{4,14}$");
		Matcher m = p.matcher(name);
		boolean b = m.matches();
		if (b && name != null) {
			return true;
		} else
			return false;
	}
	
	public boolean passwordValidation(String name) {
		if (name != null) {
			return true;
		} else
			return false;
	}
	public boolean emailValidation(String email) {
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		if (b && email != null) {
			return true;
		} else
			return false;
	}
	public boolean numberValidation(int num) {
		if (num > 0&& (String.valueOf(num) != null)) {
			return true;
		} else
			return false;
	}
	public boolean phoneValidation(long phone) {
		if (phone > 0 && (String.valueOf(phone) != null)) {
			return true;
		} else
			return false;
	}
}
