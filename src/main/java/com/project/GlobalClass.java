package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalClass {

	public static WebDriver driver;
//		toloadconfigfile
	public static FileReader cfr;
	public static Properties prop1 = new Properties();

	


	public static Select toselect;

	public static void utiliesfileLoad() throws IOException {
		System.out.println("utilies file load Start");
		cfr = new FileReader(System.getProperty("user.dir") + "//GlobaConfig//config.properties");
		prop1.load(cfr);
		System.out.println("utilies file load end ");

	}

	public static void toselectBrowser(String urlname) throws IOException {
		// TODO Auto-generated method stu
		utiliesfileLoad();
		// condition to select Chrome browser
		if (prop1.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(urlname);
			driver.manage().window().maximize();
			Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(250)).ignoring(Throwable.class);

		}
		// condition to select firefox browser
		else if (prop1.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(urlname);
			Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(250)).ignoring(Throwable.class);
		}

	}

	public static void toQuit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public static void targetclick(WebElement tarele) throws InterruptedException {
		// TODO Auto-generated method stub

		tarele.click();
	}

	public static void targetsend(WebElement typetext, String textvalue) {
		// TODO Auto-generated method stub
		typetext.sendKeys(textvalue);
	}

	public static void todropDownbyindex(WebElement selwebelement, int position) {
		// TODO Auto-generated method stub
		toselect = new Select(selwebelement);
		toselect.selectByIndex(position);

	}

	public static void todropDowndeselect(WebElement selwebelement, int position) {
		// TODO Auto-generated method stub
		toselect = new Select(selwebelement);
		toselect.deselectAll();
	}

	public static String readforexceldata(int rownam, int cellnam, String filename, String sheetname)
			throws IOException {

		File linkfile = new File(
				"C:\\Users\\Manoj\\eclipse-workspace\\workspace\\furn.com\\src\\test\\resources\\data driven\\"
						+ filename + ".xlsx");

		FileInputStream inputFile = new FileInputStream(linkfile);

		Workbook excelWork = new XSSFWorkbook(inputFile);

		Sheet getsheet = excelWork.getSheet(sheetname);

//			Row holdrow = getsheet.getRow(rownam);
		Cell holdcell = getsheet.getRow(rownam).getCell(cellnam);

		CellType holdcelltype = holdcell.getCellType();

		Object result = null;
		switch (holdcelltype) {
		case STRING:
			System.out.println("String");
			result = holdcell.getStringCellValue();
			System.out.println(result.toString());

			break;

		case NUMERIC:
			System.out.println("number");
			if (DateUtil.isCellDateFormatted(holdcell)) {
				Date da = holdcell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("MMMM dd ,yyyy");
				result = sim.format(da);

			} else
				result = holdcell.getNumericCellValue();
			System.out.println(result.toString());

			break;

		default:
			System.out.println("not");
		}
		return result.toString();

	}

	public static String getcurtittle() {
		return driver.getTitle();

	}

	public static void toTakescreenshot(String filename) throws IOException {
		// TODO Auto-generated method stub

		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File fs = scrshot.getScreenshotAs(OutputType.FILE);
		File de = new File(
				"C:\\Users\\Manoj\\eclipse-workspace\\workspace\\furn.com\\screenshot//" + filename + ".png");
		FileUtils.copyFile(fs, de);
	}

	public static void waitAndexit(int timesleep) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(timesleep);
		driver.quit();

	}

}
