package test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest {
	WebDriver driver;

	
	@BeforeClass
	void setUp() throws FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", "/Users/mudassariqbal/Desktop/Deerfoot/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@Test
	void testLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String loggedUser = lp.login("loginID", "password");
		System.out.println("Logged user is: " + loggedUser);
	}

	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
