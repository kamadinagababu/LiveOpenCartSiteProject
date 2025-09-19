package utils;

import java.util.Date;

public class commonUtils {
	
	public  static String  generateRandomEmail()
	{
		Date date=new Date();
		return date.toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
	}

}
