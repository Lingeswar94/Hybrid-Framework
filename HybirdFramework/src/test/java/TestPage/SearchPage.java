package TestPage;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commonfunction.Commondetails;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPage {

	Logger logger = Logger.getLogger(SearchPage.class);

	private static SearchPage searchPage;

	private SearchPage() {

	}

	public static SearchPage getSearchPage() {

		if (searchPage == null) {
			searchPage = new SearchPage();
		}
		return searchPage;
	}

	@FindBy(xpath = "//div[@id='ucMiniSearch_divJourneyType']/div/table/tbody/tr")
	private List<WebElement> Trip;

	@FindBy(xpath = "//select[@id='ucMiniSearch_depCity']")
	private WebElement departurecity;

	@FindBy(xpath = "//select[@id='ucMiniSearch_arrCity']")
	private WebElement arrivalcity;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlAdult']")
	private WebElement AdultPax;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlChild']")
	private WebElement Child;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlInfant']")
	private WebElement Infant;

	@FindBy(xpath = "//input[@id='btnminiSearch']")
	private WebElement searchagin;

	public void journeyDateSelection(String value, String departurecity, String arrivalcity, String Monthandyear,
			String date, String returnmonth, String redate) {

		selectJourneyTypeByValue(value); // "1" for One Way, "2" for Return
		departureroute(departurecity);
		arrivalroute(arrivalcity);

		// Conditional logic to run methods based on journey type
		if (isOneWaySelected()) {
			// Call DateSelection for one way journey
			DateSelection(Monthandyear, date);
		} else if (isReturnSelected()) {

			DateSelection(Monthandyear, date); // Departure date
			ReturnDateselection(returnmonth, redate); // Return date
		}
	}

	// Method to select the journey type based on the value attribute
	public void selectJourneyTypeByValue(String value) {
		WebDriverWait wait = new WebDriverWait(Commondetails.getDriver(), Duration.ofSeconds(10));
		WebElement journeyTypeRadioButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@name='ucMiniSearch$rdoJourneyType' and @value='" + value + "']")));

		journeyTypeRadioButton.click();
		// Debugging: Print which option was selected
		if (value.equals("1")) {
			System.out.println("Selected: One Way");
		} else if (value.equals("2")) {
			System.out.println("Selected: Return");
		} else {
			System.out.println("Invalid value for journey type.");
		}
	}
	

	// Method to check if "One Way" is selected
	public boolean isOneWaySelected() {
		WebElement oneWayRadioButton = Commondetails.getDriver().findElement(By.id("ucMiniSearch_rdoJourneyType_0"));
		return oneWayRadioButton.isSelected();
	}

	// Method to check if "Return" is selected
	public boolean isReturnSelected() {
		WebElement returnRadioButton = Commondetails.getDriver().findElement(By.id("ucMiniSearch_rdoJourneyType_1"));
		return returnRadioButton.isSelected();
	}

	// Method to select the departure city
	public void departureroute(String departure) {
		Select select = new Select(departurecity);
		select.selectByValue(departure);
	}

	// Method to select the arrival city
	public void arrivalroute(String arrival) {
		Select select2 = new Select(arrivalcity);
		select2.selectByValue(arrival);
	}

	// Method to select the departure date
	public void DateSelection(String MonthandYear, String date) {
		WebDriverWait wait = new WebDriverWait(Commondetails.getDriver(), Duration.ofSeconds(10));
		while (true) {
			String Daytext = Commondetails.getDriver().findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
			String[] da = Daytext.split(" ");
			if (da[0].equalsIgnoreCase(MonthandYear)) {
				break;
			} else {
				Commondetails.getDriver().findElement(By.xpath("//th[@class='next']")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@class='next']")));
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + date + ")]"))).click();
	}

	// Method to select the return date
	public void ReturnDateselection(String returnmonth, String redate) {
		while (true) {
			String returndate = Commondetails.getDriver().findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
			String[] da = returndate.split(" ");

			if (da[0].equalsIgnoreCase(returnmonth)) {
				break;
			} else {
				Commondetails.getDriver().findElement(By.xpath("//th[@class='next']")).click();
			}
		}
		Commondetails.getDriver().findElement(
				By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + redate + ")]")).click();
	}

	public void Adultcount(int ADTcount) {
		Select Adult = new Select(AdultPax);
		Adult.selectByIndex(ADTcount);
	}

	public void childpax(int Chcount) {
		Select selectChild = new Select(Child);
		selectChild.selectByIndex(Chcount);
	}

	public void infantpax(int InFcount) {
		Select selectInfant = new Select(Infant);
		selectInfant.selectByIndex(InFcount);
	}

	public void Searchbutton() {
		searchagin.click();
	}

}
