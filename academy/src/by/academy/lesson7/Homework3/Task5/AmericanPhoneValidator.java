package by.academy.lesson7.Homework3.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {

	@Override
	public boolean validate(String phoneNumber) {
		Pattern p = Pattern.compile("^\\+1[0-9]{10}$");
		Matcher matcher = p.matcher(phoneNumber);	
		return matcher.find();
	}
}
