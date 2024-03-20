package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testWebShop {
	WebDriver driver;
	String mailId;
	String paswrd;
	String userFirstName;
	String userLastname;

	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	public void testOpenHomePage() {
		// opening the home page
		driver.get("http://automationpractice.com/index.php");
		// Define implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		// validate the webpage title
		AssertJUnit.assertEquals("My Store", driver.getTitle());

	}

	@Test(priority = 1)
	public void testRegisterNewUser() {
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		String partid = Double.toString(Math.random());
		// enter email address to create account
		mailId = "abc_asf" + partid + "@gmail.com";
		driver.findElement(By.id("email_create")).sendKeys(mailId);
		// click on create button
		driver.findElement(By.id("SubmitCreate")).click();

		// input first name
		userFirstName = "myFirst";
		driver.findElement(By.id("customer_firstname")).sendKeys(userFirstName);
		// input customer last name
		userLastname = "myLast";
		driver.findElement(By.id("customer_lastname")).sendKeys(userLastname);

		// input password
		paswrd = "MyPassword";
		driver.findElement(By.id("passwd")).sendKeys(paswrd);
		// input address
		driver.findElement(By.id("address1")).sendKeys("myAddress");
		// input city
		driver.findElement(By.id("city")).sendKeys("myCity");
		// select state
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("1");
		// input postal code
		driver.findElement(By.id("postcode")).sendKeys("11111");
		// input mob number
		driver.findElement(By.id("phone_mobile")).sendKeys("1111111111");
		// click on register button
		driver.findElement(By.id("submitAccount")).click();
		// get logged user info
		String loggedUser = driver.findElement(By.xpath("//a[@title='View my customer account']")).getText();

		// validate logged user
		AssertJUnit.assertEquals(loggedUser, userFirstName + " " + userLastname);

		// click on log out
		driver.findElement(By.xpath("//a[@class='logout']")).click();

	}

	@Test(priority = 2)
	public void testLoginWithExistingUser() {
		// enter already registerd email id
		driver.findElement(By.id("email")).sendKeys(mailId);
		// enter already registerd password
		driver.findElement(By.id("passwd")).sendKeys(paswrd);
		// click on sign in button
		driver.findElement(By.id("SubmitLogin")).click();
		String loggedUser = driver.findElement(By.xpath("//a[@title='View my customer account']")).getText();
		// validate logged user
		AssertJUnit.assertEquals(loggedUser, userFirstName + " " + userLastname);
	}

	@Test(priority = 3)
	public void testBuyOneProduct() {
		// click on home buton
		driver.findElement(By.xpath("//a[@title='Home']")).click();

		// mouse hover on one of pruduct image
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@class='product_img_link'])[1]"))).perform();
		// click on addto cart for a product
		driver.findElement(By.xpath("(//a[@title='Add to cart'])[1]")).click();

		// click on proceed to checkout
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath(
				"//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']"))
				.click();
		// click on address checkout
		driver.findElement(By.name("processAddress")).click();
		// select terms of service checkbox
		driver.findElement(By.name("cgv")).click();
		// click on shipping checkout
		driver.findElement(By.name("processCarrier")).click();
		// click on pay by check
		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
		// click on confirm order button
		driver.findElement(By.xpath("//button[@type='submit' and @class='button btn btn-default button-medium']"))
				.click();
		String successfulOrderMessage = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		// System.out.println("successfulOrderMessage:"+successfulOrderMessage);
		AssertJUnit.assertEquals(successfulOrderMessage, "Your order on My Store is complete.");

	}

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
