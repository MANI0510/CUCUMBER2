package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
	
	WebDriver ldriver;
	
	public  AddCustomer(WebDriver rdriver)
	{
	
	ldriver = rdriver;
	
	PageFactory.initElements(ldriver, this);
	
	}
	
	By lnkcustomer_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By lnkcustomer_menu_item =By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By btnaddnew = By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtpassword = By.xpath("//input[@id='Password']");
	
	By firstname = By.xpath("//input[@id='FirstName']");
	
	By lastname =By.xpath("//input[@id='LastName']");
	
	By rdmale_btn = By.xpath("//input[@id='Gender_Male']");
	
	By rdfemale_btn = By.xpath("//input[@id='Gender_Female']");
	
	By txtdob = By.xpath("//input[@id='DateOfBirth']");
	
	By company_name = By.xpath("//input[@id='Company']");
	
	By tax_exe = By.xpath("//input[@id='IsTaxExempt']");
	

	
	By newsletter = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
    By list1 = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]");
    
    By list2 = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	
	By setcustomerrole = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"); 
	
	By listitemadministrator = By.xpath("//li[contains(text(),'Administrators')]");
	
	By listitemForeum_Moderatord = By.xpath("//li[contains(text(),'Forum Moderators')]");
	
	By listitemGuests =By.xpath("//li[contains(text(),'Guests')]");
	
	By listitemRegistered =By.xpath("//li[contains(text(),'Registered')]");
	
	By listitemVendors =By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmngrvendor = By.xpath("//select[@id='VendorId']");
	
	By active = By.xpath("//input[@id='Active']");
	
	By admincomment = By.xpath("//textarea[@id='AdminComment']");   
	
	By savebutton = By.xpath("//button[@name='save']");
	
	//Action class
	
	public String getpageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickoncustomermenu() {
		
		ldriver.findElement(lnkcustomer_menu).click();
	}
	
	public void clickoncustomermenuitem() {
		
		ldriver.findElement(lnkcustomer_menu_item).click();
	}
	
     public void clickonaddnewbutton() {
		
		ldriver.findElement(btnaddnew).click();
	}
     
     public void setEmail(String mail) {
    	 
    	 ldriver.findElement(txtEmail).sendKeys(mail);
     }
     
     public void setpassword(String pwd) {
    	 
    	 ldriver.findElement(txtpassword).sendKeys(pwd);
     }
	
     
     public void setFirstname(String fname) {
    	 
    	 ldriver.findElement(firstname).sendKeys(fname);
     }
	
     
     public void setLastname(String lname) {
    	 
    	 ldriver.findElement(lastname).sendKeys(lname);
     }
     
     public void setGender(String gender) {
    	 
    	 if(gender.equals("Male")) {
    		 
    		 ldriver.findElement(rdmale_btn).click();
    	 }
    	 else if (gender.equals("Female")) {
    		 
    		 ldriver.findElement(rdfemale_btn).click();
    	 }
    	 
    	 else {
    		 ldriver.findElement(rdmale_btn).click();
    	 }
     }
     
     public void setdob(String dob) {
    	 
    	 ldriver.findElement(txtdob).sendKeys(dob);
     }
     
  public void setcompanyname(String cname) {
    	 
    	 ldriver.findElement(company_name).sendKeys(cname);
     }
  
  public void clickontax() {
	  
	  ldriver.findElement( tax_exe).click();
  }
  
  public void newsletter(String value) throws InterruptedException {
	  
	  ldriver.findElement(newsletter).click();
	  
	  WebElement list;
	  
	  Thread.sleep(2000);
	  
	  if(value.equals("Your store name")) {
		  
		  list = ldriver.findElement(list1);
		  
		
	  }
	  
	  else {
		  
		  list = ldriver.findElement(list2);
		  
	
	  }
	  
	// list.click();
	 
	  
	  JavascriptExecutor js =  (JavascriptExecutor) ldriver;
	  js.executeScript("arguments[0].click();", list);
	  
	  Thread.sleep(3000);
	  
		  
	  
  }
  
  public void setcustomerrole(String role) throws InterruptedException
  {
	  if(!role.equals("Vendors")) {
		  
		  ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]/span"));
		  
		  
	 }
	  
	  ldriver.findElement(setcustomerrole).click();
	  
	  WebElement Listitem;
	  
	  Thread.sleep(3000);
	  
	  if(role.equals("Administrators")) {
		  
		  Listitem = ldriver.findElement(listitemadministrator);
	  }
	  
	  else if(role.equals("Forum Moderator")) {
		  
		  Listitem = ldriver.findElement(listitemForeum_Moderatord);
	  }
	  
	  else if(role.equals("Guests")) {
		  Listitem = ldriver.findElement(listitemGuests);
	  }
	  else if(role.equals("Registered")) {
		  
		  Listitem = ldriver.findElement(listitemRegistered);
	  }
	  
	  else if(role.equals("Vendors")) {
		 
		  Listitem = ldriver.findElement(listitemVendors);
	  }
	  
	  else {
		  
		  Listitem =ldriver.findElement(listitemGuests);
	  }
	  
	 // Listitem.click();
	  
	  JavascriptExecutor js =  (JavascriptExecutor) ldriver;
	  js.executeScript("arguments[0].click();", Listitem);
	  
	  Thread.sleep(3000);
  }
  
  public void setmanagervendor(String value) {
	  
	  Select drpdown = new Select(ldriver.findElement(drpmngrvendor));
			  drpdown.selectByVisibleText(value);
  }
  
  public void clickonactive() {
	  
	  ldriver.findElement(active).click();
  }
  
  public void setadmincomment(String comment) {
	  
	  ldriver.findElement(admincomment).sendKeys(comment);
  }
 
  public void clickonsavebutton() {
	  
	  ldriver.findElement(savebutton).click();
	  
	
  
  
  }
  
  
  
  
     
     
     
 
	
	
	
	
	
	
	
}
