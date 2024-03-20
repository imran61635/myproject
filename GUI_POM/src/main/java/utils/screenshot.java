package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import common.Setup_Page;
import org.apache.commons.io.FileUtils;




public class screenshot extends Setup_Page {

	//this method take screenshot can be used anywhere if required
	public static void takeScreenshot()  {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
      try { 
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
        FileUtils.copyFile(scrFile, new File("./screenshots/"+timeStamp+".png"), true);
        
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      
	}

}
