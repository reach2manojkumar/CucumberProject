package com.project.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClassDef {
	
	@Before
	public void beforeStp() {

		System.out.println("Test Case start");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After(order=1)
	public void afterStp() {
		// TODO Auto-generated method stub
		System.out.println("Test Case End");
		

	}
		@After(order=2)
		public void teardown (Scenario shot) {
			
			if(shot.isFailed()) {
				byte[] failscreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				if(failscreen!=null) {
					shot.attach(failscreen, "image/png",shot.getName());
				}}
			
				
				
			}
		}
	
