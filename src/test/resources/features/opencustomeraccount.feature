@all @opencustomerdetails
Feature: Add New Customer
  As a User
  I should be able to open customer details
  So customer details is displayed

@sample
  Scenario: Successfully view customer account details
  	Given I am in the login screen
	When I access the welcome screen
	And I navigate to Add New Customer screen
	And I Fill-up Customer Search Screen
	Then I should see the customer details

@fail
  Scenario: Failed to view customer account details
  	Given I am in the login screen
	When I access the welcome screen
	And I navigate to Add New Customer screen
	And I Fill-up Customer Search Screen
	Then I should not see the customer details