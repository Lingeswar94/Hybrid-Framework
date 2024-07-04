package Commonfunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;

import TestPage.PassengerPage;

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
	public void MainPassenger(String Adtitle) {
		Select select = new Select(PassengerPage.Title);
		select.selectByValue(Adtitle);
	}
	public void adultPaxfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	public void adultPaxlastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void adultmobileno(String mobile) {
		mobileno.sendKeys(mobile);
	}
	public void adultmail(String mail) {
		email.sendKeys(mail);
	}
	public void adultconmail(String conmail) {
		confrmemail.sendKeys(conmail);
	}
	public void adultRes(String Res) {
		Residential.sendKeys(Res);
	}

	
}
