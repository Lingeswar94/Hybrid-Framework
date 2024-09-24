package Testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import TestPage.AddonPage;

public class AddonTC extends Commondetails {
	Logger logger = Logger.getLogger(AddonTC.class);

	@Test
	public void Addoncase() {

		// test=extentReports.createTest("Verify to AddonPage");
		logger.info("User is on Addon page");
		try {
			AddonPage.getAddonPage().AddonContinuebutton();
			logger.info("No addon is selected for this booking");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
