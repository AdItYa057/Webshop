Feature: DemoWebShop 
	In order to buy products 
	As a e-commerce customer
	I want to access the Application
	
Background: 
	Given I have a browser with DemoWebShop Application 
	
Scenario: Registration 
	When I enter gender as 'male' and firstname as 'aditya' and lastname as 'borra' and email as 'adityaB@gmail.com' and password as 'adityaB' and confirmpassword as 'adityaB' 
	
	Then my account must be registered with the Application 
	
Scenario: Login 
	When I enter email as 'trustxd@gmail.com' and enter password as 'trustXD' and click on Login 
	Then I must login to the portal 
	

Scenario: Search 
	When I enter 'Fiction' in search bar and click on search 
	Then I must get the products related to Fiction 
	
	
Scenario: Books 
	When I click on Books in the Homepage and select 'Science' book 
	Then I must get the price of the book 
@valid	
Scenario: Computers 
	When I click on Computers in the Homepage and click on 'Notebooks' and select '14.1-inch laptop' 
	
	Then I must get navigated to the laptop page and must be ale to get product details
	
	
