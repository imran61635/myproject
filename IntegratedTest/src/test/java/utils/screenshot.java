package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runners.scenarioRunner;

public class screenshot {
	public static WebDriver driver=Appiumdriver.getDriver();
	public static void takeScreenshot() {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./src/test/resources/screenshots/" + timeStamp + ".jpg"), true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
