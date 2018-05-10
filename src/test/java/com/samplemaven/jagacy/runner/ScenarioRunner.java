package com.samplemaven.jagacy.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.samplemaven.jagacy.utils.PropertyUtil;

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
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"html:target/testresults/html", // test results as html
				"json:target/testresults/cucumber.json", // test results as json
				"junit:target/testresults/cucumber.xml" },
		monochrome = true) // test results as junit xml
public class ScenarioRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(PropertyUtil.getConfigProp("config.report.path")));
	}	
}
