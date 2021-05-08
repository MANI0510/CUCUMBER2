package StepDefinition;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobject.AddCustomer;
import Pageobject.Loginpage;
import Pageobject.Searchcustomerpage;

public class Baseclass {

		
		public WebDriver driver;
		public Loginpage lp;
		public AddCustomer addcust;
		public Searchcustomerpage searchcust;
		
		
		public static String randomestring() {
			
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return(generatedString1);
			
		}
		
	}


