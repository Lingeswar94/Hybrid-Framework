package Testcase;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
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
import Commonfunction.Constant;
import Commonfunction.Exceldata;
import TestPage.SearchPage;

public class SearchTC extends Commondetails {
	Logger logger = Logger.getLogger(SearchTC.class);

	Exceldata exceldata = new Exceldata();

	@Test
	public void Startpage() throws IOException {

		// test.log(Status.INFO, "LinkAirways application up and Running :");

		// test = extentReports.createTest("Verify to SearchFlight Page");
		logger.info("User is on SearchPage ");
		
		
	    
		try {
			logger.info("User is to select Trip for Journey ");

			SearchPage.getSearchPage().journeyDateSelection(Constant.JourneyTrip, Constant.Departurecity, Constant.ArrivalCity, Constant.MonthandYear, Constant.date,
					Constant.returnmonth, Constant.redate);

			logger.info("User is to select Departurecity ");
			logger.info("User is to select Arrivalcity ");
			logger.info("User is to select Date of Travel ");
			logger.info("User is to select Number of Adult Pax ");
			// SearchPage.getSearchPage().Adultcount(exceldata.getstringdata("Sheet1", 7, 1));
			SearchPage.getSearchPage().Adultcount(Constant.ADTcount);
			logger.info("User is to select Number of Child Pax ");
			//SearchPage.getSearchPage().childpax(exceldata.getstringdata("Sheet1", 8, 1));
			SearchPage.getSearchPage().childpax(Constant.Chcount);
			logger.info("User is to select Number of Infant Pax ");
			//SearchPage.getSearchPage().infantpax(exceldata.getstringdata("Sheet1", 9, 1));
			SearchPage.getSearchPage().infantpax(Constant.InFcount);
			SearchPage.getSearchPage().Searchbutton();
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
