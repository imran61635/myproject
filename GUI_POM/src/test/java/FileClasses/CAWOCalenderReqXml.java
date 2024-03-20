package FileClasses;

import common.SetUp_API;
import utils.DateClass;
import utils.randomNumberGenerator;

//Create a class for each different request XML
public class CAWOCalenderReqXml extends SetUp_API {
	public static String CLLI;
	public static String state;
	public static String RandomNum;
	public static String transportType;
	public static String orderActionType;
	public static String currdate;
	public static String parsedApptdate;
	
	//Here the req xml file will be updated according to the condition and environment
	public static String getUpdatedCalenderReq() {
		orderActionType=APIConfig.getProperty("orderActionType");
		transportType=APIConfig.getProperty("transportType");
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
       RandomNum=randomNumberGenerator.get9RandomNumber();
       currdate=DateClass.getCurrentDate();
	 String calenderRequest="Actual Reqest xml which need to be updated";
	 return calenderRequest;

}
}