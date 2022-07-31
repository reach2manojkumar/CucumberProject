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

  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      
      
 #Feature: login application testing 
      #
      #
   #Scenario Outline: Validating with invalid username and valid password 
    #Given Open the chrome as login page
    #And verify whether loaded page is correct or not
    #When As user give invalid  and valid 
    #And Click the login botton
    #Then Check the whether it redirected to loginpage or not
    #And Verify Warning text is present or not
    #And close the webpage
    #
#Examples:
#						|usernamelg|passwordlg|
#						|manoj506|Password|
#						|manoj ad5sad06|Password|
#						|     |Password|
#						||Password|
#						|manoj506|Password|
      
      
      
      
      
