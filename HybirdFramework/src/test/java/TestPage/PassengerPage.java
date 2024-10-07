package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PassengerPage {

	private static PassengerPage passengerPage;

	private PassengerPage() {
		
	}
	public static PassengerPage getPassengerPage() {
		if(passengerPage==null) {
			passengerPage=new PassengerPage();
		}
		return passengerPage;
	}

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_0_ddlTitle_0']")
	private WebElement Title;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_0_txtFName_0']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_0_txtLName_0']")
	private WebElement lastname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_PAXMOBILENO_0_txtPaxMobileNo_0']")
	private WebElement mobileno;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_EMAIL_0_txtEmail_0']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_ConfirmEmail_0_txtConfirmEmail_0']")
	private WebElement confrmemail;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_0_txtResPostCode_0']")
	private WebElement Residential;

	@FindBy(xpath = "//input[@id='btnConfirmPassenger']")
	private WebElement Passctn;

	// Child
	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_1_ddlTitle_1']")
	private WebElement chTitle;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_1_txtFName_1']")
	private WebElement Childfirstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_1_txtLName_1']")
	private WebElement Childlastname;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlDay_1']")
	private WebElement ChildDOBdate;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlMonth_1']")
	private WebElement ChildDOBmonth;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_1_ddlYear_1']")
	private WebElement ChildDOBYear;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_1_txtResPostCode_1']")
	private WebElement ChildResidential;

	// infant
	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_TITLE_2_ddlTitle_2']")
	private WebElement INTitle;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_2_txtFName_2']")
	private WebElement Infantfirstname;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_2_txtLName_2']")
	private WebElement Infantlastname;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlDay_2']")
	private WebElement InfantDOBdate;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlMonth_2']")
	private WebElement InfantDOBmonth;

	@FindBy(xpath = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_2_ddlYear_2']")
	private WebElement InfantDOBYear;

	@FindBy(xpath = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_2_txtResPostCode_2']")
	private WebElement InfantResidential;

	@FindBy(xpath = "//input[@id='btnConfirmPassenger']")
	private WebElement passcontinue;

	public void MainPassenger(String Adtitle, String fname, String lname, String mobile, String mailid, String conemail,
			String Res) {
		Select select = new Select(Title);
		select.selectByValue(Adtitle);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		mobileno.sendKeys(mobile);
		email.sendKeys(mailid);
		confrmemail.sendKeys(conemail);
		Residential.sendKeys(Res);
	}

	public void childPassenger(String chtitle, String fname, String lname, String date, String month, String year,
			String Res) {
		Select select = new Select(chTitle);
		select.selectByVisibleText(chtitle);
		Childfirstname.sendKeys(fname);
		Childlastname.sendKeys(lname);
		Select select2 = new Select(ChildDOBdate);
		select2.selectByVisibleText(date);
		Select select3 = new Select(ChildDOBmonth);
		select3.selectByVisibleText(month);
		Select select4 = new Select(ChildDOBYear);
		select4.selectByVisibleText(year);
		ChildResidential.sendKeys(Res);
	}

	public void InfantPax(String intitle, String fname, String lname, String date, String month, String year,
			String Res) {
		Select select = new Select(INTitle);
		select.selectByVisibleText(intitle);
		Infantfirstname.sendKeys(fname);
		Infantlastname.sendKeys(lname);
		Select select2 = new Select(InfantDOBdate);
		select2.selectByVisibleText(date);
		Select select3 = new Select(InfantDOBmonth);
		select3.selectByVisibleText(month);
		Select select4 = new Select(InfantDOBYear);
		select4.selectByVisibleText(year);
		InfantResidential.sendKeys(Res);
	}

	public void Passengercontinue() {
		passcontinue.click();
	}

	
}
