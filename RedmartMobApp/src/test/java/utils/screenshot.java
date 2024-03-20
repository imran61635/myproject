package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.apache.commons.io.FileUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class screenshot {
	
	public static void takeScreenshot()  {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
      try { 
        File scrFile = Appiumdriver.getDriver().getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(scrFile, new File("./src/test/resources/screenshots/"+timeStamp+".jpg"), true);
        
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      
	}

}
