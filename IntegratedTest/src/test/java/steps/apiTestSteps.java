package steps;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import com.fasterxml.jackson.databind.ObjectMapper;
import APIPOJOClasses.Example;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class apiTestSteps {
	String ApiURL;

	@Given("^The API Endpoint$")
	public void the_API_Endpoint() throws Throwable {
		ApiURL = "https://itunes.apple.com/search?term=jack+johnson&entity=musicVideo";

	}

	@When("^user use the Get method of API$")
	public void user_use_the_Get_method_of_API() throws Throwable {
		// validate the schema of json
		get(ApiURL).then().assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("schema.json"));

	}

	@Then("^User should validate the schema and response$")
	public void user_should_validate_the_schema_and_response() throws Throwable {
		// Validate the response in detail
		Response response = given().get(ApiURL).then().statusCode(200).and()

				.extract().response();

		response.prettyPrint();

		ObjectMapper mapper = new ObjectMapper();
		Example usrResponse = mapper.readValue(response.asString(), Example.class);
		System.out.println("ResultCount: " + usrResponse.getResultCount());
		System.out.println("ArtistName1: " + usrResponse.getResults().get(0).getArtistName());
		System.out.println("TrackID1: " + usrResponse.getResults().get(0).getTrackId());
		System.out.println("TrackName1: " + usrResponse.getResults().get(0).getTrackName());
		System.out.println("ArtistName2: " + usrResponse.getResults().get(1).getArtistName());
		System.out.println("TrackID2: " + usrResponse.getResults().get(1).getTrackId());
		System.out.println("TrackName2: " + usrResponse.getResults().get(1).getTrackName());

		// Verify the status code to be 200
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode == 200);
		
		// verify the content type
		String contentType = response.contentType();
		Assert.assertTrue(contentType.equalsIgnoreCase("text/javascript; charset=utf-8"));
		
		// Verify the number actual of counts of records with result count value
		int actualRecordCount = usrResponse.getResultCount();
		int expectedrecordCount = usrResponse.getResults().size();
		Assert.assertEquals(actualRecordCount, expectedrecordCount);
		
		// verify the every value of artis id not null
		for (int i = 0; i < usrResponse.getResults().size(); i++) {
			Assert.assertFalse(usrResponse.getResults().get(i).getArtistId() == null);

		}
		
		// verify the every value of track id not null
		for (int i = 0; i < usrResponse.getResults().size(); i++) {
			Assert.assertFalse(usrResponse.getResults().get(i).getTrackId() == null);

		}

	}

}
