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

		// print starting XX before every scenario
		Before((Scenario scenario) -> log.info("Starting scenario: " + scenario.getName()));

		// print ending XX after every scenario
		After((Scenario scenario) -> log.info("Ending scenario: " + scenario.getName()));

		After(() -> {
			try {
				log.info("Ending scenario: {}", scenario.getName());
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
}
