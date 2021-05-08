Feature: Add customer

 Background: Below are the common for each scenario
   Given Users Launch the browser
   When  User opens URL "https://admin-demo.nopcommerce.com/login" 
   And  User enters email as "admin@yourstore.com" and password as "admin" 
   And  Click on Login 
   Then  User can view Dashboard 
  
    
   
	
	

Scenario: Add a new customer
   When User click on customers Menu
   And Click on customer Menu item
   And Click on Add new button
   Then customer can view Add new customer page
   When User enter customer info
   And click on save button
   Then User can view the confirmation message "The new customer has been added successfully."
   And close the browser
    


   

Scenario: Search a customer
   Then User can view Dashboard
   When User click on customers Menu
   And Click on customer Menu item
   And Enter customer email
   When click on search button
   Then user should found the email in the search table
   And close the browser
   
    
 Scenario: Search a customerbyname
   Then User can view Dashboard
   When User click on customers Menu
   And Click on customer Menu item
   And Enter customer firstname
   And Enter customer lastname
   When click on search button
   Then user should found the name in the search table
   And close the browser
   
   
  

   
  
   
   
   

  
   
   
  
   
   
   