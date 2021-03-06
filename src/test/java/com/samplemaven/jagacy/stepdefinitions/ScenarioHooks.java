package com.samplemaven.jagacy.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samplemaven.jagacy.utils.SessionDriver;

import cucumber.api.Scenario;
import cucumber.api.java8.En;

public class ScenarioHooks implements En {

	private static final Logger log = LogManager.getLogger(ScenarioHooks.class);

	private SessionDriver sessionDriver;
	private Scenario scenario;
	
	public ScenarioHooks() {

		Before((Scenario scenario) -> {
			try {
				System.setProperty("jagacy.properties.dir", "src/test/resources");
				System.setProperty("test.window", "true");

				this.scenario = scenario;
				
				log.info("Starting scenario: {}", scenario.getName());

				sessionDriver = new SessionDriver("test");
				sessionDriver.open();
			} catch (Exception e) {
				log.error("Something went wrong {} ", e);
			}
		});

		After(0, () -> {
			try {
				log.info("Ending scenario: {}", scenario.getName());
				if (scenario.isFailed()) {
					sessionDriver.getScreenshot(scenario);
				}
				sessionDriver.close();
				sessionDriver = null;
			} catch (Exception e) {
				log.error("Cannot close session instance: {}", e);
			}
		});
		
	}
	
	/**
	 * @return the sessionDriver
	 */
	public SessionDriver getSessionDriver() {
		return sessionDriver;
	}
	
	/**
	 * @return the scenario
	 */
	public Scenario getScenario() {
		return scenario;
	}
}
