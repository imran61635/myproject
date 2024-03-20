package FileClasses;

import common.SetUp_API;
import testsAPI.CAWOFlow;
import utils.DateClass;
import utils.randomNumberGenerator;
//Create a class for each different request XML
public class CAWOReserveReqXml extends SetUp_API {
	static String woid=CAWOFlow.woid;
	static String apptStartTime=CAWOFlow.apptStartTime;
	static String apptEndTime=CAWOFlow.apptEndTime;
	static  String CLLI;
	 static String state;
	 public static String RandomNum;
	 public static String BAN=CAWOCalenderReqXml.RandomNum;
		public static String currdate;
		public static String parsedApptdate;
	
		//Here the req xml file will be updated according to the condition and environment
	public static String getUpdatedReserveReq() {
		
       if(APIConfig.getProperty("ENV").equalsIgnoreCase("TRN")) {
			CLLI="LIVNMIMN";
			state="MI";
		}
		else if(APIConfig.getProperty("ENV").equalsIgnoreCase("SWUAT")) {
			CLLI="DLLSTXRN";
			state="TX";	
		}
		else if(APIConfig.getProperty("ENV").equalsIgnoreCase("MWUAT")) {
			CLLI="CRSWMIMN";
			state="MI";	
		}
		else if(APIConfig.getProperty("ENV").equalsIgnoreCase("TRN2")) {
			CLLI="KSCYKSOL";
			state="KS";	
		}
       currdate=DateClass.getCurrentDate();
       parsedApptdate=DateClass.getSplitdate(apptStartTime);
       System.out.println("apptStartTime within reserve: "+apptStartTime);
       System.out.println("apptEndTime within reserve: "+apptEndTime);
       RandomNum=randomNumberGenerator.get9RandomNumber();
	 String reserveRequest="Avtual xml req which needs to be updated";
	 return reserveRequest;
	 
	

}
}