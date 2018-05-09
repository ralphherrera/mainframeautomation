package com.samplemaven.jagacy.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;
import com.samplemaven.jagacy.fields.LabelField;

public class SessionDriver extends Session3270 {
	
	private static final Logger log = LogManager.getLogger(SessionDriver.class);
	private static final int DEFAULT_TIMEOUT = 5000;
	
	public SessionDriver(String session) throws JagacyException {
		super(session);
	}
	
	/**
	 * @param labelField
	 * @param text
	 * @return True if text is displayed, False if text is not displayed
	 */
	public boolean waitForTextToAppear(LabelField labelField, String text) {
		try {
			log.info("Getting value at row [{}] and column [{}]", labelField.getRow(), labelField.getColumn());
			if (waitForPosition(labelField.getRow(), labelField.getColumn(), labelField.getLabelText(), DEFAULT_TIMEOUT)) {
				log.info("Found text [{}]", getTextFromScreen(labelField, text));
				return true;
			}
		} catch (JagacyException je) {
			log.error("Somthing went wrong {}", je);
		} catch (Exception e) {
			log.error("Somthing went wrong {}", e);
		} 
		log.warn("Text is not found in the screen");
		return false;
	}
	
	/**
	 * @param labelField
	 * @param text
	 * @return String from specified Lable row and Lable column
	 * @throws JagacyException
	 */
	public String getTextFromScreen(LabelField labelField, String text) throws JagacyException {
		return readPosition(labelField.getRow(), labelField.getColumn(), text.length());
	}
	
	/**
	 * @param labelField
	 * @param text
	 * @param sc
	 */
	public void sendInputTextToScreen(LabelField labelField, String text) {
		try {
			writePosition(labelField.getRow(), labelField.getColumn(), text);
			writeKey(Key.ENTER);
			waitForChange(DEFAULT_TIMEOUT);
		} catch (JagacyException je) {
			log.error("Unable to get the text. {}", je);
		} catch (Exception e) {
			log.error("Something went wrong. {}", e);
		}
	}
}
