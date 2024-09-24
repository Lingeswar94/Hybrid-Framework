package Testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;
import TestPage.PaymentPage;

public class PaymentTC extends Commondetails {
	Exceldata exceldata = new Exceldata();
	Logger logger = Logger.getLogger(PaymentTC.class);

	@Test
	public void Paymentcase() throws IOException {
		// test = extentReports.createTest("Verify to PaymentPage");

		logger.info("User is on Payment page");
		try {
			PaymentPage.getPaymentPage().SelectPayment();
			logger.info("User is given Credit Card details");
			PaymentPage.getPaymentPage().carddetails(exceldata.getPaymentdata("Payment", 1, 1),
					exceldata.getPaymentdata("Payment", 2, 1), exceldata.getPaymentdata("Payment", 3, 1));
			PaymentPage.getPaymentPage().Expirationyear(exceldata.getPaymentdata("Payment", 11, 1));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			PaymentPage.getPaymentPage().Billingdataclear();
			logger.info("User is given Billingdetails ");
			PaymentPage.getPaymentPage().Billingdetails(exceldata.getbillingdata("Payment", 5, 1),
					exceldata.getbillingdata("Payment", 6, 1), exceldata.getbillingdata("Payment", 7, 1),
					exceldata.getbillingdata("Payment", 8, 1), exceldata.getbillingdata("Payment", 9, 1),
					exceldata.getbillingdata("Payment", 10, 1));
			PaymentPage.getPaymentPage().selectCountry(exceldata.getPaymentdata("Payment", 12, 1));
			PaymentPage.getPaymentPage().checkbox();
			PaymentPage.getPaymentPage().paymentcontinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		// extentReports.flush();

	}
}
