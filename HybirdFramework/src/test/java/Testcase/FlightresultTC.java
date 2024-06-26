package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.FlightResultPage;

public class FlightresultTC extends Commondetails {
	Exceldata exceldata ;
	
	@Test
	public void Flightresult() throws IOException, InterruptedException {
		test=extentReports.createTest("Verify to FlightResultPage");
		 exceldata=new Exceldata();
		
		FlightResultPage page=	PageFactory.initElements(driver, FlightResultPage.class);
		test.info("Selecting cabinclass and fare ");
		
		page.Fareselecting(exceldata.getstringdata("Sheet1", 11, 1));
		page.FlightContiune();
		test.pass("Redirect to Passenger page");
	}
}
