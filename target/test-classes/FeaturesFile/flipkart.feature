#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: FlipKart product search functionality
  Verify functionlity of searching all the  product satisfying the search

 
  Scenario: Verify functionality of search box
    Given Flipkart product home page
    When As customer,i want to search the specific product
    And type text that want to search product
    
    

 Scenario: Verify the search box Dropdown 
 		Given Flipkart product home page
 		When As customer,i want to search "<searchname>" the specific product
 		Then Validation "<searchname>" the Dropdown Suggestion
 		
 		Examples:
							|searchname|
 							|shoes|
 							|mobile|
 							|plant|
 	@drop						
 Scenario: Check the scroll Down and Up functionality 		
 		Given User  want to scroll Down and click
 		When user want to scroll up by using page up key
 		Then verify whether login button is visible
