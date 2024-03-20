package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import utils.ExcelReader;
import utils.WebEventListener;


//this class is responsible for GUI testing, need to extend to get driver, property and excel sheet 
public class Setup_Page {
	//Define all the object variable
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties Config = new Properties();
	public static Properties WOID = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/inputFiles/testdata.xlsx");
	public static Logger logs = Logger.getLogger(Setup_Page.class);
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	
	public Setup_Page() {
		// singleton design pattern, no multiple object can be created
		if(driver==null){
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			Config.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		logs.debug("Loaded the Config property file");
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/WOID.properties");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			WOID.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		logs.debug("Loaded the WOID property file");
		
		
		
		if(Config.getProperty("browser").equalsIgnoreCase("firefox")){
			//ProfilesIni listProfile= new ProfilesIni();
			//FirefoxProfile profile= listProfile.getProfile("default");
			//driver = new FirefoxDriver(profile);
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/browserDrivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			logs.debug("Loaded Firefox");
			
		}else if(Config.getProperty("browser").equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", "./src/test/resources/browserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logs.debug("Loaded IE");
		}else if(Config.getProperty("browser").equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/browserDrivers/chromedriver.exe");
			//Updated code for headless browsing on chrome only
			ChromeOptions options = new ChromeOptions();
			boolean headless=Boolean.parseBoolean(Config.getProperty("headless"));
			options.setHeadless(headless);
			driver = new ChromeDriver(options);
			logs.debug("Loaded Chrome");
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		// Opening the browser here
		driver.get(Config.getProperty("URL"));
		driver.manage().deleteAllCookies();
	//  It is for MAC IOS only	driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		//Define implicitly wait
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		//Define explicitly wait
		wait=new WebDriverWait(driver, 60);
		
		}
		
	
		
	}
	
	
	
	
	
	

}
