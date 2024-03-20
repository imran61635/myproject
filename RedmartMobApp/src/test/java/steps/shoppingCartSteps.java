package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.Appiumdriver;

import java.util.List;
import java.util.Properties;
import java.util.Random;

public class shoppingCartSteps {
	MobileElement cartListBlock;
	List<MobileElement> listOfaddedProducts;
	Properties config=Appiumdriver.config;
	AndroidDriver<MobileElement> driver;
	@Given("^I am on the homepage of redmart app$")
	public void i_am_on_the_homepage_of_redmart_app() {
		
		Appiumdriver.setUpDriver();
		driver=Appiumdriver.getDriver();
	    System.out.println("Home page");
	}

	@When("^I click on three line menu option on top left of Explore$")
	public void i_click_on_three_line_menu_option_on_top_left_of_Explore() {
		driver.findElement(By.id(config.getProperty("threeLineMenuOptionAsID"))).click();   
	}

	@And("^Click on my account option$")
	public void click_on_my_account_option() {
		driver.findElement(By.id(config.getProperty("myAccountAsID"))).click();   
	}

	@And("^Enter the emailId in email text box of sign up$")
	public void enter_the_in_email_text_box_of_sign_up() {
		driver.findElement(By.xpath(config.getProperty("Sign_upOptionAsXpath"))).click();
		String partid=Double.toString(Math.random());
		driver.findElement(By.id(config.getProperty("emailTextBoxOfSignUpAsID"))).sendKeys("abc_asf"+partid+"@gmail.com");
	   
	}

	@And("^Enter the password in password text box of sign up$")
	public void enter_the_in_password_text_box_of_sign_up() {
		driver.findElement(By.id(config.getProperty("passwordTextBoxOfSignUpAsID"))).sendKeys("abcdef@gmail.com");
		driver.hideKeyboard();
	    
	}
	@And("^click on register button$")
	public void click_on_register_button() {
		driver.findElement(By.id(config.getProperty("registeButtonAsID"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("^I should see text \"([^\"]*)\" after successful registration$")
	public void i_should_see_text_after_successful_registration(String expected) {
		String actual=driver.findElement(By.xpath(config.getProperty("successfulRegistrationAsserTextAsXpath"))).getText();
		Assert.assertEquals(actual, expected); 
	    
	}

	@And("^I click on back arrow button to go on home page$")
	public void i_click_on_back_arrow_button_to_go_on_home_page() {
		driver.findElement(By.xpath(config.getProperty("topLeftArrowButtonAsXpath"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    
	}
	@When("^I find products on home page$")
	public void i_find_products_on_home_page() throws Throwable {
		MobileElement prodListBlock=driver.findElement(By.id(config.getProperty("prodListBlockOnHomePageAsID")));
	    
	}

	@Then("^I should be able to add all products to the cart$")
	public void i_should_be_able_to_add_all_products_to_the_cart() throws Throwable {
		MobileElement prodListBlock=driver.findElement(By.id("com.redmart.redmart.fake:id/productList"));
		List<MobileElement> listOfProducts=prodListBlock.findElements(By.className("android.widget.LinearLayout"));
		for(MobileElement product :listOfProducts ) {
			product.click();
			driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
			// clicking on backbutton after add prod to cart
			driver.findElement(By.xpath("//*[@class='android.widget.ImageButton' and @NAF='true']")).click();
		}
		
	}
	
	@When("^I click on shopping cart icon from prod list main page$")
	public void I_click_on_shopping_cart_icon_from_prod_list_main_page() {
		driver.findElement(By.id("com.redmart.redmart.fake:id/action_cart")).click();
		
	}
	@Then("^I should be able to remove products items to cart$")
	public void I_should_be_able_to_remove_products_items_to_cart() {
		// find the cart list block
		 cartListBlock=driver.findElement(By.id("com.redmart.redmart.fake:id/cartListView"));
		//getting list of added products
				
				listOfaddedProducts=cartListBlock.findElements(By.className("android.widget.FrameLayout"));
				//removing first product from cart
				listOfaddedProducts.get(0).findElementById("com.redmart.redmart.fake:id/minus").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				//getting list of added products again after removal of first product
				listOfaddedProducts=cartListBlock.findElements(By.className("android.widget.FrameLayout"));
				//removing second product as first element from cart
				listOfaddedProducts.get(0).findElementById("com.redmart.redmart.fake:id/minus").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				String actual=driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='CHECKOUT']")).getText();
				Assert.assertEquals(actual, "CHECKOUT");
	}
	
	@When("^I click on increase quantity option of the added item in cart$")
	public void I_click_on_increase_quantity_option_of_the_added_item_in_cart() {
		//getting list of added products again after removal of second product
		//MobileElement cartListBlock=driver.findElement(By.id("com.redmart.redmart.fake:id/cartListView"));
			//listOfaddedProducts=cartListBlock.findElements(By.className("android.widget.FrameLayout"));
	}
	@Then("^The item quantity should be changed$")
	public void The_item_quantity_should_be_changed() {
		MobileElement cartListBlock=driver.findElement(By.id("com.redmart.redmart.fake:id/cartListView"));
		//getting list of added products again after removal of second product
		List<MobileElement> listOfaddedProducts=cartListBlock.findElements(By.className("android.widget.FrameLayout"));
				//update third item quantity as first item from cart
				listOfaddedProducts.get(0).findElementById("com.redmart.redmart.fake:id/add").click();
				String actual=driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='CHECKOUT']")).getText();
				Assert.assertEquals(actual, "CHECKOUT");
	}
	@When("^I Click on checkout button$")
	public void I_Click_on_checkout_button() {
		driver.findElementById("com.redmart.redmart.fake:id/cartCheckout").click();
		
	}
	@Then("^I should see \"([^\"]*)\" option$")
	public void I_should_see_Select_your_address_option(String expected) {
		String actual=driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='Select your address.']")).getText();
		Assert.assertEquals(actual, expected);
		
		
	}
	
	@When("^click on add new address section after checkout$")
	public void click_on_add_new_address_section_after_checkout() throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/addressLayout").click();
	    
	}

	@And("^click the postal code section for address$")
	public void click_the_postal_code_section_for_address() throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/address").click();
	}

	@And("^enter the postal code \"([^\"]*)\" in the postal code section$")
	public void enter_the_postal_code_in_the_postal_code_section(String val) throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/location").sendKeys(val);
	}

	@And("^select the suggested address$")
	public void select_the_suggested_address() throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/address").click();
	}

	@And("^enter the \"([^\"]*)\" in floor section$")
	public void enter_the_in_floor_section(String val) throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/floor").sendKeys(val);
	}

	@And("^enter \"([^\"]*)\" in unit section$")
	public void enter_in_unit_section(String val) throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/unitNumber").sendKeys(val);
		if(driver.isKeyboardShown()) { driver.hideKeyboard(); }
	}

	@And("^enter \"([^\"]*)\" in the first name  section text box$")
	public void enter_mudassar_in_the_first_name_section_text_box(String val) throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/firstName").sendKeys(val);
		if(driver.isKeyboardShown()) { driver.hideKeyboard(); }
	}

	@And("^enter \"([^\"]*)\" in the last name  section text box$")
	public void enter_iqbal_in_the_last_name_section_text_box(String val) throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/lastName").sendKeys(val);
	}

	@And("^click on address save button$")
	public void click_on_address_save_button() throws Throwable {
		driver.findElementById("com.redmart.redmart.fake:id/action_save").click();
	}

	@Then("^i should see \"([^\"]*)\" section$")
	public void i_should_see_section(String expected) throws Throwable {
		String actual=driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='MOBILE NUMBER']")).getText();
		Assert.assertEquals(actual, expected);
		Appiumdriver.tearDown();
	}
	
	
}
