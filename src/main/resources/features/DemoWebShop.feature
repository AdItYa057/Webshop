Feature: DemoWebShop
	In order to buy products 
	As a e-commerce customer
	I want to access the Application
	
Background: 
Given I have a browser with DemoWebShop Application

Scenario: Registration 	 
	When I enter gender as 'Female' and firstname as 'Harika' and lastname as 'Yarramsetty' and email as 'mohithayarramsetty@gmail.com' and password as 'Yarramsetty1#' and confirmpassword as 'Yarramsetty1#' 
	 
	Then my account must be registered with the Application

Scenario: Login
When I give valid credentials and click on Login 
Then I must login to the portal

Scenario: Search
When I enter Fiction in search bar and click on search 
Then I must get the suggestions of the products

Scenario: Books
When I click on Books in the Homepage
Then I must get navigated to the Books page and must be able to select books

Scenario: Computers
When I click on Computers in the Homepage
Then I must get navigated to the Computers page and must be ale to select computers


