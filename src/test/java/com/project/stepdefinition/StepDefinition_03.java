package com.project.stepdefinition;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.css.model.CSSStyleSheetHeader;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;
import com.project.pojoclass.PojoStepdef_03;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class StepDefinition_03 extends BaseClassDef {

	PojoStepdef_03 loco = new PojoStepdef_03();
	WebElement loginclose;
	WebElement searchtextbox;

	@Given("Flipkart product home page")
	public void flipkart_product_home_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loco = new PojoStepdef_03();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		WebElement loginclose = loco.getLoginclose();
		loginclose.click();
		// driver.findElement(By.xpath("//button[text()='✕']")).click();

		// click close of login pop dialog

	}

	@When("As customer,i want to search the specific product")
	public void as_customer_i_want_to_search_the_specific_product() {

		WebElement searchtextbox = loco.getSearchtextbox();
		searchtextbox.sendKeys("apple" + Keys.ENTER);

	}

	@When("type text that want to search product")
	public void type_text_that_want_to_search_product() {

		List<WebElement> li = loco.getTittleprod();

		int si = li.size();

		System.out.println(si);
//		
//		List<WebElement> listProduct2 = loco.getListProduct();
//
//		List<WebElement> pricetag = loco.getPricetag();
//
//		System.out.println(listProduct2.get(2));
//
//		int count = 0;
//
//		for (int i = 0; i < listProduct.size(); i++) {
//
//			String tittleprod = listProduct.get(i).getText();
//			String priceprod = pricetag.get(i).getText();
//
//			if (tittleprod.contains("iPhone 11")) {
//				System.out.println(tittleprod + "====" + priceprod);
//				count++;
//			}
//
//		}
//		System.out.println("No of Related to search =" + count);

	}

	@When("As customer,i want to search {string} the specific product")
	public void as_customer_i_want_to_search_the_specific_product(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		WebElement searchtextbox = loco.getSearchtextbox();
		searchtextbox.sendKeys(string);
		Thread.sleep(3000);

	}

	@Then("Validation {string} the Dropdown Suggestion")
	public void validation_the_dropdown_suggestion(String string) {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> sList = driver.findElements(By.xpath("//ul/li[contains(@class,'Y5N')]"));
		Map<Boolean, Integer> check = new HashMap<>();
		for (WebElement i : sList) {

			System.out.println(i.getText());
			System.out.println(i.getText().contains(string));
			boolean cont = i.getText().contains(string);
			if (check.containsKey(cont)) {
				Integer count = check.get(true);
				check.put(cont, count + 1);
			} else {
				check.put(cont, 1);
			}
//			flag=i.getText().contains(string);
		}

		Integer trueval = check.get(true);
		Integer falseval = check.get(false);
		System.out.println(" value counte " + trueval + " " + falseval);
		sList.get(3).click();

	}

	@Given("User  want to scroll Down and click")
	public void user_want_to_scroll_down_and_click() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loco = new PojoStepdef_03();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
//		Thread.sleep(5000);
		WebElement loginclose = loco.getLoginclose();
		loginclose.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,550)", "");
	       Thread.sleep(5000);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user want to scroll up by using page up key")
	public void user_want_to_scroll_up_by_using_page_up_key() {
		// Write code here that turns the phrase above into concrete actions
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(5000);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("verify whether login button is visible")
	public void verify_whether_login_button_is_visible() {
		// Write code here that turns the phrase above into concrete actions
		boolean dis = driver.findElement(By.className("exehdJ")).isDisplayed();
		System.out.println(dis);
//	    throw new io.cucumber.java.PendingException();
	}
}
