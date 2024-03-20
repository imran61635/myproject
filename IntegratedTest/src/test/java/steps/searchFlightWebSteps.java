package steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.emiratesWebSearchResultPageObject;
import pages.emiratesWebmainPageObject;
import runners.scenarioRunner;

public class searchFlightWebSteps {
	

	WebDriver driver;
	Properties config = scenarioRunner.config;
	String browser=config.getProperty("browser");
	int DEFAULT_WAIT_4_PAGE = 15;
	
	@Given("^Emirates site opens successfully$")
	public void emirates_site_opens_successfully() throws Throwable {
		
		System.out.println("Browser:"+browser);
		if(browser.equalsIgnoreCase("Chrome")){
			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
	    	  WebDriverManager.chromedriver().setup();
	    	  driver=new ChromeDriver();
	    	 
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		// opening the home page
		driver.get("https://www.emirates.com/ae/english/");
		// Define implicit wait
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();

	}

	@When("^user select departure and arrival destination return flight from one weak now$")
	public void user_select_departure_and_arrival_destination_return_flight_from_one_weak_now() throws Throwable {
		emiratesWebmainPageObject mainPage = new emiratesWebmainPageObject(driver);
		// Clear the default dep city
		mainPage.clickDeparureClearbutton();
		// enter the departure city name in departure airport section
		mainPage.setDepatureCity(config.getProperty("deptCity"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(3000);
		// enter the arrival city in arrival airport section
		mainPage.setArrivalCity(config.getProperty("arrCity"));
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(3000);
		// getting the current date
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd  MMM yy");
		Calendar c = Calendar.getInstance();
		// add seven days now from current date
		c.add(Calendar.DATE, 7);
		String deptDate = (String) (formattedDate.format(c.getTime()));
		// add two more days for returning date
		c.add(Calendar.DATE, 5);
		String retDate = (String) (formattedDate.format(c.getTime()));
		// enter the departure date
		mainPage.setDeptDate(deptDate);
		// click on returning date section to appear
		mainPage.clickOnRetDateSectionToApper();
		// enter the returning date
		mainPage.setRetDate(retDate);
		// click on search flight button
		mainPage.clickBtnSearchFlight();

	}

	@Then("^User should see flight listing$")
	public void user_should_see_flight_listing() throws Throwable {
		emiratesWebSearchResultPageObject searchResultPage = new emiratesWebSearchResultPageObject(driver);
		// make implicit wait zero , so that it could not mix with explicit wait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// declaring explicit wait for applying conditional wait on particular elements
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// now apply explicit wait for element to be in clickable condition
		searchResultPage.waitForLblmakeBookingAppear(wait);
		// now again apply default implicit wait
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
		// get count of OutBound flights
		String outcount = searchResultPage.getCountTextOfOutBoundflight();
		String[] Ocount = outcount.split("\\(");
		String actOutCount = Ocount[1].substring(0, 2);
		System.out.println("OutBound number of flights found: " + actOutCount);
		// get count of InBound flights
		String inCount = searchResultPage.getCountTextOfInBoundflight();
		String[] iCount = inCount.split("\\(");
		String actinCount = iCount[1].substring(0, 2);
		System.out.println("Inbound number of flights found: " + actinCount);
		
		driver.quit();

	}

}
