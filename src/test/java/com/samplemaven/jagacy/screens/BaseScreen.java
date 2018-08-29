package com.samplemaven.jagacy.screens;

import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;

public class BaseScreen {
	
	protected SessionDriver sessionDriver;
	protected Scenario scenario;
	protected static final int DEFAULT_TIMEOUT = 5000;
	
	 /**
	  * @param sessionDriver - sessionDriver the sessionDriver to set Jagacy
	  * @param scenario - 
	  */
	public void setSessionDriver(SessionDriver sessionDriver, Scenario scenario) {
		this.sessionDriver = sessionDriver;
		this.scenario = scenario;
	}
}
