package steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runners.scenarioRunner;

public class checkEmiratesLowPriceSteps{
	WebDriver driver=scenarioRunner.driver;
	Properties config=scenarioRunner.config;
	int DEFAULT_WAIT_4_PAGE=15;
	@Given("^that Bill has decided to check available flights$")
	public void that_Bill_has_decided_to_check_available_flights() throws Throwable {
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//User navigates to emirates website to check cheapest return flight
		  driver.get("https://www.emirates.com/ae/english/");
		 
	}

	@When("^he looks at a return trip from DXB to LHR leaving one week from now$")
	public void he_looks_at_a_return_trip_from_DXB_to_LHR_leaving_one_week_from_now() throws Throwable {
		//to enter the departure airport, first need to close the default city
		driver.findElement(By.name("clear Departure airport")).click();
		//enter the departure city name in departure airport section 
		driver.findElement(By.name("Departure airport")).sendKeys(config.getProperty("deptCity"));
		//enter the arrival city in arrival airport section
		driver.findElement(By.name("Arrival airport")).sendKeys(config.getProperty("arrCity"));
		// click on continue button
		driver.findElement(By.linkText("Continue")).click();
		//click on departing date section to appear if not by default
		driver.findElement(By.xpath("//label[@class='textfield__label']")).click();
		//getting the current date
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd  MMM yy");            
  		Calendar c = Calendar.getInstance();
  		//add seven days now from current date
  		c.add(Calendar.DATE, 7);
  		String deptDate = (String)(formattedDate.format(c.getTime()));
  		//add two more days for returning date
  		c.add(Calendar.DATE, 2);
  		String retDate = (String)(formattedDate.format(c.getTime()));
  		//enter the departure date 
  		driver.findElement(By.xpath("//a[@aria-label='"+deptDate+"']")).click();
  		//click on returning date section to appear
  		driver.findElement(By.xpath("//span[@class='label-text--default label-text--returning']")).click();
  		//enter the returning date
  		driver.findElement(By.xpath("//a[@aria-label='"+retDate+"']")).click();
  		//click on search flight button
  		driver.findElement(By.xpath("//button[@type='submit']")).click();
  		
	}

	@Then("^he should be shown the cheapest return ticket from DXB to LHR$")
	public void he_should_be_shown_the_cheapest_return_ticket_from_DXB_to_LHR() throws Throwable {
		//declaring explicit wait for applying conditional wait on particular elements
  		WebDriverWait wait=new WebDriverWait(driver, 30);
  		//find the element which has text as Make a booking on search result page
  		WebElement Element=driver.findElement(By.xpath("//*[@id='ctl00_c_pH_heading1']"));
  		//make implicit wait zero , so that it could not mix with explicit wait
  		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
  		//now apply explicit wait for element to be in clickable condition
  		wait.until(ExpectedConditions.elementToBeClickable(Element));
  		//now again apply default implicit wait
  		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
  		//identifying the webelement for low price appear or not by looking its size
  		List lowPrice=driver.findElements(By.id("ctl00_c_ctlLowPrice_dvLowestPriceDisplay"));
  		if(lowPrice.size()==0){
  			//as low price doesn't appear then click on change search button
  			driver.findElement(By.id("modifySearchButton")).click(); 
  			//getting the new modified dates
  			SimpleDateFormat formattedDate = new SimpleDateFormat("dd MMM yy");            
  	  		Calendar c = Calendar.getInstance();
  	  	    c.add(Calendar.DATE, 9);
  		    String deptDate = (String)(formattedDate.format(c.getTime()));
  		    c.add(Calendar.DATE, 2);
    		String retDate = (String)(formattedDate.format(c.getTime()));
  			//identify the weblement of departure date
  			Element= driver.findElement(By.id("txtDepartDate"));
  			//changing the value attribute of date by java script coz this is not possible by selenium
  			JavascriptExecutor js=(JavascriptExecutor)driver;
  			//updating departure date by java script
  			js.executeScript("document.getElementById('txtDepartDate').value='"+deptDate+"'");
  		    //updating return date by java script
  			js.executeScript("document.getElementById('txtarrivaldate').value='"+retDate+"'");
  			//click on search again button
  			
  			driver.findElement(By.xpath("//a[@id='ctrlBrandedSearchClick']")).click(); 
  		    //find the element which has text as Make a booking on search result page
  	  		 Element=driver.findElement(By.xpath("//*[@id='ctl00_c_pH_heading1']"));
  	  		//make implicit wait zero , so that it could not mix with explicit wait
  	  		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
  	  		//now apply explicit wait for element to be in clickable condition
  	  		wait.until(ExpectedConditions.elementToBeClickable(Element));
  	  		//now again apply default implicit wait
  	  		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
  		    //identifying the webelement for low price appear or not by looking its size
  			lowPrice=driver.findElements(By.id("ctl00_c_ctlLowPrice_dvLowestPriceDisplay"));
  			
  			if(lowPrice.size()==0){
  				List continueBtn=driver.findElements(By.xpath("//a[@id='ctl00_c_btnContinue']"));
  				//if low price is not available , click on continue button
  				if(continueBtn.size()!=0)
  				driver.findElement(By.xpath("//a[@id='ctl00_c_btnContinue']")).click();
  			    //find the element which has text as Make a booking on search result page
  				Element=driver.findElement(By.xpath("//*[@id='ctl00_c_pH_heading1']"));
  				//nullify the implicit wait so that it could not mix with explicit wait
  				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
  			    //now apply explicit wait for element to be in clickable condition
  		  		wait.until(ExpectedConditions.elementToBeClickable(Element));
  		  		//getting the text of element low price
  		  	    String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
  		  	    System.out.println("Lowest Price Displayed is: "+lowestPrice);
  			   }
  		  	else{
  		  	   String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
   		       System.out.println("Lowest Price Displayed is: "+lowestPrice);
  		  	    }
  			}else{
  				String lowestPrice=driver.findElement(By.xpath("//span[@class='summary-curr-only']")).getText();
  	     		 System.out.println("Lowest Price Displayed is: "+lowestPrice);
  			}
  		
	}

	
}