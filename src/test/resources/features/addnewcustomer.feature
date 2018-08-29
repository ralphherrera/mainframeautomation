@addnewcustomer @all 
Feature: Add New Customer
  As a User
  I should be able to add a new customer in the system
  So the customer is now created in the system


  Scenario: Successfully add new customer
  	Given I am in the login screen
	When I access the welcome screen
	And I should navigate to Add New Customer screen
	And I fill-up and Submit New Customer Details form
	Then I should see the created Customer Number in the Add New Customer Screen