package runners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"json:target/scenarioRunner/cucumber.json", "pretty", "html:target/scenarioRunner/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
        features = "src/test/resources/features/",
        glue = "steps",
        tags = {"@tag1,@tag2,@tag3,@tag4,@tag5,@tag6"}
        )
public class scenarioRunner extends AbstractTestNGCucumberTests {
	
	
	@BeforeClass
    public static void setup() {
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
        ExtentCucumberFormatter.addSystemInfo("App Name", "RedmartQE");
        ExtentCucumberFormatter.addSystemInfo("App Type ", "Native Android App");
        

        //  add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }
	
	

}
