package steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.EmiratesMobFlightStatusPageObjects;
import pages.EmiratesMobFlightStatusSearchResultPageObject;
import pages.EmiratesMobGuestPageObjects;
import pages.EmiratesMobHomePageObjects;
import utils.Appiumdriver;

public class searchFlightStatusMobileSteps {
	
	Properties config=Appiumdriver.config;
	AndroidDriver<MobileElement> driver;
	
	
	
	
	
	@Given("^Emirates mob app opens successfully$")
	public void emirates_mob_app_opens_successfully() throws Throwable {
	Appiumdriver.setUpDriver();
		driver=Appiumdriver.getDriver();
		EmiratesMobHomePageObjects homePage=new EmiratesMobHomePageObjects(driver);
		homePage.clicHomePageNavigationMenu();
	    System.out.println("Home page");
	    
	}

	@When("^user navigates to the flight status$")
	public void user_navigates_to_the_flight_status() throws Throwable {
		
		//click on navigation menu on home page
		
		EmiratesMobGuestPageObjects guestPage= new EmiratesMobGuestPageObjects(driver);
		//click on flight status menu
		guestPage.clicFlightstatusMenu();
	   
	}

	@When("^user enter the fligt number$")
	public void user_enter_the_fligt_number() throws Throwable {
		// enter flight number to search
		EmiratesMobFlightStatusPageObjects statuspage= new EmiratesMobFlightStatusPageObjects(driver);
		statuspage.setFlightNumber(config.getProperty("fligtNo"));
		// hide the keyboard
		driver.hideKeyboard();
		
		
	    
	}

	@When("^user click on find flights$")
	public void user_click_on_find_flights() throws Throwable {
		EmiratesMobFlightStatusPageObjects statuspage= new EmiratesMobFlightStatusPageObjects(driver);
		//click on find flights button
				statuspage.clickOnFindFlights();
	   
	}

	@Then("^User should see flight status$")
	public void user_should_see_flight_status() throws Throwable {
		EmiratesMobFlightStatusSearchResultPageObject searchResultPage= new EmiratesMobFlightStatusSearchResultPageObject(driver);
		// get flight number
		String ActflightName = searchResultPage.getTextOflblFlightName();
		String ExpFlightName= "EK"+config.getProperty("fligtNo");
		//Validate the flight name 
		Assert.assertEquals(ActflightName, ExpFlightName);
		// get flight date
		String actFlightDate=searchResultPage.getTextOflblFlightDate();
		String expFlightdate = new SimpleDateFormat("dd MMM").format(Calendar.getInstance().getTime());
		// validate the flight date
		Assert.assertEquals(actFlightDate, expFlightdate);
		
		
		
	    
	}

}
