package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Commonfunction.Commondetails;

public class PaymentPage {

	private static PaymentPage paymentPage;

	private PaymentPage() {

	}

	public static PaymentPage getPaymentPage() {
		if (paymentPage == null) {
			paymentPage = new PaymentPage();
		}
		return paymentPage;
	}

	@FindBy(xpath = "//label[@for='rdolstPaymentType_0']")
	private WebElement CCpayment;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtFName']")
	private WebElement Paymentcardname;

	@FindBy(xpath = "//select[@id='ucCardDetails_ddlYear']")
	private WebElement Expirydate;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtCardNumber']")
	private WebElement Cardno;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtCVVCode']")
	private WebElement CVV;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtFName']")
	private WebElement BillingName;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtLName']")
	private WebElement billinglastname;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtAdd1']")
	private WebElement Address;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtCity']")
	private WebElement city;

	// @FindBy
	// (xpath="//select[@id='ucPersonalDetails1_ddlCountry']//option[@value='India']")
	// public static WebElement Country;
	@FindBy(id = "ucPersonalDetails1_ddlCountry")
	private WebElement country;
	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtPostCode']")
	private WebElement Postcode;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtContactNo']")
	private WebElement Contact;

	@FindBy(xpath = "//*[@id='chkRules']")
	private WebElement rule;

	@FindBy(xpath = "//input[@id='btnBooking']")
	private WebElement continuebtn;

	public void SelectPayment() {
		CCpayment.click();
	}

	public void carddetails(String CCcardname, String Cardnumber, String CCVno) {
		Paymentcardname.sendKeys(CCcardname);
		Cardno.sendKeys(Cardnumber);
		CVV.sendKeys(CCVno);
	}

	public void Expirationyear(String expyear) {
		Select select = new Select(Expirydate);
		select.selectByValue(expyear);
	}

	public void Billingdataclear() {
		BillingName.clear();
		billinglastname.clear();
	}

	public void Billingdetails(String Billingname, String billlastname, String Addressdetails, String citydetails,
			String Post, String contactno) {

		BillingName.sendKeys(Billingname);
		billinglastname.sendKeys(billlastname);
		Address.sendKeys(Addressdetails);
		city.sendKeys(citydetails);
		Postcode.sendKeys(Post);
		Contact.sendKeys(contactno);
	}

	public void selectCountry(String selectedCountry) {
		Select select = new Select(country);
		select.selectByVisibleText(selectedCountry);
	}

	public void checkbox() {
		Actions actions = new Actions(Commondetails.getDriver());
		actions.moveToElement(rule);
		actions.click().build().perform();
	}

	public void paymentcontinue() {
		continuebtn.click();
	}

}
