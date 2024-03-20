package testsAPI;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import FileClasses.CAWOCalenderReqXml;
import FileClasses.CAWOCreateReqXml;
import FileClasses.CAWOReserveReqXml;
import common.SetUp_API;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utils.DButilities;
import utils.DateClass;
import utils.WOIDstoreInProperty;


//This is a test class for CAWO calender, reserve and create
public class CAWOFlow extends SetUp_API {
	public static String woid;
	public static String apptStartTime;
	public static String apptEndTime;
	public XmlPath xpath;
	public HashMap<String, String> hmap;  // used hashmap to store key value pair to get value based on column names
	public static String currdate;
	
  // Priority 0 will execute first and so on
	@Test(priority = 0)
	public void calender() throws FileNotFoundException, IOException {
		
		// storing WOID as null when the calender method starts executing
		WOIDstoreInProperty.setWOIDinProperty("null");

		String calenderReq = CAWOCalenderReqXml.getUpdatedCalenderReq();

		Response response = given()
				.log().all()
				.header("Content-Type", "text/xml").and().body(calenderReq)
				.post(APIConfig.getProperty("APIURL")).then()
				.log().all()
				.statusCode(200).and()

				.extract().response();
		xpath = new XmlPath(response.asString());// Converting string into xml path
		woid = xpath.getString("Envelope.Body.CreateAmendWorkOrderResponse.WorkOrder.workOrderId");
		apptStartTime = xpath.getString("Envelope.Body.CreateAmendWorkOrderResponse.Appointments.Appointment[0].start");
		apptEndTime = xpath.getString("Envelope.Body.CreateAmendWorkOrderResponse.Appointments.Appointment[0].end");
		
		
		System.out.println("WOID from calender: " + woid);
		System.out.println("apptStartTime recieved: " + apptStartTime);
		System.out.println("apptEndTime recieved: " + apptEndTime);

	}
  // if calender method fails , the other method like reserve will be skipped
	@Test(dependsOnMethods={"calender"},priority=1)
	public void reserve() {
		String reserveReq = CAWOReserveReqXml.getUpdatedReserveReq();

		Response response = given()
				.log().all()
				.header("Content-Type", "text/xml").and().body(reserveReq)
				.post(APIConfig.getProperty("APIURL")).then()
				.log().all()
				.statusCode(200).and()

				.extract().response();
		xpath = new XmlPath(response.asString());// Converting string into xml path
		woid = xpath.getString("Envelope.Body.CreateAmendWorkOrderResponse.WorkOrder.workOrderId");

		System.out.println("WOID from reserve: " + woid);

	}

	@Test(dependsOnMethods={"calender"},priority=2)
	public void create() {
		currdate = DateClass.getCurrentDate();
		String createReq = CAWOCreateReqXml.getUpdatedCreateReq();
		Response response = given()
				.log().all()
				.header("Content-Type", "text/xml").and()

				.body(createReq).when().post(APIConfig.getProperty("APIURL")).then()
				.log().all()
						.statusCode(200).and()

				.extract().response();

		xpath = new XmlPath(response.asString());// Converting string into xml path
		woid = xpath.getString("Envelope.Body.CreateAmendWorkOrderResponse.WorkOrder.workOrderId");
		System.out.println("WOiD from create: " + woid);
		
		System.out.println("validating DB values");
		String SQLquery1 = "select WRID,SOURCETYPE,EXTKEY1,WRSTAT FROM xbfwr_t where EXTKEY2='" + woid + "'";
		String SQLquery2 = "select status from WORK_ORDER_PRODUCT_GROUPS where work_order_id = '" + woid + "'";
		String SQLquery3 = "select WORK_ORDER_ID,JOB_CATEGORY, ORDER_SUBTYPE,CLLI, DESTINATION_SYSTEM, STATUS,\r\n"
				+ "JOB_TYPE,ZIP, DWELLING_TYPE,PRODUCT_GROUP_LIST, SOURCE_TYPE, TROUBLE_DESCRIPTION,\r\n"
				+ "TRANSPORT_TYPE, BILLING_NAME,LOCAL_ACCESS_START_DTTM,LOCAL_ACCESS_END_DTTM from edge.work_order where work_order_id = '"
				+ woid + "'";

		String SQLquery4 = "select FUNCTION,STATUS_FROM_CREATE from edge.work_order_request where  event_ts in (select max(EVENT_TS) from edge.work_order_request where \r\n"
				+ "WORK_ORDER_ID='" + woid + "') and WORK_ORDER_ID='" + woid + "'";

		// KEY OR COLUMN NAME IS CASE SENSITIVE SO PROVIDE CORRECT KEY IN GETTING VALUES FROM MAP
		// Starting DB validation
		hmap = DButilities.getAllColumns(SQLquery1);
		Assert.assertTrue(hmap.get("WRSTAT").equalsIgnoreCase("ASSIST")||hmap.get("WRSTAT").equalsIgnoreCase("PENDING"));

		hmap = DButilities.getAllColumns(SQLquery2);
		Assert.assertTrue(hmap.get("STATUS").equalsIgnoreCase("Ready to Close"));

		hmap = DButilities.getAllColumns(SQLquery3);
		Assert.assertTrue(hmap.get("JOB_CATEGORY").equalsIgnoreCase("I"));
		 
		Assert.assertTrue(hmap.get("STATUS").equalsIgnoreCase("ASSIST"));
		Assert.assertTrue(hmap.get("DWELLING_TYPE").equalsIgnoreCase("Residential"));
		
		Assert.assertTrue(hmap.get("LOCAL_ACCESS_START_DTTM").contains(currdate));
		//	sassert.assertAll();
		hmap = DButilities.getAllColumns(SQLquery4);
	
		Assert.assertTrue(hmap.get("FUNCTION").equalsIgnoreCase("build"));
		Assert.assertTrue(hmap.get("STATUS_FROM_CREATE").equalsIgnoreCase("ASSIST")
				|| hmap.get("STATUS_FROM_CREATE").equalsIgnoreCase("PENDING"));
		
	
		// Storing the WOID in property file if it is created successfully otherwise null will be stored
		WOIDstoreInProperty.setWOIDinProperty(woid);
	}

}
