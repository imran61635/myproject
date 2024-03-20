package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiratesMobGuestPageObjects {
	
	WebDriver driver;

	// Define page constructor here*************************
	public EmiratesMobGuestPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(xpath = "(//*[@resource-id='com.emirates.ek.android:id/design_menu_item_text'])[3]")
	WebElement btnFlightStatusMenu;
	
	// main page all methods here--------------------------------------
		public void clicFlightstatusMenu() {

			btnFlightStatusMenu.click();
		}
	

}
