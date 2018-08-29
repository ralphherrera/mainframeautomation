package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jagacy.Key;
import com.samplemaven.jagacy.fields.LabelField;

public class WelcomeScreen extends BaseScreen {

	private static final Logger log = LogManager.getLogger(WelcomeScreen.class);

	/* Screen Elements */
	private LabelField lbl_system = new LabelField(1, 69, "SEAWOLF");
	
	private LabelField txt_username = new LabelField(5, 52);
	
	private LabelField txt_password = new LabelField(6, 52);
	
	public WelcomeScreen() {
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
		case "System Name":
			labelField = lbl_system;
			break;
		case "Username":
			labelField = txt_username;
			break;
		case "Password":
			labelField = txt_password;
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

	/***
	 * @return
	 */
	public boolean isWelcomeScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_system, lbl_system.getLabelText())) {
				log.info("Home screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}
	
	public void pressEnterKey() {
		try {
			sessionDriver.writeKey(Key.ENTER);
			sessionDriver.waitForChange(DEFAULT_TIMEOUT);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void pressF24Key() {
		try {
			sessionDriver.writeKey(Key.PF24);
			sessionDriver.waitForChange(DEFAULT_TIMEOUT);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
