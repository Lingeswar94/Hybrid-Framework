package Testcase;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.PassengerPage;

public class PassengerTC extends Commondetails {

	@Test
	public void Passengerdetails() throws IOException {

		// test=extentReports.createTest("Verify to PassengerPage");
		Exceldata exceldata = new Exceldata();
		PassengerPage page = PageFactory.initElements(driver, PassengerPage.class);
		// exceldata.getstringdata("Sheet2", 2, 1)
		String Adult = properties.getProperty("AdultPax");
		page.MainPassenger(exceldata.getstringdata("Sheet2", 1, 1), Adult, exceldata.getstringdata("Sheet2", 3, 1),
				exceldata.getstringdata("Sheet2", 4, 1), exceldata.getstringdata("Sheet2", 5, 1),
				exceldata.getstringdata("Sheet2", 6, 1), exceldata.getstringdata("Sheet2", 7, 1));

		/*
		 * page.MainPassenger(exceldata.getstringdata("Sheet2", 1, 1));
		 * page.adultPaxfirstname(AdultPax);
		 * page.adultPaxlastname(exceldata.getstringdata("Sheet2", 3, 1));
		 * page.adultmobileno(exceldata.getstringdata("Sheet2", 4, 1));
		 * page.adultmail(exceldata.getstringdata("Sheet2", 5, 1));
		 * page.adultconmail(exceldata.getstringdata("Sheet2", 6, 1));
		 * page.adultRes(exceldata.getstringdata("Sheet2", 7, 1));
		 */

		page.childPassenger(exceldata.getstringdata("Sheet2", 10, 1), exceldata.getstringdata("Sheet2", 11, 1),
				exceldata.getstringdata("Sheet2", 12, 1), exceldata.getstringdata("Sheet2", 13, 1),
				exceldata.getstringdata("Sheet2", 14, 1), exceldata.getstringdata("Sheet2", 15, 1),
				exceldata.getstringdata("Sheet2", 16, 1));
		page.InfantPax(exceldata.getstringdata("Sheet2", 19, 1), exceldata.getstringdata("Sheet2", 20, 1),
				exceldata.getstringdata("Sheet2", 21, 1), exceldata.getstringdata("Sheet2", 22, 1),
				exceldata.getstringdata("Sheet2", 23, 1), exceldata.getstringdata("Sheet2", 24, 1),
				exceldata.getstringdata("Sheet2", 25, 1));
		page.Passengercontinue();

	}

}
