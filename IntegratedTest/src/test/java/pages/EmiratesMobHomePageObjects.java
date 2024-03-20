package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiratesMobHomePageObjects {
	
	WebDriver driver;

	// Define page constructor here*************************
	public EmiratesMobHomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(id = "global_navigation_menu_button")
	WebElement btnNavigationMenu;
	
	// home page all methods here--------------------------------------
		public void clicHomePageNavigationMenu() {

			btnNavigationMenu.click();
		}
	
	

}
