package TestPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Commonfunction.Commondetails;

public class SearchPage {

	
	private static SearchPage searchPage;

	private SearchPage() {

	}

	public static SearchPage getSearchPage() {
		
		if(searchPage==null) {
			searchPage=new SearchPage();
		}
		return searchPage;
	}

	@FindBy(xpath = "//*[@id='ucMiniSearch_rdoJourneyType']/tbody/tr")
	private  List<WebElement> Trip;

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

	public void Tripselection(String trip) {

		int size = Trip.size();
		boolean fareFound = false;
		for (int i = 0; i <= size && !fareFound; i++) {
			WebElement journey = Trip.get(i);
			String triptext = journey.getText();
			if (triptext.contains(trip)) {
				WebElement oneway = Commondetails.getDriver().findElement(By.id("ucMiniSearch_rdoJourneyType_0"));
				oneway.click();
				fareFound = true;
			} else if (triptext.contains(trip)) {
				WebElement round = Commondetails.getDriver()
						.findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_1']"));
				round.click();
				fareFound = true;
			} else if (triptext.contains(trip)) {
				WebElement multicity = Commondetails.getDriver()
						.findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_2']"));
				multicity.click();
				fareFound = true;
			} else {
				System.out.println("No trip selected");
			}
		}
	}

	public void departureroute(String departure) {
		Select select = new Select(departurecity);
		select.selectByValue(departure);
	}

	public void arrivalroute(String arrival) {
		Select select2 = new Select(arrivalcity);
		select2.selectByValue(arrival);
	}

	public void DateSelection(String MonthandYear, String date) {
		while (true) {
			String Daytext = Commondetails.getDriver().findElement(By.xpath("//th[@class='datepicker-switch']"))
					.getText();
			String[] da = Daytext.split(" ");
			// System.out.println(da[0]);
			if (da[0].equalsIgnoreCase(MonthandYear)) {
				break;
			} else {
				Commondetails.getDriver().findElement(By.xpath("//th[@class='next']")).click();
			}
		}
		Commondetails.getDriver()
				.findElement(
						By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + date + ")]"))
				.click();
	}

	public void ReturnDateselection(String returnmonth, String redate) {
		if (Commondetails.getDriver().findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_1']"))
				.isSelected()) {
			while (true) {
				String returndate = Commondetails.getDriver().findElement(By.xpath("//th[@class='datepicker-switch']"))
						.getText();
				if (returndate.equalsIgnoreCase(returnmonth)) {
					break;
				} else {
					Commondetails.getDriver().findElement(By.xpath("//th[@class='next']")).click();
				}
			}
			Commondetails.getDriver()
					.findElement(By.xpath(
							"//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + redate + ")]"))
					.click();
		} /*
			 * else { System.out.println("Oneway Trip"); }
			 */
	}

	public void Adultcount(String ADTcount) {
		Select Adult = new Select(AdultPax);
		Adult.selectByValue(ADTcount);
	}

	public void childpax(String Chcount) {
		Select selectChild = new Select(Child);
		selectChild.selectByValue(Chcount);
	}

	public void infantpax(String InFcount) {
		Select selectInfant = new Select(Infant);
		selectInfant.selectByValue(InFcount);
	}

	public void Searchbutton() {
		searchagin.click();
	}

}
