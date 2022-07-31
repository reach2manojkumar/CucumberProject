package com.project.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeaturesFile",glue="com.project.stepdefinition",monochrome = true,dryRun = false,plugin = { "pretty","html:target/cucumber-reports" },publish=true)
public class RunnerClass {

}
