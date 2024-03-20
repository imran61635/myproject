package runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.MyDriver;
import utils.MyScreenRecorder;


@CucumberOptions(
        plugin = {"json:target/scenarioRunner/cucumber.json", "pretty", "html:target/scenarioRunner/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
        features = "src/test/resources/features/",
        glue = "steps",
        tags = {"@tag1"}
        )
public class scenarioRunner extends AbstractTestNGCucumberTests {
	
    public static	WebDriver driver;
	
	public static Properties config = new Properties();

	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	
	

	@BeforeClass
    public static void setup() throws Exception {
	//	MyScreenRecorder.startRecording("Test");
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
	
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		
		String fileName=  "./target/ExtentReport/" + strDate+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
		
        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("App Name", "Emirates");
        ExtentCucumberFormatter.addSystemInfo("App Type ", "Webapp");
        

        //  add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
        
    }
	

}
