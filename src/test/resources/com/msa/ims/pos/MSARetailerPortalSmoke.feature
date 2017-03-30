@Regression
Feature: MSA Retailer Portal Smoke - User Accounts

  As a tester, I would like to utilize cucumber,
  so that I can create BDD style tests to test Portal UI.
  Browsers under test: Chrome, Edge, Firefox, IE 11
  Task POS-159 in progress

  Background:

  @Smoker
  Scenario: Verify that the internal portal and the external portal are down C#391490
    When I try to login to the internal portal
    And click button Login
    Then the login failed
    When I try to login to the external portal
    And click button Login
    Then the login failed

  @Smoke
  Scenario: Login screen works C#391491
    Given I login to the portal as a rsc user
    Then my email is displaying

  @Smoke
  Scenario: Searching works for both enrolled retailers and enrolling a retailer C#391492
    #need work: more than 1 link, timeout etc.
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Create Accounts page
    And I search for retailer rj food mart
    Then the retailer link is displaying

  @Smoke
  Scenario: Able to view the portal screens for current quarter, last quarter, submission history, testing, active users, and account info C#391493
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on last quarter
    Then I am on the last quarter page
    When I click on submission history
    Then I am on the submission history page
    When I click on testing
    Then I am on the testing page
    When I click on active users
    Then I am on the active users page
    When I click on account info
    Then I am on the account info page

  @Smoke
  Scenario: Comments screen comes up and any comments available are displayed C#391494
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on testing
    Then I am on the testing page
    When I click on last comments
    Then the test comment is displaying
    And the comment box is displaying

  @Smoke
  Scenario: Transaction screen loads for current quarter, last quarter, submission history, and testing C#391495
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click the transaction summary for current quarter
    Then the transaction summary is displaying
    When I click on previous page
    And I click on last quarter
    Then I am on the last quarter page
    When I click the transaction summary for last quarter
    Then the transaction summary is displaying
    When I click on previous page
    And I click on submission history
    Then I am on the submission history page
    When I click the transaction summary for submission history
    Then the transaction summary is displaying
    When I click on previous page
    And I click on testing
    Then I am on the testing page
    When I click the transaction summary for testing
    Then the transaction summary is displaying
    And I click on previous page

  @Smoke
  Scenario: Outlets screen loads for Transaction Summary report C#391496
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click the attached files for current quarter
    Then the attached file is displaying
    When I click the transaction summary for attached files
    Then the transaction summary is displaying
    When I click on the first outlet
    Then I am on the outlets page
    When I click on previous page 2
    And I click on last quarter
    Then I am on the last quarter page
    When I click the attached files for last quarter
    Then the attached file is displaying
    When I click the transaction summary for attached files
    Then the transaction summary is displaying
    When I click on the first outlet
    Then I am on the outlets page
    When I click on previous page 2
    Then I am on the submission history page
    When I click the transaction summary for submission history
    Then the transaction summary is displaying
    When I click on the first outlet
    Then I am on the outlets page
    When I click on previous page 2
    And I click on testing
    Then I am on the testing page
    When I click the transaction summary for testing
    Then the transaction summary is displaying
    When I click on the first outlet
    Then I am on the outlets page
    And I click button Missing

  @Smoke
  Scenario: Errors display for current quarter, last quarter, submission history, and testing C#391497
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click the attached files for current quarter
    Then the attached file is displaying
    When I click the errors for attached files
    Then I am on the errors page
    When I click button View Errors
    And I click on previous page
    And I click on last quarter
    Then I am on the last quarter page
    When I click the attached files for last quarter
    Then the attached file is displaying
    When I click the errors for attached files
    Then I am on the errors page
    When I click button View Errors
    And I click on previous page
    Then I am on the submission history page
    When I click the errors for submission history
    Then I am on the errors page
    When I click button View Errors
    And I click on previous page
    And I click on testing
    Then I am on the testing page
    When I click the errors for testing
    Then I am on the errors page
    When I click button View Errors

  @Smoke
  Scenario: Able to view users and edit users C#391498
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    #need work for the same timeout issue here
    When I click button View Users
    And I click pencil to edit active users

  @Smoke
  Scenario: Able to create new users C#391499
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on active users
    Then I am on the active users page
    And I click on create

  @Smoke
  Scenario: Able to enroll new retailers C#391500
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Create Accounts page
    And I search for retailer rj food mart
    And I click on enroll retailer link
    #need to fix: what is the link
    Then the enroll button is displaying

  @Smoke
  Scenario: Able to edit account info C#391501
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    #need to fix: verification of the page
    Then I am on the account info page
    When I click pencil to edit account info

  @Smoke
  Scenario: Account Transaction YTD screen loads for enrolled retailers \(Production Data\) C#391502
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the YTD Report page
    Then I am on the account transactions page
    When I search accounts for retailer 7-eleven
    Then I am on the transactions by month page
    #When I click on January
    #Then I am on the january transactions page
    #When I click button View Days

  @Smoke
  Scenario: Account Transaction YTD (Test) screen loads for enrolled retailers (Production Data) C#391503
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the YTD Report Test page
    Then I am on the account transactions page
    When I search accounts for retailer 7-eleven
    Then I am on the transactions by month page
    #When I click on January
    #Then I am on the january transactions page
    #When I click button View Days

  @Smoke
  Scenario: Able to assign RSC representative to an account C#433065
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    When I click pencil to edit account complexity

  @Smoke
  Scenario: Able to assign account complexity to an account C#433066
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    When I click pencil to edit account complexity

  @Smoke
  Scenario: Verify Active Accounts selection from Retailers menu C#445941
    Given I login to vl184 as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    Then I am on the active retailers page

  @Smoke
  Scenario: Verify Inactive Accounts selection from Retailers menu C#445942
    Given I login to vl184 as a rsc user
    Then my email is displaying
    When I navigate to the Inactive Accounts page
    Then I am on the inactive retailers page

  @Smoke
  Scenario: Verify account status once viewing account info for an active retailer C#445943
    Given I login to vl184 as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    Then I am on the active retailers page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    Then active status is displaying

  @Smoke
  Scenario: Verify the user can inactivate an active retailer C#445944
    Given I login to vl184 as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    Then active status is displaying
    Then the deactivate button is displaying

  @Smoke
  Scenario: Verify there is a confirmation when making a retailer inactive C#445945
    Given I login to vl184 as a rsc user
    Then my email is displaying
    When I navigate to the Active Accounts page
    When I search for retailer 7-eleven
    Then I am on the current quarter page
    When I click on account info
    Then I am on the account info page
    Then active status is displaying
    Then the deactivate button is displaying
    When I click button deactivate
    Then the confirm deactivate button is displaying

  @Smoke
  Scenario: Logout works C#391508
    Given I login to the portal as a rsc user
    Then my email is displaying
    When I click username and choose logout
    Then I am redirected to the login page
    And I close the browser