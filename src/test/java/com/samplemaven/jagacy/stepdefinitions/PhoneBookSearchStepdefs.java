package com.samplemaven.jagacy.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

import com.samplemaven.jagacy.screens.HomeScreen;

import cucumber.api.java8.En;

public class PhoneBookSearchStepdefs implements En {

	public PhoneBookSearchStepdefs(ScenarioHooks hooks, HomeScreen homeScreen) {

		Given("^I am in the homescreen$", () -> {
			homeScreen.setSessionDriver(hooks.getSessionDriver());
			Assert.assertThat("Verify if Homescreen is displayed", homeScreen.isHomeScreenDisplayed(), is(equalTo(true)));
		});

		When("^I access phonebook screen$", () -> {
			homeScreen.inputKeys("PHONBOOK");
		});

		And("^I search for faculty member using first or middle name$", () -> {

		});

		Then("^I should see the results relevant to my search criteria$", () -> {

		});

	}
}
