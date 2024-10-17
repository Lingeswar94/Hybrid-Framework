package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Commonfunction.Commondetails;
import Commonfunction.Exceldata;

public class PassengerPage {

	private static PassengerPage passengerPage;

	
	private PassengerPage() {

	}

	public static PassengerPage getPassengerPage() {
		if (passengerPage == null) {
			passengerPage = new PassengerPage();
		}
		return passengerPage;
	}

	@FindBy(xpath = "//input[@id='btnConfirmPassenger']")
	private WebElement passcontinue;

	public WebElement getPassengerTitle(int index) {
		String AdultTitle = "//select[@id='ucPassenger1_lstPassenger_TITLE_" + index + "_ddlTitle_" + index + "']";
		return Commondetails.getDriver().findElement(By.xpath(AdultTitle));
	}

	public WebElement getPassengerFirstName(int index) {
		String AdultFirst = "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_" + index + "_txtFName_" + index + "']";
		return Commondetails.getDriver().findElement(By.xpath(AdultFirst));
	}

	public WebElement getPassengerLastName(int index) {
		String AdultLast = "//input[@id='ucPassenger1_lstPassenger_LASTNAME_" + index + "_txtLName_" + index + "']";
		return Commondetails.getDriver().findElement(By.xpath(AdultLast));
	}

	public WebElement getPassengerMobileNo(int index) {
		String Adultmobile = "//input[@id='ucPassenger1_lstPassenger_PAXMOBILENO_" + index + "_txtPaxMobileNo_" + index
				+ "']";
		return Commondetails.getDriver().findElement(By.xpath(Adultmobile));
	}

	public WebElement getPassengerEmail(int index) {
		String Adultemail = "//input[@id='ucPassenger1_lstPassenger_EMAIL_" + index + "_txtEmail_" + index + "']";
		return Commondetails.getDriver().findElement(By.xpath(Adultemail));
	}

	public WebElement getPassengerConfirmEmail(int index) {
		String Adultconfrimemail = "//input[@id='ucPassenger1_lstPassenger_ConfirmEmail_" + index + "_txtConfirmEmail_"
				+ index + "']";
		return Commondetails.getDriver().findElement(By.xpath(Adultconfrimemail));
	}

	public WebElement getPassengerResidentialPostcode(int index) {
		String AdultPostcode = "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_" + index + "_txtResPostCode_"
				+ index + "']";
		return Commondetails.getDriver().findElement(By.xpath(AdultPostcode));

	}
//Child

	public WebElement getTitle(int index) {
		String ChildTitle = "//select[@id='ucPassenger1_lstPassenger_TITLE_" + index + "_ddlTitle_" + index + "']";
		return Commondetails.getDriver().findElement(By.xpath(ChildTitle));
	}

	/*
	 * public WebElement getFirstName(int index) { String Childfirst =
	 * "//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_" + index + "_txtFName_" +
	 * index + "']"; return driver.findElement(By.xpath(Childfirst)); }
	 * 
	 * public WebElement getLastName(int index) { String Childlast =
	 * "//input[@id='ucPassenger1_lstPassenger_LASTNAME_" + index + "_txtLName_" +
	 * index + "']"; return driver.findElement(By.xpath(Childlast)); }
	 */

	public WebElement getDOBDay(int index) {
		String ChildDOBDate = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_" + index + "_ddlDay_" + index
				+ "']";
		return Commondetails.getDriver().findElement(By.xpath(ChildDOBDate));
	}

	public WebElement getDOBMonth(int index) {
		String ChildDOBMonth = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_" + index + "_ddlMonth_" + index
				+ "']";
		return Commondetails.getDriver().findElement(By.xpath(ChildDOBMonth));
	}

	public WebElement getDOBYear(int index) {
		String ChildDOBYear = "//select[@id='ucPassenger1_lstPassenger_DATEOFBIRTH_" + index + "_ddlYear_" + index
				+ "']";
		return Commondetails.getDriver().findElement(By.xpath(ChildDOBYear));
	}
	public void Passengercontinue() {
		passcontinue.click();
	}
	/*
	 * public WebElement getResidentialPostcode(int index) { String ChildPostcode =
	 * "//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_" + index +
	 * "_txtResPostCode_" + index + "']"; return
	 * driver.findElement(By.xpath(ChildPostcode)); }
	 */
//infant

	
	
	
	public void fillPassengerDetails(int index, String title, String firstName, String lastName, String mobile,
			String email,String confirm, String postcode) {
		// Select the title (Mr, Mrs, etc.)

		Select selectTitle = new Select(getPassengerTitle(index));
		selectTitle.selectByVisibleText(title);

		// Fill in other details
		getPassengerFirstName(index).sendKeys(firstName);
		getPassengerLastName(index).sendKeys(lastName);
		getPassengerMobileNo(index).sendKeys(mobile);
		getPassengerEmail(index).sendKeys(email);
		getPassengerConfirmEmail(index).sendKeys(confirm); // Assuming confirm email is same as email
		getPassengerResidentialPostcode(index).sendKeys(postcode);
	}

	public void fillAdultPassengerdetails(int index, String title, String firstName, String lastName, String postcode) {
		Select selectTitle = new Select(getPassengerTitle(index));
		selectTitle.selectByVisibleText(title);

		// Fill in other details
		getPassengerFirstName(index).sendKeys(firstName);
		getPassengerLastName(index).sendKeys(lastName);
		getPassengerResidentialPostcode(index).sendKeys(postcode);

	}

	public void fillChildPassengerDetails(int index, String title, String firstName, String lastName, String dobDay,
			String dobMonth, String dobYear, String postcode) {
		// Select the title (Master, Miss, etc.)
		Select selectTitle = new Select(getTitle(index));
		selectTitle.selectByVisibleText(title);

		// Fill in other details
		getPassengerFirstName(index).sendKeys(firstName);
		getPassengerLastName(index).sendKeys(lastName);
		Select selectDay = new Select(getDOBDay(index));
		selectDay.selectByVisibleText(dobDay);
		Select selectMonth = new Select(getDOBMonth(index));
		selectMonth.selectByVisibleText(dobMonth);
		Select selectYear = new Select(getDOBYear(index));
		selectYear.selectByVisibleText(dobYear);
		getPassengerResidentialPostcode(index).sendKeys(postcode);
	}

	// Method to fill out infant passenger details dynamically
	public void fillInfantPassengerDetails(int index, String title, String firstName, String lastName, String dobDay,
			String dobMonth, String dobYear, String postcode) {
		// Select the title (Baby, Infant, etc.)
		Select selectTitle = new Select(getTitle(index));
		selectTitle.selectByVisibleText(title);

		// Fill in other details
		getPassengerFirstName(index).sendKeys(firstName);
		getPassengerLastName(index).sendKeys(lastName);
		Select selectDay = new Select(getDOBDay(index));
		selectDay.selectByVisibleText(dobDay);
		Select selectMonth = new Select(getDOBMonth(index));
		selectMonth.selectByVisibleText(dobMonth);
		Select selectYear = new Select(getDOBYear(index));
		selectYear.selectByVisibleText(dobYear);
		getPassengerResidentialPostcode(index).sendKeys(postcode);
	}
	
	

}
