package com.samplemaven.jagacy.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Runner to execute all Cucumber features
@RunWith(Cucumber.class)
@CucumberOptions(
		// tags = {"@ComponentA, @BigFunctionalArea, @FunctionPoint1, @sample"}, //run
		// tagged features at all levels
		tags = { "@phonebooksearch" }, // run a single scenario while developing or troubleshooting
		features = { "src/test/resources/features" }, // feature file path
		glue = { "com.samplemaven.jagacy.stepdefinitions" }, // step definition package
		plugin = { "pretty",
				"html:target/testresults/html", // test results as html
				"json:target/testresults/cucumber.json", // test results as json
				"junit:target/testresults/cucumber.xml" },
		monochrome = true) // test results as junit xml
public class ScenarioRunner {
	// Leave empty
	
}
