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
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	// instance varible
	public static Properties prop;

	public static WebDriver getDriver() {

		// Get from ThreadLocal
		return driver.get();
	}

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

	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		// PageLoad TimeOuts
		getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));

		// Launching the URL

	}

	public  static void driclose() {
		// TODO Auto-generated method stub
		((WebDriver) driver).quit();

	}

}
