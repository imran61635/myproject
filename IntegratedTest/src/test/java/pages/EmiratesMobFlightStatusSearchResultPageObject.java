package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiratesMobFlightStatusSearchResultPageObject {
	
	WebDriver driver;

	// Define page constructor here*************************
	public EmiratesMobFlightStatusSearchResultPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(id = "com.emirates.ek.android:id/search_result_row_flight_no")
	WebElement lblFlightNum;
	
	@FindBy(xpath = "(//*[@resource-id='com.emirates.ek.android:id/date'])[2]")
	WebElement lblFlightdate;
	
	// search result page all methods here--------------------------------------
		public String getTextOflblFlightName() {

			return lblFlightNum.getText();
		}
		
		public String getTextOflblFlightDate() {

			return lblFlightdate.getText();
		}

}
