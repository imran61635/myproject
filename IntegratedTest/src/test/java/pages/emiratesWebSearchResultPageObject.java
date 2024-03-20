package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emiratesWebSearchResultPageObject {
	WebDriver driver;

	// Define page constructor here*************************
	public emiratesWebSearchResultPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(xpath = "//*[@id='ctl00_c_pH_heading1']")
	WebElement lblMakeBooking;

	@FindBy(xpath = "//h2[@id='leg-OB']")
	WebElement lblOutBoundFlightCount;
	
	@FindBy(xpath = "//h2[@id='leg-IB']")
	WebElement lblInBoundFlightCount;

	// searchResult page all methods here--------------------------------------
	public void waitForLblmakeBookingAppear(WebDriverWait wait) {

		wait.until(ExpectedConditions.elementToBeClickable(lblMakeBooking));
	}
	public String getCountTextOfOutBoundflight() {
		return lblOutBoundFlightCount.getText();
	}
	
	public String getCountTextOfInBoundflight() {
		return lblInBoundFlightCount.getText();
	}

}
