package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;
import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class WelcomeScreen {

	private static final Logger log = LogManager.getLogger(WelcomeScreen.class);
	
	private SessionDriver sessionDriver;
	private Scenario scenario;

	/* Screen Elements */
	private LabelField lbl_welcomeScreen = new LabelField(0, 9, "Welcome to PUB400.COM");
	
	private LabelField txt_username = new LabelField(4, 24);
	
	private LabelField txt_password = new LabelField(5, 24);
	
	public WelcomeScreen() {
		// Default constructor
	}
	
	/* Page Methods */
	
	/***
	 * 
	 * @return
	 */
	public boolean isWelcomeScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_welcomeScreen, lbl_welcomeScreen.getLabelText())) {
				log.info("Home screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}
	
	/***
	 * 
	 * @param username
	 */
	public void enterUsername(String username) {
		sessionDriver.sendInputTextToScreen(txt_username, username);
	}
	
	/***
	 * 
	 * @param username
	 */
	public void enterPassword(String password) {
		sessionDriver.sendInputTextToScreen(txt_password, password);
	}
	
	/**
	 * @param sessionDriver the sessionDriver to set
	 */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
}
