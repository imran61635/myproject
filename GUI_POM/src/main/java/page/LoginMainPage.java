package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This class relates to Dispatch main page where all functions and locators must be defined here
public class LoginMainPage {
	WebDriver driver;
	
	//Define all locators here*************************
	@FindBy(name="userid")
	WebElement UID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnSubmit")
	WebElement loginBtn;
	
	@FindBy(name="successOK")
	WebElement OKBtn;
	
	@FindBy(xpath="//input[@placeholder='one or multiple comma separated with % and _ as wildcards']")
	WebElement SearchWRIDTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement SearchButtonForWRID;
	
	@FindBy(xpath="//div[@class='ui-grid-cell-contents ng-scope']")
	WebElement DisplayedWRIDLink;
	
	//Define  page constructor  here*************************
	public LoginMainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Dispath main page all methods here--------------------------------------
	public String loginToPage(String userid, String password ) {
		
		UID.sendKeys(userid);
		Password.sendKeys(password);
		loginBtn.click();
		OKBtn.click();
		String pageTitle=driver.getTitle();
		return pageTitle;
		
	}
   
	public String searchWRID(String WRID) {
		SearchWRIDTextBox.sendKeys(WRID);
		SearchButtonForWRID.click();
		String wridactual=DisplayedWRIDLink.getText();
		return wridactual;
	}
	
	public void clickWridLink() {
		DisplayedWRIDLink.click();
		
	}
}
