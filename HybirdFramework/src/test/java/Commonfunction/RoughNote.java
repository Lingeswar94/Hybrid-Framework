package Commonfunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;

import TestPage.PassengerPage;

public class RoughNote {
	WebDriver driver;

	/*
	 * public void tearDown(ITestResult result) { if (result.getStatus() ==
	 * ITestResult.FAILURE) { try { String screenshotPath =
	 * Helper.getScreenshot(driver, result.getName()); test.log(Status.FAIL,
	 * "Test Failed. Screenshot captured: " +
	 * test.addScreenCaptureFromPath(screenshotPath)); test.log(Status.FAIL,
	 * "Test Failed: " + result.getThrowable()); } catch (IOException e) {
	 * e.printStackTrace(); } } else if (result.getStatus() == ITestResult.SUCCESS)
	 * { try { String screenshotPath = Helper.getScreenshot(driver,
	 * result.getName()); test.log(Status.PASS, "Test Passed. Screenshot captured: "
	 * + test.addScreenCaptureFromPath(screenshotPath)); } catch (IOException e) {
	 * e.printStackTrace(); } } else if (result.getStatus() == ITestResult.SKIP) {
	 * test.log(Status.SKIP, "Test Skipped: " + result.getThrowable()); }
	 * 
	 * if (driver != null) { driver.quit(); } }
	 * 
	 * @AfterSuite public void tearDownReport() { extent.flush(); } }
	 */
	/*
	 * @BeforeClass public ExtentReports Extentreportdata() {
	 * 
	 * Reporter = new ExtentSparkReporter( new String(System.getProperty("user.dir")
	 * + "/Reports/FCProject " + Helper.getCurrenttime() + ".html"));
	 * Reporter.config().setDocumentTitle("Automation Test Report");
	 * Reporter.config().setReportName("FC Normal Flow Project");
	 * Reporter.config().setTheme(Theme.DARK); extentReports = new ExtentReports();
	 * extentReports.attachReporter(Reporter);
	 * extentReports.setSystemInfo("Environment", "QA");
	 * extentReports.setSystemInfo("Application URL",
	 * properties.getProperty("URL")); extentReports.setSystemInfo("BRowser Name",
	 * properties.getProperty("Browser")); return extentReports;
	 * 
	 * }
	 */

	/*
	 * @AfterMethod public void teardown(ITestResult result) throws IOException,
	 * AWTException {
	 * 
	 * if (result.getStatus() == ITestResult.SUCCESS) { String screenshotPath =
	 * Helper.getscreenshotcapture(driver, result.getTestName());
	 * test.log(Status.PASS, "Test Passed: Screenshot capture",
	 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	 * 
	 * } else if (result.getStatus() == ITestResult.FAILURE) {
	 * 
	 * String screenshotPath = Helper.getFailscreenshot(driver,
	 * result.getTestName()); test.log(Status.FAIL,
	 * "Test Failed: Screenshot capture",
	 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	 * 
	 * } else if (result.getStatus() == ITestResult.SKIP) {
	 * 
	 * String screenshotPath = Helper.getskipScreenshot(driver,
	 * result.getTestName()); test.log(Status.SKIP,
	 * "Test Skiped: Screenshot capture",
	 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
	 * extentReports.flush(); }
	 */
	public void name() {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path="./Screenshot/SkipTest.png";
			FileHandler.copy(file, new File(path));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
//	public void MainPassenger(String Adtitle) {
//		Select select = new Select(PassengerPage.Title);
//		select.selectByValue(Adtitle);
//	}
//	public void adultPaxfirstname(String fname) {
//		firstname.sendKeys(fname);
//	}
//	public void adultPaxlastname(String lname) {
//		lastname.sendKeys(lname);
//	}
//	public void adultmobileno(String mobile) {
//		mobileno.sendKeys(mobile);
//	}
//	public void adultmail(String mail) {
//		email.sendKeys(mail);
//	}
//	public void adultconmail(String conmail) {
//		confrmemail.sendKeys(conmail);
//	}
//	public void adultRes(String Res) {
//		Residential.sendKeys(Res);
//	}
	 
	// * else if (jounerytrip[0].contains(trip)) { if
	// * (triptext.equalsIgnoreCase("Return")) {
	// * if(Commondetails.getDriver().findElement(By.xpath(
	 //* "//input[@id='ucMiniSearch_rdoJourneyType_1']")).isSelected()) {
	 //* System.out.println("Return is selected"); }break;
	 //* //Commondetails.getDriver().findElement(By.id("ucMiniSearch_rdoJourneyType_0"
	 //* )).click(); //WebElement round = Commondetails.getDriver()
	 //* .findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_1']"));
	 //* //round.click(); //fareFound = true; }
	
	
	public void Tripselection(String trip) {
		// WebElement oneway =
		// Commondetails.getDriver().findElement(By.id("ucMiniSearch_rdoJourneyType_0"));
		// WebElement multicity =
		// Commondetails.getDriver().findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_2']"));
		// WebElement round =
		// Commondetails.getDriver().findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_1']"));

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

}

