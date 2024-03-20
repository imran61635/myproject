package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class emiratesWebmainPageObject {

	WebDriver driver;

	// Define page constructor here*************************
	public emiratesWebmainPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define all locators here*************************
	@FindBy(name = "clear Departure airport")
	WebElement btnDepClear;

	@FindBy(name = "Departure airport")
	WebElement txtDeparture;

	@FindBy(name = "Arrival airport")
	WebElement txtarrival;

	@FindBy(xpath = "//span[@class='label-text--default label-text--returning']")
	WebElement btnReturningSection;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSearchFlight;

	// main page all methods here--------------------------------------
	public void clickDeparureClearbutton() {

		btnDepClear.click();
	}

	public void setDepatureCity(String strDepCity) {
		txtDeparture.sendKeys(strDepCity);
	}

	public void setArrivalCity(String strArrCity) {
		txtarrival.sendKeys(strArrCity);
	}

	public void setDeptDate(String deptDate) {
		By dep = By.xpath("//a[@aria-label='" + deptDate + "']");
		driver.findElement(dep).click();
	}

	public void clickOnRetDateSectionToApper() {
		btnReturningSection.click();

	}

	public void setRetDate(String retDate) {
		By ret = By.xpath("//a[@aria-label='" + retDate + "']");
		driver.findElement(ret).click();
	}

	public void clickBtnSearchFlight() {

		btnSearchFlight.click();
	}
}
