package testsGUI;




import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import common.Setup_Page;
import page.WorkOrderdetailPage;
import page.LoginMainPage;
import utils.DButilities;
import utils.ExcelUtils;
import utils.swithToTab;


//Extend the Setup_page to get driver and property instance
public class WRIDTest extends Setup_Page {
	
	String woid;
	LoginMainPage mainPage= new LoginMainPage(driver);
	WorkOrderdetailPage WODpage=new WorkOrderdetailPage(driver);
	
	//Define data provider and provide just the sheet name in get data method
	@DataProvider
	public static Object[][] getLogininfo(){
		
		return ExcelUtils.getData("loginData");
	}
	
   //verify the user login by search title
	@Test(priority=0,dataProvider="getLogininfo")
	public void loginToGUITest(String username, String mypassword,String pageTitle ) throws Exception{
		
		String ACTpageTitle=mainPage.loginToPage(username, mypassword);
		Assert.assertEquals(ACTpageTitle,pageTitle);
	}
	
	//this method will send the CAWO created WRID to search WRID page and click on search button
	@Test(priority=1)
	public void searchWRIDTest() {
		//String sql=Config.getProperty("sql");
		// woid=DButilities.getWRID(sql);
		woid=WOID.getProperty("WOID");
		 if(woid==null)
			 System.out.println("No Record/Data is avaiable in DB");
		String searchedActualWRID=mainPage.searchWRID(woid);
		Assert.assertEquals(searchedActualWRID, woid);
		
	}
	//this method check word order id label on work order detail page
	@Test(priority=2)
	public void testWRIDTextDispay() {
		mainPage.clickWridLink();
		swithToTab.getFocusSwithToTab();
		String ACTWODText=WODpage.getWoidInfoText();
		Assert.assertEquals(ACTWODText, "WORK ORDER DETAILS - "+woid);
		
	}
	//This method click on setting  icon on wordorder detail page
	@Test(priority=3)
	public void testSettingLinkOnWODPage() throws InterruptedException  {
		WODpage.clickOnSettinklinkIcon();
		
		
	}
	
	//This will  surely run for  close and kill the browser
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		//This function close the opened window only
		driver.close();
		System.out.println("Closing the window");
		Thread.sleep(2000);
		//This function kill the browser
		System.out.println("Closing the driver");
		driver.quit();
		
	}
	

}
