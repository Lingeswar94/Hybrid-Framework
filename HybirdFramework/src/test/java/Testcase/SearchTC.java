package Testcase;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.SearchPage;

public class SearchTC extends Commondetails {

	@Test
	public void Startpage() throws IOException {

		// test.log(Status.INFO, "LinkAirways application up and Running :");

		//test = extentReports.createTest("Verify to SearchFlight Page");
		exceldata = new Exceldata();
		SearchPage page = PageFactory.initElements(driver, SearchPage.class);

		page.Tripselection(exceldata.getstringdata("Sheet1", 0, 1));
		page.departureroute(exceldata.getstringdata("Sheet1", 1, 1));
		page.arrivalroute(exceldata.getstringdata("Sheet1", 2, 1));
	//	page.DateSelection(exceldata.getstringdata("Sheet1", 3, 1), exceldata.getstringdata("Sheet1", 4, 1));
		page.DateSelection(properties.getProperty("MONTH"), exceldata.getstringdata("Sheet1", 4, 1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		page.ReturnDateselection(exceldata.getstringdata("Sheet1", 5, 1), exceldata.getstringdata("Sheet1", 6, 1));
		page.Adultcount(exceldata.getstringdata("Sheet1", 7, 1));
		page.childpax(exceldata.getstringdata("Sheet1", 8, 1));
		page.infantpax(exceldata.getstringdata("Sheet1", 9, 1));
		page.Searchbutton();

	}

}
