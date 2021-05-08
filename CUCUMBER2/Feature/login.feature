Feature: Login
Scenario: Successful login with valid credentials
   
   Given Users Launch the browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then Title Should be "nopCommerce administration"
   And Click Logout
   Then Title Should be "store. Login"
   And Close the Browser

   

   