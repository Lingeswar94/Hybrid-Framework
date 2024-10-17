package Testcase;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
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
import Commonfunction.Constant;
import Commonfunction.Exceldata;
import TestPage.PassengerPage;

public class PassengerTC extends Commondetails {
	Exceldata exceldata = new Exceldata();
	Logger logger = Logger.getLogger(PassengerTC.class);
	
	@Test
	public void Passengerdetails() throws IOException {

		// test=extentReports.createTest("Verify to PassengerPage");
		// exceldata.getstringdata("Paxdetails", 2, 1)
		logger.info("User is on Passenger page");

		

		try {
			pax(Constant.ADTcount, Constant.Chcount, Constant.InFcount);
			logger.info("User is has given Main Pax details ");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			PassengerPage.getPassengerPage().Passengercontinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	public void pax(int ADTcount, int Chcount, int InFcount) {
		int adult = ADTcount + 1;
		int totalPassengers = adult + Chcount + InFcount;
		//String Adultpax = Commondetails.properties.getProperty("Adultpax");
		System.out.println("Total passengers: " + totalPassengers);
		System.out.println("ADTCount: " + (ADTcount + 1) + ", Chcount: " + Chcount + ", InFcount: " + InFcount);

		// Counters for adults, children, and infants
		int currentADT = 0;
		int currentCh = 0;
		int currentInf = 0;
		try {
			for (int index = 0; index < totalPassengers; index++) {
				if (currentADT < adult) {
					// Fill adult passenger details
					if (currentADT == 0) {
						PassengerPage.getPassengerPage().fillPassengerDetails(index,
								exceldata.getstringdata("Paxdetails", 1, 1),Constant.AdultPax,
								exceldata.getstringdata("Paxdetails", 3, 1),
								exceldata.getstringdata("Paxdetails", 4, 1),
								exceldata.getstringdata("Paxdetails", 5, 1),
								exceldata.getstringdata("Paxdetails", 6, 1),
								exceldata.getstringdata("Paxdetails", 7, 1));
						logger.info("User is has given Main Adult Pax details ");
					} else {

						PassengerPage.getPassengerPage().fillAdultPassengerdetails(index,
								exceldata.getstringdata("Paxdetails", 27, 1),
								exceldata.getstringdata("Paxdetails", 28, 1),
								exceldata.getstringdata("Paxdetails", 29, 1),
								exceldata.getstringdata("Paxdetails", 30, 1));
						logger.info("User is has given Adult" + adult + " Pax details ");
					}
					currentADT++;
				} else if (currentCh < Chcount) {
					// Fill child passenger details
					PassengerPage.getPassengerPage().fillChildPassengerDetails(index,
							exceldata.getstringdata("Paxdetails", 10, 1), exceldata.getstringdata("Paxdetails", 11, 1),
							exceldata.getstringdata("Paxdetails", 12, 1), exceldata.getstringdata("Paxdetails", 13, 1),
							exceldata.getstringdata("Paxdetails", 14, 1), exceldata.getstringdata("Paxdetails", 15, 1),
							exceldata.getstringdata("Paxdetails", 16, 1));
					logger.info("User is has given Child" + Chcount + "Pax details");
					currentCh++;
				} else if (currentInf < InFcount) {
					// Fill infant passenger details
					PassengerPage.getPassengerPage().fillInfantPassengerDetails(index,
							exceldata.getstringdata("Paxdetails", 19, 1), exceldata.getstringdata("Paxdetails", 20, 1),
							exceldata.getstringdata("Paxdetails", 21, 1), exceldata.getstringdata("Paxdetails", 22, 1),
							exceldata.getstringdata("Paxdetails", 23, 1), exceldata.getstringdata("Paxdetails", 24, 1),
							exceldata.getstringdata("Paxdetails", 25, 1));
					currentInf++;
				} else {
					logger.error("Pax is not selected to this bookings " + index);
				}
			}
		}

		catch (Exception e) {
			System.out.println();
		}
	}
}
