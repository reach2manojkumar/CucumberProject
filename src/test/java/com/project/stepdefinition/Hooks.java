package com.project.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClassDef {
	
	@Before
	public void beforeStp() {

		System.out.println("Test Case start");

	}

	@After(order=2)
	public void afterStp() {
		// TODO Auto-generated method stub
		System.out.println("Test Case End");
		

	}
	@After(order=1)
	public void aftersec() {
		// TODO Auto-generated method stub
		System.out.println("close");
	}
}
