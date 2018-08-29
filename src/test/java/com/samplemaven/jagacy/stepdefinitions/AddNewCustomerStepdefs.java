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
import com.samplemaven.jagacy.screens.WelcomeScreen;
import com.samplemaven.jagacy.utils.CommonActionsUtil;

import cucumber.api.java8.En;

public class AddNewCustomerStepdefs implements En {

	private static final Logger log = LogManager.getLogger(AddNewCustomerStepdefs.class);

	public AddNewCustomerStepdefs(ScenarioHooks hooks, WelcomeScreen welcomeScreen, MainMenuScreen mainMenuScreen, 
			HomeScreen homeScreen, CommandEntryScreen commandEntryScreen, AddNewCustomerScreen addNewCustomerScreen) {

		Given("^I am in the login screen$", () -> {
			welcomeScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Homescreen is displayed", welcomeScreen.isWelcomeScreenDisplayed(),
					is(equalTo(true)));
		});

		When("^I access the welcome screen$", () -> {
			welcomeScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			homeScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());

			welcomeScreen.inputText("Username", "SD24");
			welcomeScreen.inputText("Password", "SD24");
//			welcomeScreen.pressKey("Enter");
			welcomeScreen.pressEnterKey();
			homeScreen.pressKey("Enter");
			Assert.assertThat("Verify if Homescreen is displayed", homeScreen.isHomeScreenDisplayed(),
					is(equalTo(true)));		
			homeScreen.inputText("Unit Mnemonic", "UAT");
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
//			welcomeScreen.pressKey("Enter");
//			welcomeScreen.pressKey("Enter");
//			welcomeScreen.pressKey("Enter");
		});

		And("^I should navigate to Add New Customer screen", () -> {
			commandEntryScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			mainMenuScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());

			Assert.assertThat("Verify if Command Entry Screen is displayed", commandEntryScreen.isCommandEntryScreenDisplayed(),
					is(equalTo(true)));

			commandEntryScreen.inputText("Command", "WMENU1");
			welcomeScreen.pressEnterKey();
			mainMenuScreen.inputText("Menu Selection", "ANC");
			welcomeScreen.pressEnterKey();
		});

		And("^I fill-up and Submit New Customer Details form", () -> {
			addNewCustomerScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());

			welcomeScreen.pressEnterKey();
			addNewCustomerScreen.inputText("Customer Type", "AA");
			welcomeScreen.pressEnterKey();

			addNewCustomerScreen.inputText("Customer Full Name", "Automation Tester");
			addNewCustomerScreen.inputText("Customer Short Name", "Tester");
			addNewCustomerScreen.inputText("Default Branch", "@AFF");
			addNewCustomerScreen.inputText("Default Tax Reference", "00");
			addNewCustomerScreen.inputText("Interest Rate Adjustment", "T1");

			welcomeScreen.pressEnterKey();

			welcomeScreen.pressF24Key();

			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
			welcomeScreen.pressEnterKey();
		});

		Then("^I should see the created Customer Number in the Add New Customer Screen", () -> {
			commandEntryScreen.setSessionDriver(hooks.getSessionDriver(), hooks.getScenario());
			Assert.assertThat("Verify if Add New Customer Screen is displayed", addNewCustomerScreen.isAddNewCustomerScreenDisplayed(),
					is(equalTo(true)));
		});
	}

}
