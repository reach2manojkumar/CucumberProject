package com.project.runnerclass;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import report.com.test.ReportGeneration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeaturesFile", glue = "com.project.stepdefinition", monochrome =true, dryRun = false,

		plugin = { "pretty", "html:report.com/HtmpReport", 
				"junit:report.com/testrep.xml",
				"json:report.com/reporttest.json" })
public class TestRunner {

	@AfterClass
	public static void afterReport() {
		// TODO Auto-generated method stub
		ReportGeneration.reportTestCase("D:\\QA test\\LIVE PROJECT\\Cucumberproject\\com.project\\report.com\\reporttest.json");
		
	}
}
