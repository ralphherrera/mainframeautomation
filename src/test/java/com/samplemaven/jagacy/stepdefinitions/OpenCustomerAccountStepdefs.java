package com.samplemaven.jagacy.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.samplemaven.jagacy.screens.AddNewCustomerScreen;
import com.samplemaven.jagacy.screens.CommandEntryScreen;
import com.samplemaven.jagacy.screens.HomeScreen;
import com.samplemaven.jagacy.screens.MainMenuScreen;
import com.samplemaven.jagacy.screens.OpenCustomerAccountScreen;
import com.samplemaven.jagacy.screens.WelcomeScreen;
import com.samplemaven.jagacy.utils.CommonActionsUtil;

import cucumber.api.java8.En;

public class OpenCustomerAccountStepdefs implements En {

	private static final Logger log = LogManager.getLogger(OpenCustomerAccountStepdefs.class);

	public OpenCustomerAccountStepdefs(ScenarioHooks hooks, WelcomeScreen welcomeScreen, MainMenuScreen mainMenuScreen, 
			HomeScreen homeScreen, CommandEntryScreen commandEntryScreen, AddNewCustomerScreen addNewCustomerScreen,
			OpenCustomerAccountScreen openCustomerAccountScreen) {


		And("I navigate to Add New Customer screen", () -> {
			commandEntryScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			mainMenuScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());

			Assert.assertThat("Verify if Command Entry Screen is displayed", commandEntryScreen.isCommandEntryScreenDisplayed(),
					is(equalTo(true)));

			commandEntryScreen.inputText("Command", "WMENU1");
			welcomeScreen.pressEnterKey();
			mainMenuScreen.inputText("Menu Selection", "OCA");
			welcomeScreen.pressEnterKey();
		});

		And("^I Fill-up Customer Search Screen", () -> {
			openCustomerAccountScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			openCustomerAccountScreen.inputText("Customer Number", "");
			openCustomerAccountScreen.inputText("Account Type", "EM");
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
			

		});

		Then("^I should see the customer details", () -> {
			openCustomerAccountScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Customer details is displayed", openCustomerAccountScreen.isCustomerDetailsDisplayed(),
					is(equalTo(true)));
		});
		
		Then("^I should not see the customer details", () -> {
			openCustomerAccountScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Customer details is displayed", openCustomerAccountScreen.isCustomerDetailsDisplayed(),
					is(equalTo(false)));
		});
	}

}
