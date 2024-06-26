package Testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.PaymentPage;

public class PaymentTC extends Commondetails {
	Exceldata exceldata;

	@Test
	public void Paymentcase() throws IOException {
			test=extentReports.createTest("Verify to PaymentPage");
		exceldata = new Exceldata();
		PaymentPage page = PageFactory.initElements(driver, PaymentPage.class);

		page.SelectPayment();
		page.carddetails(exceldata.getPaymentdata("Sheet3", 1, 1), exceldata.getPaymentdata("Sheet3", 2, 1),
				exceldata.getPaymentdata("Sheet3", 3, 1));
		page.expirydate();
		page.Billingdataclear();
		page.Billingdetails(exceldata.getbillingdata("Sheet3", 5, 1), exceldata.getbillingdata("Sheet3", 6, 1),
				exceldata.getbillingdata("Sheet3", 7, 1), exceldata.getbillingdata("Sheet3", 8, 1),
				exceldata.getbillingdata("Sheet3", 9, 1), exceldata.getbillingdata("Sheet3", 10, 1));
		page.selectCountry();
		page.checkbox();
		page.paymentcontinue();
		extentReports.flush();
	

	}
}
