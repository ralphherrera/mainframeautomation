package com.samplemaven.jagacy.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

import com.samplemaven.jagacy.screens.HomeScreen;
import com.samplemaven.jagacy.screens.PhoneBookMenuScreen;
import com.samplemaven.jagacy.screens.PhoneBookSearchScreen;

import cucumber.api.java8.En;

public class PhoneBookSearchStepdefs implements En {

	public PhoneBookSearchStepdefs(ScenarioHooks hooks, HomeScreen homeScreen, PhoneBookMenuScreen phoneBookMenuScreen,
			PhoneBookSearchScreen phoneBookSearchScreen) {

		Given("^I am in the homescreen$", () -> {
			homeScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Homescreen is displayed", homeScreen.isHomeScreenDisplayed(),
					is(equalTo(true)));
		});

		When("^I access phonebook screen$", () -> {
			phoneBookMenuScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			
			homeScreen.inputKeys("PHONBOOK");
			
			Assert.assertThat("Verify if PhoneBookMenuScreen is displayed", phoneBookMenuScreen.isPhoneBookMenuScreen(),
					is(equalTo(true)));
			phoneBookMenuScreen.inputKeys("F");
		});

		And("^I search for faculty member using first or middle name$", () -> {
			phoneBookSearchScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if PhoneBookSearchScreen is displayed",
					phoneBookSearchScreen.isPhoneBookSearchScreen(), is(equalTo(true)));
			phoneBookSearchScreen.inputKeys("RALPH");
		});

		Then("^I should see the results relevant to my search criteria$", () -> 
			Assert.assertThat("Verify if results displayed is relevant to the search query", 
					phoneBookSearchScreen.areFacultyMembersInfoDisplayed("RALPH"), is(equalTo(true))));

	}
}
