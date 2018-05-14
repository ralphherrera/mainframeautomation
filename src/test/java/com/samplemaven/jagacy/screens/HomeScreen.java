package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;
import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class HomeScreen {
	
	private static final Logger log = LogManager.getLogger(HomeScreen.class);

	private SessionDriver sessionDriver;
	private Scenario scenario;
	
	/* Screen Elements */
	private LabelField lbl_homeScreen = new LabelField(17, 6, "TEXAS A & M UNIVERSITY");

	private LabelField txt_homeScreen = new LabelField(23, 1);
	
	public HomeScreen() {
		// Default constructor
	}
	
	/* Page Methods */

	public boolean isHomeScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_homeScreen, lbl_homeScreen.getLabelText())) {
				log.info("Home screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		
		return false;
	}

	public void inputKeys(String text) {
		sessionDriver.sendInputTextToScreen(txt_homeScreen, text);
	}

	/**
	 * @param sessionDriver the sessionDriver to set
	 */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
}
