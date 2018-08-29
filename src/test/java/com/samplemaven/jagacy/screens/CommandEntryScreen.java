package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;

public class CommandEntryScreen extends BaseScreen {

	private static final Logger log = LogManager.getLogger(CommandEntryScreen.class);

	/* Screen Elements */
	private LabelField lbl_screenHeader = new LabelField(0, 33, "Command Entry");
	private LabelField txt_command = new LabelField(17, 6);

	public CommandEntryScreen() {
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
			labelField = lbl_screenHeader;
			break;
		case "Command":
			labelField = txt_command;
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
	
	public boolean isCommandEntryScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_screenHeader, lbl_screenHeader.getLabelText())) {
				log.info("Command Entry Screen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}

		return false;
	}

}
