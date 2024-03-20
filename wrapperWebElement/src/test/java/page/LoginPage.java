package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		MyPageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Login & Signup']")
	private WebElement lnkLogin;

	@FindBy(xpath = "//input[@type='text' and @class='_2zrpKA _1dBPDZ']")
	private WebElement txtID;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPwd;

	@FindBy(xpath = "//button[@type='submit' and @class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//div[text()='m']")
	private WebElement lnkLoggedUser;

	void clickLoginLink() {

		lnkLogin.click();
	}

	public String login(String id, String pwd) {

		txtID.sendKeys(id);
		txtPwd.sendKeys(pwd);
		btnSubmit.click();
		return lnkLoggedUser.getText();

	}
}
