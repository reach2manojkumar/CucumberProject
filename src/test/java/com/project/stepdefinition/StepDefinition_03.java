package com.project.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;
import com.project.pojoclass.PojoStepdef_03;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition_03 extends BaseClassDef {
	

	PojoStepdef_03 loco=new PojoStepdef_03();

	@Given("Flipkart product home page")
	public void flipkart_product_home_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loco =  new PojoStepdef_03();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[text()='✕']")).click();

		//click close of login pop dialog	
		WebElement loginclose = loco.getLoginclose();
		loginclose.click();
		
		WebElement searchtextbox = loco.getSearchtextbox();
		searchtextbox.sendKeys("apple"+Keys.ENTER);
		
		List<WebElement> listProduct = loco.getTittleprod();
		int si = listProduct.size();
		System.out.println(si);
		for (WebElement conProduct: listProduct) {
			
//			WebElement eachtittleprod = loco.getEachtittleprod();
			System.out.println(conProduct.getText());
			
//			System.out.println(eachtittleprod.getText());
		}
		 
	

	}

	@When("As customer,i want to search the specific product")
	public void as_customer_i_want_to_search_the_specific_product() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("type text that want to search product")
	public void type_text_that_want_to_search_product() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
