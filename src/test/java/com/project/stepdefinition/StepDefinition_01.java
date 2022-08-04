package com.project.stepdefinition;


import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.BaseClassDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition_01 extends BaseClassDef {

	WebDriver driver; // instance variable declare
	WebElement username;// login page -->username
	WebElement password;
	WebElement logWarn; // wrong password -->warning msg

	@Given("Open the chrome as login page")
	public void open_the_chrome_as_login_page() {
		// Pre-requirement config
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://adactinhotelapp.com/");
	}

	@Given("verify whether loaded page is correct or not")
	public void verify_whether_loaded_page_is_correct_or_not() {
		boolean flag = false;
		try {

			String curTitle = driver.getTitle();
			WebElement logImg = driver.findElement(By.xpath("//img[contains(@alt,'AdactIn Group')]"));
			flag = true;

		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			if (flag) {

				assertTrue(flag);
				System.out.println("Page Loads");
			} else {

				System.out.println("Page Not moved to login page");
			}

		}
	}

	@When("As user give invalid {string} and valid {string}")
	public void as_user_give_invalid_and_valid(String string, String string2) {
		username = driver.findElement(By.id("username"));
		username.sendKeys(string);
		password = driver.findElement(By.id("password"));
		password.sendKeys(string2);
		
	}

	@When("Click the login botton")
	public void click_the_login_botton() {
		WebElement logBtn = driver.findElement(By.xpath("//*[contains(@value,'Login')]"));
		logBtn.click();
	}

	@Then("Verify Warning text is present or not")
	public void verify_warning_text_is_present_or_not() {

		try {
			String curTittle = driver.getTitle();

			if (curTittle.contains("Adactin.com - Search Hotel")) {
				assumeTrue("valid login credentials", true);
				System.out.println("valid login credentials ");

			} else if (curTittle.contains("Hotel Reservation System")) {
				driver.findElement(By
						.xpath("//*[contains(text(),'Invalid Login details or Your Password might have expired. ')]"));
				System.out.println(" Invalid login credentials");
			} else {

				System.out.println("Page not found");

			}
		} catch (Exception e) {
			System.out.println("exception occur");

		}
	}

	@Then("Check the whether it redirected to loginpage or not")
	public void check_the_whether_it_redirected_to_loginpage_or_not() {

		String curTittle = driver.getTitle();
		String curUrl = driver.getCurrentUrl();

		if ((curTittle.contains("Adactin.com - Search Hotel")) && (curUrl.contains("SearchHotel.php"))) {
			System.out.print("In Hotel search page ");
		} else if ((curTittle.contains("Hotel Reservation System"))
				&& (curUrl.contains("http://adactinhotelapp.com/"))) {
			System.out.print("In login page ");
		}

	}

	// Blank text box verify and validatation

	@When("As user give blank {string} and valid {string}")
	public void as_user_give_blank_and_valid(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("username ");
	}

	@Then("close the webpage")
	public void close_the_webpage() {
		driver.quit();
	}

}
