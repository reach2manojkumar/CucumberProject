package com.project.Action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.Destination;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.css.CSS.TakeCoverageDeltaResponse;
import org.openqa.selenium.interactions.Actions;

import com.project.BaseClassDef;
import com.project.ActionClass.ActionInterface;

import gherkin.formatter.Argument;

public class ActionClassload extends BaseClassDef implements ActionInterface {

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", ele);
	}

	@Override
	public void click(WebDriver driver, WebElement ele) {
		// Click action
		Actions act = new Actions(driver);
		act.click(ele);

	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		// Mouse over element
		Actions act = new Actions(driver);
		act.moveToElement(element);

	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		// TODO Auto-generated method stub

//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";
//
//		try {
//			FileUtils.copyFile(source, new File(destination));
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		// This new path for jenkins
//		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
//				+ dateName + ".png";
//		return newImageString;

		String dataname = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "-" + dataname + ".png";
		try {
			FileUtils.copyDirectory(source, new File(destination));
		} catch (Exception e) {
			System.out.println("File not load");
		}

		return destination;
	}

	@Override
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		String dateCur = new SimpleDateFormat("yyyymmdd-hhmm").format(new Date());
		return dateCur;
	}

	@Override
	public int getColumncount(WebElement row) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int getRowCount(WebElement table) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String takCurrentURL(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		
		return currentUrl;
	}

	public boolean CheckCurrentURL(WebDriver driver,String ExpUrl) {
		String currentUrl = driver.getCurrentUrl();
	
		if(currentUrl.contains(ExpUrl)) {
			return true;
		}
		return false;
	}

	@Override
	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean type(WebElement ele, String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement locator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Alert(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean click1(WebElement locator, String locatorName) {
		// TODO Auto-generated method stub
		return false;
	}

}
