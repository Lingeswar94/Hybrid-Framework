package Testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import TestPage.ThanksPage;

public class ThanksTC extends Commondetails {

	Logger logger = Logger.getLogger(ThanksTC.class);

	@Test
	public void Thankscase() {
		// test=extentReports.createTest("Verify to ThanksPage");
		
		logger.info("User is on Thanks page");
		try {
			ThanksPage.getThanksPage().getsimulation();
			//ThanksPage.getThanksPage().exit();
			ThanksPage.getThanksPage().getPNR();
			//logger.info(logger);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
