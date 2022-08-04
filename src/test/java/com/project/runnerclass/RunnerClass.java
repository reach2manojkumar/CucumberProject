package com.project.runnerclass;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import report.com.test.ReportGeneration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeaturesFile/loginpage.feature", glue = "com.project.stepdefinition", monochrome = false, dryRun = false,

		plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json" }, publish = true)

public class RunnerClass {

}
