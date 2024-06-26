package Commonfunction;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commondetails {

	public static Properties properties;
	public static WebDriver driver;
	public static Exceldata exceldata;
	public static ExtentSparkReporter Reporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;

	public Properties loadbrowser() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./Config/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	@BeforeSuite
	public void ChooseBrowser() throws IOException {

		loadbrowser();

		String url = properties.getProperty("URL");
		String browser = properties.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.driver.chrome",
			// properties.getProperty("Path"));
			driver = new ChromeDriver();

		} else {
			System.out.println("Not ");
		}

		driver.navigate().to(url);
		driver.manage().window().maximize();
		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void Excelstringdata() throws IOException {

		exceldata = new Exceldata();
		Reporter = new ExtentSparkReporter(
				new String(System.getProperty("user.dir") + "/Reports/FCProject " + Helper.getCurrenttime() + ".html"));
		Reporter.config().setDocumentTitle("Automation Test Report");
		Reporter.config().setReportName("FC Normal Flow Project");
		Reporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(Reporter);
		extentReports.setSystemInfo("Environment", "QA");

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException, AWTException {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			String screenshotPath = Helper.getscreenshotcapture(driver, result.getTestName());
			test.log(Status.PASS, "Test Passed: Screenshot capture",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = Helper.getFailscreenshot(driver, result.getTestName());
			test.log(Status.FAIL, "Test Failed: Screenshot capture",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else if (result.getStatus() == ITestResult.SKIP) {

			String screenshotPath = Helper.getskipScreenshot(driver, result.getTestName());
			test.log(Status.SKIP, "Test Skiped: Screenshot capture",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
		extentReports.flush();
	}
	
	@AfterSuite
	public void tearDownReport() {

		driver.quit();
		
	}
}
