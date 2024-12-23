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
			// OBseatSelection(ADTcount, Chcount, isReturnSelected(), isOneWaySelected(),
			// isOneWaySelected(), isReturnSelected(), addd, addd, addd, addd, addd, addd)
			seatSelection(Constant.ADTcount, Constant.Chcount, Constant.isReturnTrip, Constant.addSeat,
					Constant.addDepartureSeat, Constant.addReturnSeat, Constant.OBMainseat, null, Constant.OBChildseat,
					Constant.IBMainseat, null, Constant.IBChildseat);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			// AddonPage.getAddonPage().AddBaggages();
			// AddonPage.getAddonPage().AddonContinuebutton();
			selectBaggage(Constant.ADTcount, Constant.Chcount, Constant.isReturnTrip, Constant.addBaggage,
					Constant.addDepartureBaggage, Constant.addReturnBaggage, Constant.Baggagename);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
		//	AddonPage.getAddonPage().Baggagecontine.click();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void seatSelection(int ADTcount, int Chcount, boolean isReturnTrip, boolean addSeat,
			boolean addDepartureSeat, boolean addReturnSeat, String OBMainseat, String OBAdultseat, String OBChildseat,
			String IBMainseat, String IBAdultseat, String IBChildseat) {
// Check if seat selection is enabled
		if (!addSeat) {
			System.out.println("Seat is not selected for this booking");
			return;
		}

// Click on Seat Selection
		AddonPage.getAddonPage().Seatselection.click();
		System.out.println("Seat" + OBMainseat);
		System.out.println("Seat" + OBChildseat);
// Departure Seat Selection
		if (addDepartureSeat) {
			AddonPage.getAddonPage().OBselectSeats(ADTcount, Chcount, OBMainseat, OBAdultseat, OBChildseat);
		} else {
			System.out.println("Departure Seat is not selected");
		}

// Return Seat Selection (if applicable)
		if (isReturnTrip && addReturnSeat) {
			AddonPage.getAddonPage().IBselectSeats(ADTcount, Chcount, IBMainseat, IBAdultseat, IBChildseat);
		} else {
			System.out.println("Arrival Seat is not selected");
		}
	}

	public void selectBaggage(int ADTcount, int Chcount, boolean isReturnTrip, boolean addBaggage,
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
