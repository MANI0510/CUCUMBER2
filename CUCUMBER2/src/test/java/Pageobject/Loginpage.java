package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver) {
	
	ldriver = rdriver;
	
	PageFactory.initElements(rdriver, this);

}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnklogout;
	
	public void setusername(String uname) {
		txtemail.clear();
		txtemail.sendKeys(uname);
		
		
	}
	
	public void setpassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
	
	public void clickloginbutton() {
		
		btnlogin.click();
	}
	
	public void clicklogoutlink() {
		lnklogout.click();
	}
}
