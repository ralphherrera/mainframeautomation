package com.samplemaven.jagacy.screens;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jagacy.util.JagacyException;
import com.samplemaven.jagacy.fields.LabelField;
import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class PhoneBookSearchScreen {

	private static final Logger log = LogManager.getLogger(PhoneBookSearchScreen.class);

	private SessionDriver sessionDriver;
	private Scenario scenario;
	
	/* Screen Elements */
	private LabelField lbl_phoneBookSearchScreenName = new LabelField(0, 18,
			"The Texas A&M University Directory System");

	private LabelField txt_lastName = new LabelField(19, 6);

	private LabelField txt_firstMiddleName = new LabelField(19, 47);

	public PhoneBookSearchScreen() {
		// Default constructor
	}
	
	/* Page Methods */

	public boolean isPhoneBookSearchScreen() {
		try {
			if (sessionDriver.waitForTextToAppear(lbl_phoneBookSearchScreenName, lbl_phoneBookSearchScreenName.getLabelText())) {
				log.info("PhoneBookSearchScreen is displayed");
				sessionDriver.getScreenshot(scenario);
				return true;
			}
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		return false;
	}

	public void inputKeys(String text) {
		sessionDriver.sendInputTextToScreen(txt_firstMiddleName, text);
	}

	public boolean areFacultyMembersInfoDisplayed(String query) {
		try {
			List<String> results = new ArrayList<>();
			for (int i = 5; i <= 15; i += 2) {
				log.debug("Search Result: {}", sessionDriver.readPosition(i, 2, 75));
				results.add(sessionDriver.readPosition(i, 2, 75));
			}
			for (String result : results) {
				if (result.toLowerCase().contains(query.toLowerCase())) {
					sessionDriver.getScreenshot(scenario);
					return true;
				}
			}
		} catch (JagacyException je) {
			log.error("Something went wrong {}", je);
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
		log.warn("No names found with search query {}", query);
		return false;
	}
	
	/**
	 * @param sessionDriver the sessionDriver to set
	 */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
}
