package Commonfunction;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.Method;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestPage.AddonPage;
import TestPage.FlightResultPage;
import TestPage.PassengerPage;
import TestPage.PaymentPage;
import TestPage.SearchPage;
import TestPage.ThanksPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Commondetails {

	public static Properties properties;
	public static WebDriver driver;
	public static Exceldata exceldata;

	Logger logger = Logger.getLogger(Commondetails.class);

	public Properties loadbrowser() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./Config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	@BeforeSuite
	public void ChooseBrowser() throws IOException {

		PropertyConfigurator.configure("./Config/Log4j.properties");
		logger.info("LinkAirway NormalFlow Automation Started");
		loadbrowser();
		logger.info("Application is going to execute");
		String url = properties.getProperty("URL");
		String browser = properties.getProperty("Browser");
		logger.info("Application moved to Selecting Browser for execute ");
		if (Commondetails.getDriver() == null) {

			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Application has selected :" + browser);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Application has selected :" + browser);
			} else if (browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				logger.info("Application has selected :" + browser);
			} else {
				System.out.println("Not ");
				logger.info("Application hasn't selected browser ");
			}

			Helper.initElement();
		}

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initElement() {
		PageFactory.initElements(Commondetails.getDriver(), SearchPage.getSearchPage());
		PageFactory.initElements(Commondetails.getDriver(), FlightResultPage.getFlightResultPage());
		PageFactory.initElements(Commondetails.getDriver(), PassengerPage.getPassengerPage());
		PageFactory.initElements(Commondetails.getDriver(), AddonPage.getAddonPage());
		PageFactory.initElements(Commondetails.getDriver(), PaymentPage.getPaymentPage());
		PageFactory.initElements(Commondetails.getDriver(), ThanksPage.getThanksPage());
	}

	

	@AfterSuite
	public void tearDownReport() {

		driver.quit();
		logger.info("LinkAirways Automation booking was successfully executed ");

	}
}
