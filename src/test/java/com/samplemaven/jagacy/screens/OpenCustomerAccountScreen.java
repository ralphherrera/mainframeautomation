package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;

public class OpenCustomerAccountScreen extends BaseScreen {
	private static final Logger log = LogManager.getLogger(OpenCustomerAccountScreen.class);

	/* Screen Elements */
	private LabelField lbl_openCustomerScreen = new LabelField(0, 31, "Open Customer Account");
	private LabelField lbl_customerNumber = new LabelField (2,28,"DC0762");
	private LabelField txt_customerNumber = new LabelField(6, 28);
	private LabelField txt_accountType = new LabelField(8, 28);
	
	
	public OpenCustomerAccountScreen() {
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
			labelField = lbl_openCustomerScreen;
			break;
		case "Customer Number":
			labelField = txt_customerNumber;
			break;
		case "Account Type":
			labelField = txt_accountType;
			break;
		case "Searched Customer Number":
			labelField = lbl_customerNumber;
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
		try {
			sessionDriver.inputTextToScreen(returnLabelElement(labelElement), textInput);
//			sessionDriver.waitForChange(DEFAULT_TIMEOUT);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean isOpenCustomerScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_openCustomerScreen, lbl_openCustomerScreen.getLabelText())) {
				log.info("Open Customer Screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}
	
	public boolean isCustomerDetailsDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_openCustomerScreen, lbl_openCustomerScreen.getLabelText())) {
				log.info("Open Customer Screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}

}