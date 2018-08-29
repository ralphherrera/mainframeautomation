package com.samplemaven.jagacy.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.fields.LabelField;

public class AddNewCustomerScreen extends BaseScreen {
	private static final Logger log = LogManager.getLogger(AddNewCustomerScreen.class);

	/* Screen Elements */
	private LabelField lbl_addNewCustomerScreen = new LabelField(0, 33, "Add New Customer");
	private LabelField txt_customerType = new LabelField(3, 28);
	private LabelField txt_customerFullName = new LabelField(5, 28);
	private LabelField txt_customerShortName = new LabelField(6, 28);
	private LabelField txt_defaultBranch = new LabelField(9, 28);
	private LabelField txt_defaultTaxReference = new LabelField(13, 28);
	private LabelField txt_interestRateAdjustment = new LabelField(13, 31);
	
	
	public AddNewCustomerScreen() {
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
			labelField = lbl_addNewCustomerScreen;
			break;
		case "Customer Type":
			labelField = txt_customerType;
			break;
		case "Customer Full Name":
			labelField = txt_customerFullName;
			break;
		case "Customer Short Name":
			labelField = txt_customerShortName;
			break;
		case "Default Branch":
			labelField = txt_defaultBranch;
			break;
		case "Default Tax Reference":
			labelField = txt_defaultTaxReference;
			break;
		case "Interest Rate Adjustment":
			labelField = txt_interestRateAdjustment;
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
	
	public boolean isAddNewCustomerScreenDisplayed() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_addNewCustomerScreen, lbl_addNewCustomerScreen.getLabelText())) {
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