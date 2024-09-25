package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.FlightResultPage;

public class FlightresultTC extends Commondetails {
	Exceldata exceldata = new Exceldata();
	Logger logger = Logger.getLogger(FlightresultTC.class);

	@Test
	public void Flightresult() throws IOException, InterruptedException {
		// test=extentReports.createTest("Verify to FlightResultPage");

		// test.info("Selecting cabinclass and fare ");
		// test=extentReports.createTest("Selecting cabinclass and fare");
		logger.info("User is on Flightresult page");
		try {
			String cabinfare = System.getProperty("cabinfare");
			FlightResultPage.getFlightResultPage().Fareselecting(cabinfare);
			logger.info("User is Selected Cabinclass Fare for journey");
			FlightResultPage.getFlightResultPage().FlightContiune();
			// test.pass("Redirect to Passenger page");
			// test=extentReports.createTest("Redirect to Passenger page");
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
