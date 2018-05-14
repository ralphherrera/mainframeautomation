package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;
import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class PhoneBookMenuScreen {

	private static final Logger log = LogManager.getLogger(PhoneBookMenuScreen.class);

	private SessionDriver sessionDriver;
	private Scenario scenario;
	
	
	/* Screen Elements */
	private LabelField lbl_phoneBookMenuScreenName = new LabelField(1, 27, "TAMU  System  Directory");
	
	private LabelField txt_actionCode = new LabelField(11, 33);
	
	public PhoneBookMenuScreen() {
		// Default constructor
	}

	/* Page Methods */
	public boolean isPhoneBookMenuScreen() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_phoneBookMenuScreenName, lbl_phoneBookMenuScreenName.getLabelText())) {
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
		sessionDriver.sendInputTextToScreen(txt_actionCode, text);
	}
	
	/**
	 * @param sessionDriver the sessionDriver to set
	 */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
}
