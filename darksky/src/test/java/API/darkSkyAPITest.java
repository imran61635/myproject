package API;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class darkSkyAPITest {
	  String APIUrl="https://api.darksky.net/forecast/cbb6662f2266b4440e74e3d5670fa5a3/37.8267,-122.4233";

	
  @Test
  public void validateTypeOfValuesOfKey() throws ParseException {
	  
	  Response res=get(APIUrl);
	  int statusCode=res.getStatusCode();
	  Assert.assertTrue(statusCode==200);
	  String contentType=res.contentType();
	  Assert.assertTrue(contentType.equalsIgnoreCase("application/json; charset=utf-8"));
	  String resData=res.asString();
	  
	  System.out.println("Response: "+resData);
	  JSONObject job= (JSONObject) new JSONParser().parse(resData);
	  Object aObj = job.get("latitude");
	  String type=checkTypeOfValues(aObj);
	  Assert.assertTrue(type.equalsIgnoreCase("float"));
	  System.out.println("Type of value of latitude key is: "+type);
	  
	  aObj = job.get("timezone");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("string"));
	  System.out.println("Type of value of timezone key is: "+type);
	  aObj = job.get("longitude");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("float"));
	  System.out.println("Type of value of longitude key is: "+type);
	  aObj = job.get("currently");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("object"));
	  System.out.println("Type of value of currently key is: "+type);
	  aObj = job.get("minutely");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("object"));
	  System.out.println("Type of value of minutely key is: "+type);
	  aObj = job.get("hourly");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("object"));
	  System.out.println("Type of value of hourly key is: "+type);
	  aObj = job.get("daily");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("object"));
	  System.out.println("Type of value of daily key is: "+type);
	  aObj = job.get("flags");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("object"));
	  System.out.println("Type of value of flags key is: "+type);
	   aObj = job.get("offset");
	   type=checkTypeOfValues(aObj);
	   Assert.assertTrue(type.equalsIgnoreCase("int"));
	  System.out.println("Type of value of offset key is: "+type);
	  
	  
	  
  }
  @Test
public void validateCorrectNumberOfItems() throws ParseException {
	 given().log().all().when().
	 get(APIUrl).
	 then().log().all().
	 assertThat().
	 statusCode(200).
	 body("minutely.data",hasSize(61)).
	 and().
	 body("hourly.data",hasSize(49)).
	 and().
	 body("daily.data",hasSize(8));
	  
  }
  public String checkTypeOfValues(Object obj) {
		
		if(obj instanceof Long){
		      return "int";
		  }else if(obj instanceof Float){
		      return "float";}
		  else if(obj instanceof Double){
		      return "float";
		  }else if(obj instanceof String){
		      return "string"; }
		  else if(obj instanceof Object){
		      return "object"; }
		  else return "NA";
		
	}
}
