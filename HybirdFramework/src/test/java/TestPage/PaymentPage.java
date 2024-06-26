package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

	
	static WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//label[@for='rdolstPaymentType_0']")
	public static WebElement CCpayment;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtFName']")
	public static WebElement Paymentcardname;

	@FindBy(xpath = "//select[@id='ucCardDetails_ddlYear']")
	public static WebElement Expirydate;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtCardNumber']")
	public static WebElement Cardno;

	@FindBy(xpath = "//input[@id='ucCardDetails_txtCVVCode']")
	public static WebElement CVV;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtFName']")
	public static WebElement BillingName;
	
	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtLName']")
	public static WebElement billinglastname;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtAdd1']")
	public static WebElement Address;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtCity']")
	public static WebElement city;

	// @FindBy
	// (xpath="//select[@id='ucPersonalDetails1_ddlCountry']//option[@value='India']")
	// public static WebElement Country;
	@FindBy(id = "ucPersonalDetails1_ddlCountry")
	public static WebElement country;
	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtPostCode']")
	public static WebElement Postcode;

	@FindBy(xpath = "//input[@id='ucPersonalDetails1_txtContactNo']")
	public static WebElement Contact;

	@FindBy(xpath = "//*[@id='chkRules']")
	public static WebElement rule;

	@FindBy(xpath = "//input[@id='btnBooking']")
	public static WebElement continuebtn;

	public void SelectPayment() {
		CCpayment.click();
	}

	public void carddetails(String CCcardname, String Cardnumber, String CCVno) {
		Paymentcardname.sendKeys(CCcardname);
		Cardno.sendKeys(Cardnumber);
		CVV.sendKeys(CCVno);
	}

	public void expirydate() {
		Select select = new Select(PaymentPage.Expirydate);
		select.selectByValue("2025");
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

	public void selectCountry() {
		Select select = new Select(PaymentPage.country);
		select.selectByVisibleText("India");
	}

	public void checkbox() {
		Actions actions = new Actions(driver);
		actions.moveToElement(PaymentPage.rule);
		actions.click().build().perform();
	}

	public void paymentcontinue() {
		continuebtn.click();
	}

	
}
