package utils;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import common.Setup_Page;

//This method currently tested for opening window in another tab and switch focus to another tab related to chrome
public class swithToTab extends Setup_Page {
	 
	public static void getFocusSwithToTab()  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		it.next();
		String child=it.next();
		
		System.out.println("Switching to Tab");
		try {
			Actions action= new Actions(driver);
			action.sendKeys(Keys.CONTROL, Keys.TAB).build().perform();
			driver.switchTo().window(child);

		Thread.sleep(2000);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	//This method works well in switching to another window opened in firefox or IE
		public static void getSwitchToWindow()  {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			it.next();
			String child=it.next();
			
			System.out.println("Switching to Tabbed window");
			try {
				
				driver.switchTo().window(child);

			Thread.sleep(2000);
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	

}
