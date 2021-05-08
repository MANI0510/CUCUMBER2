package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pageobject.AddCustomer;
import Pageobject.Loginpage;
import Pageobject.Searchcustomerpage;
import cucumber.api.java.en.*;



public class Steps extends Baseclass{
	
	
	
@Given("^Users Launch the browser$")
public void users_Launch_the_browser() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver","C://MANIKANDAN//SELENIUM PACKAGES//chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	
	lp = new Loginpage(driver);
 
}

@When("^User opens URL \"([^\"]*)\"$")
public void user_opens_URL(String url) throws Throwable {
	
	driver.get(url);
   
}

@When("^User enters email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void user_enters_email_as_and_password_as(String unamw, String pwd) throws Throwable {
	
	lp.setusername(unamw);
	lp.setpassword(pwd);
    
}

@When("^Click on Login$")
public void click_on_Login() throws Throwable {
	
	lp.clickloginbutton();
  
}

@Then("^Title Should be \"([^\"]*)\"$")
public void title_Should_be(String title) throws Throwable {
	
	if(driver.getPageSource().contains(title)) {
		
		Assert.assertTrue(true);
	
	
	}
	else {
		Assert.assertEquals(title,driver.getTitle());
		
	}

}

@Then("^Click Logout$")
public void click_Logout() throws Throwable {
   
	lp.clicklogoutlink();
}

@Then("^Close the Browser$")
public void close_the_Browser() throws Throwable {
	
	driver.quit();
  
}

//ADDING NEW CUSTOMER



@Then("^User can view Dashboard$")
public void user_can_view_Dashboard() throws Throwable {
	
	addcust = new AddCustomer(driver);
  Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getpageTitle());
	
    
}

@When("^User click on customers Menu$")
public void user_click_on_customers_Menu() throws Throwable {   
	
	Thread.sleep(2000);
	addcust.clickoncustomermenu();
    
}

@When("^Click on customer Menu item$")
public void click_on_customer_Menu_item() throws Throwable {
  
	Thread.sleep(2000);
	addcust.clickoncustomermenuitem();
}

@When("^Click on Add new button$")
public void click_on_Add_new_button() throws Throwable {
	
	Thread.sleep(2000);
	addcust.clickonaddnewbutton();
   
}

@Then("^customer can view Add new customer page$")
public void customer_can_view_Add_new_customer_page() throws Throwable {
	
	Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getpageTitle());
  
}

@When("^User enter customer info$")
public void user_enter_customer_info() throws Throwable {
	
	String email = randomestring()+"@gmail.com";
	
	addcust.setEmail(email);
	addcust.setpassword("mani123");
	addcust.setFirstname("MANI");
	addcust.setLastname("KANDAN");
    addcust.setGender("Male");
    addcust.setdob("10/10/1992");
    addcust.setcompanyname("ABC PVT LTD");
    addcust.clickontax();
    addcust.newsletter("Your store name");
    addcust.setcustomerrole("Guests");
    addcust.setmanagervendor("Vendor 1");
    addcust.clickonactive();
    addcust.setadmincomment("He is good in testing");
}

@When("^click on save button$")
public void click_on_save_button() throws Throwable {
	
	addcust.clickonsavebutton();
	Thread.sleep(3000);
   
}

@Then("^User can view the confirmation message \"([^\"]*)\"$")
public void user_can_view_the_confirmation_message(String arg1) throws Throwable {
	
	String text = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]")).getText();
	
	System.out.println(text);
	
   Assert.assertEquals(text,"The new customer has been added successfully.");
   
}



//serach customer by email


@When("^Enter customer email$")
public void enter_customer_email() throws Throwable {
	
	searchcust = new Searchcustomerpage(driver);
	
	searchcust.setEmail("victoria_victoria@nopCommerce.com");
	
    
}

@When("^click on search button$")
public void click_on_search_button() throws Throwable {
	
	searchcust.clickonsearch();
	Thread.sleep(3000);
    
}

@Then("^user should found the email in the search table$")
public void user_should_found_the_email_in_the_search_table() throws Throwable {  
	
	boolean status = searchcust.searchcustomerbyemail("victoria_victoria@nopCommerce.com"); 
	
	Assert.assertEquals(true,status);
   
}


//search customer by name

@When("^Enter customer firstname$")
public void enter_customer_firstname() throws Throwable {    
	
	searchcust = new Searchcustomerpage(driver);
	
	searchcust.setFirstname("Steve");
    
}

@When("^Enter customer lastname$")
public void enter_customer_lastname() throws Throwable {
	
	searchcust.setLastname("Gates");
    
}


@Then("^user should found the name in the search table$")
public void user_should_found_the_name_in_the_search_table() throws Throwable {
	
	
	boolean status = searchcust.searchcustomerbyname("Steve Gates"); 
	
	Assert.assertEquals(true,status);
   
	
}

@Then("^close the browser$")                              
public void close_the_browser() throws Throwable {
	
	driver.close();
  
}



}
