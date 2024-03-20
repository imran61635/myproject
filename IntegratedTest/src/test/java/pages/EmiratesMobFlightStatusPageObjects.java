package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiratesMobFlightStatusPageObjects {
	
	WebDriver driver;

	// Define page constructor here*************************
	public EmiratesMobFlightStatusPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(id = "com.emirates.ek.android:id/flight_number")
	WebElement txtFlightnumber;
	
	@FindBy(id = "com.emirates.ek.android:id/flight_status_submit")
	WebElement btnFindFlights;
	
	// status page all methods here--------------------------------------
		public void setFlightNumber(String flightNo) {

			txtFlightnumber.sendKeys(flightNo);
		}
		
		public void clickOnFindFlights() {

			btnFindFlights.click();
		}

}
