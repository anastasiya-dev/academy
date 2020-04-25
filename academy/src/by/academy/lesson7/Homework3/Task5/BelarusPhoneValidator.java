package by.academy.lesson7.Homework3.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {

	@Override
	public boolean validate(String phoneNumber) {		
		Pattern p = Pattern.compile("^\\+375((1[345678])|(2[01234])|"
				+ "((25)|(29)|(33)|(44)))[0-9]{7}$");
		Matcher matcher = p.matcher(phoneNumber);				
		return matcher.find();		
	}
}
