package utils;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appiumdriver {

	private static Appiumdriver appiumDriver;
	public static Properties config = new Properties();

	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	// initialize AndroidDriver
	private static AndroidDriver<MobileElement> driver;

	private Appiumdriver() {
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		logs.debug("Loaded the Config property file");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		capabilities.setCapability("automationName", config.getProperty("automationName"));
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("appPackage", config.getProperty("appPackage"));
		capabilities.setCapability("appActivity", config.getProperty("appActivity"));

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      screenshot.takeScreenshot();
	}

	public static AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (appiumDriver == null)
			appiumDriver = new Appiumdriver();

	}

	
	public static void tearDown() {
		if (driver != null) {

			driver.quit();
		}
		appiumDriver = null;
	}

}