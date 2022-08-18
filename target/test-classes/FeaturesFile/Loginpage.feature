#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
@drop
Feature: Validation the login functionlity

  Background: 
    Given Open the chrome as login page

  Scenario Outline: Validating with invalid username and valid password
    And verify whether loaded page is correct or not
    When As user give invalid "<usernamelg>" and valid "<passwordlg>"
    And Click the login botton
    Then Verify Warning text is present or not
    And Check the whether it redirected to loginpage or not
    And close the webpage

    Examples: 
      | usernamelg    | passwordlg |
      | manoj506      | Password   |
      | manojkumar506 | Password   |
      | mano mar506   | Password   |
      | ! 506         | Password   |
      | ! wew         | Password   |

  Scenario Outline: Validating with black username and valid password
    And verify whether loaded page is correct or not
    When As user give blank "<usernamelg>" and valid "<passwordlg>"
    And Click the login botton
    Then Verify Warning text is present or not
    And Check the whether it redirected to loginpage or not
    And close the webpage

    Examples: 
      |          | passwordlg |
      | manoj506 |            |
