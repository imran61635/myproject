package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.Setup_Page;

//This page class relates to work order detail page

public class WorkOrderdetailPage extends Setup_Page {
	
	WebDriver driver;
	
	
	//Define all locators here*************************
	@FindBy(xpath="//div[@class='work-order-label ng-binding']")
	WebElement WorOrderDetailIDDispaly;
	@FindBy(xpath="//span[@class='desktop_settings icon-placement']")
	WebElement settingIconLink;
	
	//Define  page constructor  here*************************
	public WorkOrderdetailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Define all page functions  here*************************
	public String getWoidInfoText() {
		String ACTWoidDetailText=WorOrderDetailIDDispaly.getText();
		return ACTWoidDetailText;
	}
	public void clickOnSettinklinkIcon() {
		 wait.until(ExpectedConditions.elementToBeClickable(settingIconLink));
		settingIconLink.click();
		
	}

}
