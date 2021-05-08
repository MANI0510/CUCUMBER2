package Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Waithelper;

public class Searchcustomerpage {
	
	public WebDriver ldriver;
	
	Waithelper waithelper;
	
	public  Searchcustomerpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new Waithelper(ldriver);
	}
	
	@FindBy(how=How.ID,using = "SearchEmail")
	@CacheLookup
	WebElement txtmail;
	
	@FindBy(how=How.ID,using = "SearchFirstName")
	@CacheLookup
	WebElement txtfirstname;
	
	@FindBy(how=How.ID,using = "SearchLastName")
	@CacheLookup
	WebElement txtlastname;
	
	@FindBy(how=How.ID,using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement birthmonth;
	
	
	@FindBy(how=How.ID,using = "SearchDayOfBirth")
	@CacheLookup
	WebElement birthday;
	
	@FindBy(how=How.ID,using = "SearchCompany")
	@CacheLookup
	WebElement companyname;
	
	@FindBy(how=How.ID,using = "SearchIpAddress")
	@CacheLookup
	WebElement ipaddress;
	
	@FindBy(how=How.XPATH,using = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement customerrole;
	
	@FindBy(how=How.XPATH,using = "//li[contains(text(),'Administrator')]")
	@CacheLookup
	WebElement listitemadministrator;
	
	@FindBy(how=How.XPATH,using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listitemForum;
	
	
	@FindBy(how=How.XPATH,using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listitemguests;
	
	@FindBy(how=How.XPATH,using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listitemregister;
	
	@FindBy(how=How.XPATH,using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listitemvendors;
	
	@FindBy(how=How.ID,using = "search-customers")
	@CacheLookup
	WebElement searchbtn;
	
	
	@FindBy(how=How.XPATH,using = "//table[@role ='grid']")
	@CacheLookup
	WebElement serachcustomerresults;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecolumn;
	
	public void setEmail(String email) {
		waithelper.waitforelement(txtmail,30);
		txtmail.clear();
		txtmail.sendKeys(email);
	}
	
	public void setFirstname(String fname) {
		waithelper.waitforelement(txtfirstname,30);
		txtfirstname.clear();
		txtfirstname.sendKeys(fname);
	}
	
	
	public void setLastname(String lname) {
		waithelper.waitforelement(txtlastname,30);
		txtlastname.clear();
		txtlastname.sendKeys(lname);
	}
	
	public void clickonsearch() {
		searchbtn.click();
		waithelper.waitforelement(searchbtn, 30);
	}
	
	public  int getNoOfRows() {
		return (tablerows.size());
	}
	
	public int getNoOfColumns() {
		return (tablecolumn.size());
	}
	
	public boolean searchcustomerbyemail(String email) {
		
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			
			String emailid = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText(); 
			
			System.out.println(emailid);
			
			if(emailid.equals(email)) {  
				
				flag =true;
			}
			
				
			}
	
		
		return flag;
		
	}
	
	
public boolean searchcustomerbyname(String Name) {
		
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			
			String name = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText(); 
			
			String names[] = name.split(" ");
			
			
			if(names[0].equals("Steve") && names[1].equals("Gates")) { 
				
				flag =true;
			}
			
				
			}
	
		
		return flag;
		
	}




}



