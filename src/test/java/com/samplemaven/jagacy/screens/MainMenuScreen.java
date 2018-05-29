package com.samplemaven.jagacy.screens;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;
import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class MainMenuScreen {
	private static final Logger log = LogManager.getLogger(MainMenuScreen.class);

	private SessionDriver sessionDriver;
	private Scenario scenario;
	
	/* Screen Elements */
	
	private LabelField lbl_mainMenuScreen = new LabelField(0, 32, "IBM i Main Menu");
	
	private LabelField txt_menuCommand = new LabelField(19, 6);
	
	public MainMenuScreen() {
		// Default constructor
	}
	
	/* Page Methods */
	
	/**
	 * @param sessionDriver the sessionDriver to set
	 */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
	
	public boolean isMainMenuScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_mainMenuScreen, lbl_mainMenuScreen.getLabelText())) {
				log.info("MainMenuScreen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}
	
	public boolean areMainMenuOptionsDisplayed() {
		try {
			List<String> menuOptions = new ArrayList<>();
			for (int i = 4; i <= 16; i++) {
				log.debug("Options{}", sessionDriver.readPosition(i, 5, 37));
				menuOptions.add(sessionDriver.readPosition(i, 2, 75));
			}
			
			if (!menuOptions.isEmpty()) {
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}
	
	public void logout() {
		sessionDriver.sendInputTextToScreen(txt_menuCommand, "90");
	}
}
