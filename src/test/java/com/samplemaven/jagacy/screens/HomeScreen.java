package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;

public class HomeScreen extends BaseScreen {

	private static final Logger log = LogManager.getLogger(HomeScreen.class);

	/* Screen Elements */
	private LabelField lbl_homeScreen = new LabelField(0, 19, "KAPITI SYSTEM SIGN-ON");

	private LabelField txt_unitMnemonic = new LabelField(5, 32);

	public HomeScreen() {
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
			labelField = lbl_homeScreen;
			break;
		case "Unit Mnemonic":
			labelField = txt_unitMnemonic;
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
	 * @param key - Equivalent Keyboard mapping
	 */
	public void pressKey(String key) {
		sessionDriver.pressKey(key);
	}

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

}