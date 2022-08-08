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
		// driver.findElement(By.xpath("//button[text()='✕']")).click();

		// click close of login pop dialog
		
	}

	@When("As customer,i want to search the specific product")
	public void as_customer_i_want_to_search_the_specific_product() {
		
		WebElement loginclose = loco.getLoginclose();
		loginclose.click();

		WebElement searchtextbox = loco.getSearchtextbox();
		searchtextbox.sendKeys("apple" + Keys.ENTER);


		
	}

	@When("type text that want to search product")
	public void type_text_that_want_to_search_product() {
		

		List<WebElement> listProduct = loco.getTittleprod();
		int si = listProduct.size();
		
		System.out.println(si);
		
		List<WebElement> listProduct2 = loco.getListProduct();

		List<WebElement> pricetag = loco.getPricetag();

		System.out.println(listProduct2.get(2));

		int count = 0;

		for (int i = 0; i < listProduct.size(); i++) {

			String tittleprod = listProduct.get(i).getText();
			String priceprod = pricetag.get(i).getText();

			if (tittleprod.contains("iPhone 11")) {
				System.out.println(tittleprod + "====" + priceprod);
				count++;
			}

		}
		System.out.println("No of Related to search =" + count);

		
	}
}
