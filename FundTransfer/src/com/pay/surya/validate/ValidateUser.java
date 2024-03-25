package com.pay.surya.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pay.surya.bean.User;

public class ValidateUser 
{

	private static Matcher matcher;
	private static Pattern pattern;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	public static boolean checkLength(int length,String text,boolean engthEquals)
	{
		if(engthEquals)
		{
			if(text.length()==length && text!=null)
			{
				return true;
			}
			else
			{
				return false;
				
			}
		}
		else
		{
			if(text.length()>length && text!=null)
			{
				return true;
			}
			else
			{
				return false;
				
			}
		}
		 
		
	}
	
	
	public static boolean validateEmail(String email)
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
	public static boolean verifyPin(int pin,User user)
	{
		if(pin==user.getAccountPin())
			return true;
		else
			return false;
		
	}
	
	
	
	
	
}
