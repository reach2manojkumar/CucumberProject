package com.project.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.Action.ActionClassload;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition_02 extends ActionClassload {
	WebDriver driver;

	@Given("Open the webpage in Hotel search page")
	public void open_the_webpage_in_hotel_search_page(DataTable d ) {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("http://adactinhotelapp.com/");
		  
		 WebElement username = driver.findElement(By.id("username")); 
		 WebElement password = driver.findElement(By.id("password")); 
		 List<String> getvalue =d.asList(); 
		 username.sendKeys(getvalue.get(0));
		 
		 password.sendKeys(getvalue.get(1));
		 driver.findElement(By.id("login")).click();
		 
	   
	}

	

	@Given("check whether it present in search page or not")
	public void check_whether_it_present_in_search_page_or_not() {

		// Write code here that turns the phrase above into concrete actions

		if (CheckCurrentURL(driver,"SearchHotel")) {
			Assert.assertTrue("pass", true);
		} else {
			Assert.assertFalse("Fail", true);
		}

	}

	@When("verify whether logout button is Display or not")
	public void verify_whether_logout_button_is_display_or_not() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		WebElement lg = driver.findElement(By.xpath("//a[text()='Logout']"));
		String lgtext = lg.getText();
		System.out.println(lgtext);
		if (lgtext.contains("Logout")) {
			Assert.assertTrue("logout button is found", true);
		} else {
			Assert.assertTrue("logout button is NOT found", false);
		}

	}

	@Then("Click the logout button")
	public void click_the_logout_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
	}

	@Then("verify the After logout is direct to home page")
	public void verify_the_after_logout_is_direct_to_home_page() {

		WebElement logoutpage = driver
				.findElement(By.xpath("//td[contains(text(),\"You have successfully logged out. \")]"));
		CheckCurrentURL(driver, "Logout");

	}

}
