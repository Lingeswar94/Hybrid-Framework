package Testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import Commonfunction.Constant;
import TestPage.AddonPage;

public class AddonTC extends Commondetails {
	Logger logger = Logger.getLogger(AddonTC.class);

	@Test
	public void Addoncase() {

		// test=extentReports.createTest("Verify to AddonPage");
		logger.info("User is on Addon page");
		try {
			//AddonPage.getAddonPage().AddBaggages();
			// AddonPage.getAddonPage().AddonContinuebutton();
		 selectBaggage(Constant.ADTcount, Constant.Chcount, Constant.isReturnTrip, Constant.addBaggage, Constant.addDepartureBaggage, Constant.addReturnBaggage,Constant.Baggagename);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			AddonPage.getAddonPage().Baggagecontine.click();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	public  void selectBaggage(int ADTcount, int Chcount, boolean isReturnTrip, boolean addBaggage,
			boolean addDepartureBaggage, boolean addReturnBaggage, String Baggagename) {

		// If the user does not want to add baggage, skip the baggage selection process
		if (!addBaggage) {

			logger.info("No baggage selected for this booking.");
			return; // Skip the baggage selection if baggage is not needed
		} else {
			AddonPage.getAddonPage().Baggagebutton.click();

		}

		// Check if departure baggage is needed
		if (addDepartureBaggage) {
			AddonPage.getAddonPage().DepartureAddBaggage(ADTcount, Chcount, Baggagename);
		} else {
			logger.info("Departure baggage is not selected.");
		}

		// Check if return baggage is needed
		if (isReturnTrip && addReturnBaggage) {
			AddonPage.getAddonPage().ReturnAddBaggage(ADTcount, Chcount, Baggagename);
		} else {
			logger.info("Return baggage is not selected.");
		}
	}

}
