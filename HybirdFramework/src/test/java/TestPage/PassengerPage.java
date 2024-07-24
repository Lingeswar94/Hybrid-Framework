package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PassengerPage {

	public static WebDriver driver;

	public PassengerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_0_ddlTitle_0']")
	public static WebElement Title;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_0_txtFName_0']")
	public static WebElement firstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_0_txtLName_0']")
	public static WebElement lastname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_PAXMOBILENO_0_txtPaxMobileNo_0']")
	public static WebElement mobileno;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_EMAIL_0_txtEmail_0']")
	public static WebElement email;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_ConfirmEmail_0_txtConfirmEmail_0']")
	public static WebElement confrmemail;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_0_txtResPostCode_0']")
	public static WebElement Residential;

	@FindBy(xpath = "//input[@id='btnConfirmPassenger']")
	public static WebElement Passctn;

	// Child
	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_1_ddlTitle_1']")
	public static WebElement chTitle;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_1_txtFName_1']")
	public static WebElement Childfirstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_1_txtLName_1']")
	public static WebElement Childlastname;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlDay_1']")
	public static WebElement ChildDOBdate;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlMonth_1']")
	public static WebElement ChildDOBmonth;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlYear_1']")
	public static WebElement ChildDOBYear;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_1_txtResPostCode_1']")
	public static WebElement ChildResidential;

	// infant
	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_2_ddlTitle_2']")
	public static WebElement INTitle;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_2_txtFName_2']")
	public static WebElement Infantfirstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_2_txtLName_2']")
	public static WebElement Infantlastname;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlDay_2']")
	public static WebElement InfantDOBdate;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlMonth_2']")
	public static WebElement InfantDOBmonth;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlYear_2']")
	public static WebElement InfantDOBYear;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_2_txtResPostCode_2']")
	public static WebElement InfantResidential;

	@FindBy(xpath = "//input[@id='btnConfirmPassenger']")
	public WebElement passcontinue;

	public void MainPassenger(String Adtitle, String fname, String lname, String mobile, String mailid, String conemail,
			String Res) {
		Select select = new Select(PassengerPage.Title);
		select.selectByValue(Adtitle);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		mobileno.sendKeys(mobile);
		email.sendKeys(mailid);
		confrmemail.sendKeys(conemail);
		Residential.sendKeys(Res);
	}

	/*
	 * public void MainPassenger(String Adtitle) { Select select = new
	 * Select(PassengerPage.Title); select.selectByValue(Adtitle); } public void
	 * adultPaxfirstname(String AdultPax) { firstname.sendKeys(AdultPax); } public
	 * void adultPaxlastname(String lname) { lastname.sendKeys(lname); } public void
	 * adultmobileno(String mobile) { mobileno.sendKeys(mobile); } public void
	 * adultmail(String mail) { email.sendKeys(mail); } public void
	 * adultconmail(String conmail) { confrmemail.sendKeys(conmail); } public void
	 * adultRes(String Res) { Residential.sendKeys(Res); }
	 */
	public void childPassenger(String chtitle, String fname, String lname, String date, String month, String year,
			String Res) {
		Select select = new Select(PassengerPage.chTitle);
		select.selectByVisibleText(chtitle);
		Childfirstname.sendKeys(fname);
		Childlastname.sendKeys(lname);
		Select select2 = new Select(PassengerPage.ChildDOBdate);
		select2.selectByVisibleText(date);
		Select select3 = new Select(PassengerPage.ChildDOBmonth);
		select3.selectByVisibleText(month);
		Select select4 = new Select(PassengerPage.ChildDOBYear);
		select4.selectByVisibleText(year);
		ChildResidential.sendKeys(Res);
	}

	public void InfantPax(String intitle, String fname, String lname, String date, String month, String year,
			String Res) {
		Select select = new Select(PassengerPage.INTitle);
		select.selectByVisibleText(intitle);
		Infantfirstname.sendKeys(fname);
		Infantlastname.sendKeys(lname);
		Select select2 = new Select(PassengerPage.InfantDOBdate);
		select2.selectByVisibleText(date);
		Select select3 = new Select(PassengerPage.InfantDOBmonth);
		select3.selectByVisibleText(month);
		Select select4 = new Select(PassengerPage.InfantDOBYear);
		select4.selectByVisibleText(year);
		InfantResidential.sendKeys(Res);
	}

	public void Passengercontinue() {
		passcontinue.click();
	}
}
