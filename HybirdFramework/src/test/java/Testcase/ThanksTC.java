package Testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import TestPage.ThanksPage;

public class ThanksTC extends Commondetails {

	
	@Test
	public void Thankscase() {
			test=extentReports.createTest("Verify to ThanksPage");
		ThanksPage thanksPage = PageFactory.initElements(driver, ThanksPage.class);
		
		thanksPage.exit();
		extentReports.flush();
	}
}
