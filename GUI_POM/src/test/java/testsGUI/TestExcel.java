package testsGUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.SetUp_API;
import utils.ExcelUtilAPI;
import utils.ExcelUtils;


public class TestExcel extends SetUp_API {
	
	
	@DataProvider
	public static Object[][] getData(){
		return ExcelUtilAPI.getData("Sheet1");
	}
	//this method run multiple time based on number of rows in excel
	@Test(dataProvider = "getData")
	void excelReading(String user, String paswrd) throws FileNotFoundException, IOException {
		
		System.out.println(".........Reading user info from excel sheet..................");
		System.out.println("Username: "+user);
		System.out.println("Role: "+paswrd);
		
		
		
	}

}
