package com.samplemaven.jagacy.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

import com.samplemaven.jagacy.screens.MainMenuScreen;
import com.samplemaven.jagacy.screens.WelcomeScreen;

import cucumber.api.java8.En;

public class LoginStepdefs implements En {

	public LoginStepdefs(ScenarioHooks hooks, WelcomeScreen welcomeScreen, MainMenuScreen mainMenuScreen) {

		Given("^I am in the welcome screen$", () -> {
			welcomeScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Homescreen is displayed", welcomeScreen.isWelcomeScreenDisplayed(),
					is(equalTo(true)));
		});

		When("^I access the main menu screen$", () -> {
			mainMenuScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			welcomeScreen.enterUsername("USER0100");
			welcomeScreen.enterPassword("user0100");
		});

		Then("^I should see list of application functions$", () -> {
			Assert.assertThat("Verify if Main Menu Screen is displayed", mainMenuScreen.isMainMenuScreenDisplayed(),
					is(equalTo(true)));
			Assert.assertThat("Verify if Main Menu Options is displayed", mainMenuScreen.areMainMenuOptionsDisplayed(),
					is(equalTo(true)));
			mainMenuScreen.logout();
		});

	}
}
