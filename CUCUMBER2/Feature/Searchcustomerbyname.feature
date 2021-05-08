Feature: Searchcustomerbyname

   Scenario: Search a customerbyname
   
   Given Users Launch the browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then User can view Dashboard
   When User click on customers Menu
   And Click on customer Menu item
   And Enter customer firstname
   And Enter customer lastname
   When click on search button
   Then user should found the name in the search table
   And close the browser