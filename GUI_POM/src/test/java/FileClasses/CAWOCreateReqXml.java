package FileClasses;

import common.SetUp_API;
import testsAPI.CAWOFlow;
import utils.randomNumberGenerator;
//Create a class for each different request XML
public class CAWOCreateReqXml extends SetUp_API {
	static String woid=CAWOFlow.woid;
	static String apptStartTime=CAWOFlow.apptStartTime;
	static String apptEndTime=CAWOFlow.apptEndTime;
	static  String CLLI;
	 static String state;
	 static String RandomNum;
	// static String createRequest;
	static String ntiSubTypeValue;
	 public static String BAN=CAWOCalenderReqXml.RandomNum;
	//Here the req xml file will be updated according to the condition and environment 
	public static String getUpdatedCreateReq() {
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
      if(APIConfig.getProperty("transportType").equalsIgnoreCase("FTTN-BP") || APIConfig.getProperty("transportType").equalsIgnoreCase("FTTNBP")){
    	
    	  
    	  ntiSubTypeValue="<value>BP</value>";
      }
      else {
    	  ntiSubTypeValue="<value/>";
      }
       RandomNum=randomNumberGenerator.get9RandomNumber();
     
       System.out.println("apptStartTime within create: "+apptStartTime);
       System.out.println("apptEndTime within create: "+apptEndTime);
	
	String  createRequest= "Actual req xml which need to be updated";
	 return createRequest;

}
}