package Testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import TestPage.AddonPage;

public class AddonTC extends Commondetails {
	
	@Test
	public void Addoncase() {
		
	//test=extentReports.createTest("Verify to AddonPage");
			AddonPage Page = PageFactory.initElements(driver, AddonPage.class);
			Page.AddonContinuebutton();
			
		}
}
