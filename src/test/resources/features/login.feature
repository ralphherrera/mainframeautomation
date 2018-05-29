@login
Feature: Login
  As a User
  I should be able to login and see the main menu screen
  So perform my task

	@sample
  Scenario: Verify Main Menu Screen is displayed
  	Given I am in the welcome screen
  	When I access the main menu screen
  	Then I should see list of application functions
  	