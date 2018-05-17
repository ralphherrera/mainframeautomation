@phonebooksearch
Feature: Phonebook Search
  As a User
  I should be able to search for other members in the phonebook
  So I can contact them

  @sample
  Scenario: Search faculty number using first or middle name
  	Given I am in the homescreen
  	When I access phonebook screen
  	And I search for faculty member using first or middle name
  	Then I should see the results relevant to my search criteria
  	
  @sample
  Scenario: Search faculty number using first or middle name
  	Given I am in the homescreen
  	When I access phonebook screen
  	And I search for faculty member using first or middle name
  	Then I should see the results relevant to my search criteria
  	
  @sample
  Scenario: Search faculty number using first or middle name
  	Given I am in the homescreen
  	When I access phonebook screen
  	And I search for faculty member using first or middle name
  	Then I should see no results