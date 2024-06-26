package Commonfunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;

public class RoughNote {
	WebDriver driver;

	/*
	 * public void tearDown(ITestResult result) { if (result.getStatus() ==
	 * ITestResult.FAILURE) { try { String screenshotPath =
	 * Helper.getScreenshot(driver, result.getName()); test.log(Status.FAIL,
	 * "Test Failed. Screenshot captured: " +
	 * test.addScreenCaptureFromPath(screenshotPath)); test.log(Status.FAIL,
	 * "Test Failed: " + result.getThrowable()); } catch (IOException e) {
	 * e.printStackTrace(); } } else if (result.getStatus() == ITestResult.SUCCESS)
	 * { try { String screenshotPath = Helper.getScreenshot(driver,
	 * result.getName()); test.log(Status.PASS, "Test Passed. Screenshot captured: "
	 * + test.addScreenCaptureFromPath(screenshotPath)); } catch (IOException e) {
	 * e.printStackTrace(); } } else if (result.getStatus() == ITestResult.SKIP) {
	 * test.log(Status.SKIP, "Test Skipped: " + result.getThrowable()); }
	 * 
	 * if (driver != null) { driver.quit(); } }
	 * 
	 * @AfterSuite public void tearDownReport() { extent.flush(); } }
	 */

	public void name() {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path="./Screenshot/SkipTest.png";
			FileHandler.copy(file, new File(path));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
