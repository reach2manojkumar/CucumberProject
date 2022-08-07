package com.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassDef {

	// declare ThreadLocal for Global Declare
	public static WebDriver driver;
	Properties prop;

	public void setConfig() {
		// TODO Auto-generated method stub

		prop = new Properties();

		try {
			FileInputStream fip = new FileInputStream(
					"D:\\QA test\\LIVE PROJECT\\Cucumberproject\\com.project\\GlobaConfig\\config.properties");
			prop.load(fip);

		} catch (FileNotFoundException e) {
			System.out.println("File NOt Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Prop file not load to fileInput");
			e.printStackTrace();
		}

	}

	public void launchApp(String browserName,String url) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// Implicit TimeOuts
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		// PageLoad TimeOuts
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));

		// Launching the URL
		

	}

	public  void driclose() {
		// TODO Auto-generated method stub
		driver.close();

	}

}
