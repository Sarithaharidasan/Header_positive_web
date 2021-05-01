package Header_Home_Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Header_home_page_Script extends Generic_function{
	public static boolean value;
	@Given("browser is open")
	/*Browser launch*/
	public static void browser_launch()  {
		
			   try {
				browserlaunch();
			} catch (IOException e) {
				 e.getMessage();
			}
			}

	@Then("check the mpowered health logo  should be present in the header")
	/*TC 001 - Validate that the  'mpowered health’ logo  should be present in the header*/
	public static void header_positive_tc_001() throws IOException {
		try {
			click("welcome_login");
	        page_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number"));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password"));
			click("login");
			page_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_001");
		}
		
	}
	
	@When("User click on Help icon navigated to the help page")
	/*TC 002 -Validate that the user is navigated to the help page on clicking 'Help' icon*/
	public static void header_positive_tc_002() throws IOException {
		try {
			click("help");
			page_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "frequently"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_002");
		} 
	}

	@When("User click on Log out icon navigated to the Landing  page")
	/*TC 003 -Validate that the user is navigated to the Landing page on clicking 'Log out' icon*/
	public static void header_positive_tc_003() throws IOException {
		
		try {
			page_wait(12);
			click("logout");
			page_wait(12);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_003");
		}
		
	}
	
	@When("User click on Your alerts icon navigated to the alerts page")
	/*TC 004 -Validate that the user is navigated to the alerts page on clicking 'Your alerts' icon*/
	public static void header_positive_tc_004() throws IOException {
		try {
			click("welcome_login");
			page_wait(12);
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_phone_number"))).sendKeys(td_reader("login_phone_number"));
			driver.findElement(By.xpath(OR_reader("Object_locator", "login_password"))).sendKeys(td_reader("login_password"));
			click("login");
			page_wait(12);
			click("alerts");
			page_wait(12);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_004");
		}
		
	}

	@When("User click on Drop down tab  to see the drown down options")
	/*TC 005 -Validate that user is able to click on the 'Drop down' tab*/
	public static void header_positive_tc_005() throws IOException {
		try {
			click("down_arrow");
			page_wait(50);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "profile"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_005");
		} 
	}

	@When("User click on Drop down tab and click on  Your profile then  navigated to the profile page.")
	/*TC 006 -Validate that the user is navigated to the  profile page on clicking 'Your profile' tab*/
	public static void header_positive_tc_006() throws IOException {
	    try {
			click("profile");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "yourprofile"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_006");
		}
	}

	@When("User click on Drop down tab and click on  Your ratings  then  navigated to the ratings dashboard page.")
	/*TC 007 -Validate that the user is navigated to the ratings dashboard page on clicking 'Your ratings' tab*/
	public static void header_positive_tc_007() throws IOException {
		try {
			click("down_arrow");
			page_wait(50);
			click("ratings");
			page_wait(50);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "yourratings"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_007");
		}
		
	}

	@When("User click on Drop down tab and click on  Feedback  then  navigated to the Feedback Port.")
	/*TC 008 -Validate that the user is navigated to the 'Feedback Port'   page  on clicking 'Feedback'*/  
	public static void header_positive_tc_008() throws IOException {
		try {
			click("down_arrow");
			page_wait(50);
			click("feedback");
			page_wait(50);
			browser_handle();
	        value = driver.findElement(By.xpath(OR_reader("Object_Locator", "yourfeedback"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	window_close();
	        browser_switch();
	     } catch (IOException e) {
	    	 e.getMessage();
			takeScreenShot("header_positive_tc_008");
		}
	}
	
	@When("User click on Drop down tab and click on  Contact Us  then  navigated to the Contact Us.")
	/*TC 009 -Validate that the user is navigated to the Contact Us   page  on clicking Contact us */
	public static void header_positive_tc_009() throws IOException {
		try {
			click("down_arrow");
			page_wait(50);
			click("contact");
			page_wait(50);
			browser_handle();
	        value = driver.findElement(By.xpath(OR_reader("Object_Locator", "contact_form"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	window_close();
	        browser_switch();
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_009");
		}  
	}

	@When("User click on Drop down tab and click on  Privacy Policy then dialogue box will appear")
	/*TC 010 -Validate that the user is able to see Privacy Policy dialogue box on clicking on the 'Privacy Policy' */
	public static void header_positive_tc_010() throws IOException {
		try {
			click("down_arrow");
			page_wait(50);
			click("privacy");
			page_wait(50);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "privacy_ok"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	click("privacy_ok");
			
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_010");
		}
		 
	}

	@When("User click on Drop down tab and click on  Terms & Conditions then dialogue box will appear")
	/*TC 011 - Validate that the user is able to see Terms & Conditions dialogue box on clicking on the 'Terms & Conditions' */
	public static void header_positive_tc_011() throws IOException {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		try {
			click("down_arrow");
			page_wait(50);
			click("terms");
			page_wait(50);
			value = driver.findElement(By.xpath(OR_reader("Object_Locator", "terms_ok"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	click("terms_ok");
	    	driverquit();
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_011");
		}
		
	   
	}

}

