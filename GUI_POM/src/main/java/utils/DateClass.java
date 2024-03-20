package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateClass {
	
	//this method is responsible to return current date in yyyy-mm-dd format
	public static String  getCurrentDate() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		System.out.println("Current Date: "+timeStamp);
		return timeStamp;
		}
	
	//This method returns splitted date ie if date is 2019-02-05T00:53:08.163Z format then it will return only 2019-02-05
	public static String getSplitdate(String date) {
		String splitted=date.substring(0, 10);
		System.out.println("Splitted: "+splitted);
		return splitted;
		
	}
	
	//this is test method only for checking the functionality not related with framework
	public static void main(String[] args) {
		
	getCurrentDate();
	getSplitdate("2019-02-22T08:00:00");
		
	}

}
