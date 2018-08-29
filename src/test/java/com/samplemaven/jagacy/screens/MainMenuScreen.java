package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;

public class MainMenuScreen extends BaseScreen {
	private static final Logger log = LogManager.getLogger(MainMenuScreen.class);

	/* Screen Elements */
	private LabelField lbl_mainMenuScreen = new LabelField(0, 32, "E Q U A T I O N");

	private LabelField txt_menuSelection = new LabelField(20, 16);

	public MainMenuScreen() {
		// Default constructor
	}

	/* Page Methods */
	/**
	 * @param element
	 * @return LabelField element which depends on the @param element String
	 */
	public LabelField returnLabelElement (String element) {
		LabelField labelField;
		
		switch (element) {
		case "Header Name":
			labelField = lbl_mainMenuScreen;
			break;
		case "Menu Selection":
			labelField = txt_menuSelection;
			break;

		default:
			labelField = null;
		}
		return labelField;
	}
	
	/**
	 * @param labelElement
	 * @param textInput - Sends test data value to specified label element
	 */
	public void inputText(String labelElement, String textInput) {
		sessionDriver.inputTextToScreen(returnLabelElement(labelElement), textInput);
	}
	
	/***
	 * @param key
	 */
	public void pressKey(String key) {
		try {
			sessionDriver.pressKey(key);
			sessionDriver.waitForChange(DEFAULT_TIMEOUT);
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
	}
	
	public boolean isMainMenuScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_mainMenuScreen, lbl_mainMenuScreen.getLabelText())) {
				log.info("Main Menu Screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}

}