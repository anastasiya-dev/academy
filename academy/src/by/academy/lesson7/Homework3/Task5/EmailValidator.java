package by.academy.lesson7.Homework3.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator{	
	
	@Override
	public boolean validate(String email) {		
		Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = p.matcher(email);				
		return matcher.find();
	}
}
