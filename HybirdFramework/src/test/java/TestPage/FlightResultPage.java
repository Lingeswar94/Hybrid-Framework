package TestPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightResultPage {

	private static FlightResultPage flightResultPage;

	private FlightResultPage() {

	}

	public static FlightResultPage getFlightResultPage() {
		if (flightResultPage == null) {
			flightResultPage = new FlightResultPage();
		}
		return flightResultPage;
	}

	@FindBy(xpath = "//div[@id='divOBFlightResults']/div/div/ul/li")
	private List<WebElement> OBFareselection;

	@FindBy(xpath = "//div[@id='divIBFlightResults']/div/div/ul/li")
	private List<WebElement> IBFareselection;

	@FindBy(xpath = "//*[@id='btnContinue']")
	private WebElement flightcontinue;

	public void Fareselecting(String OBfareClass, String IBfareClass) {

		// Outbound flight selection
		if (true) {
			selectFare(OBFareselection, OBfareClass);

		}

		// If it's a return trip, select fare for inbound flight as well
		if (!IBFareselection.isEmpty()) {
			selectFare(IBFareselection, IBfareClass);
		}
	}

	public void selectFare(List<WebElement> flightResults, String fareClass) {
		int flightCount = flightResults.size();
		boolean fareFound = false;

		for (int i = 0; i < flightCount && !fareFound; i++) {
			WebElement fare = flightResults.get(i);
			String fareClassAttr = fare.getAttribute("class");
			String[] cabin = fareClassAttr.split(" ");

			if (cabin[0].equalsIgnoreCase(fareClass)) {
				fare.click();
				fareFound = true;

			}
		}

		if (!fareFound) {
			System.out.println("Fare class not found: " + fareClass);
		}
	}

	public void FlightContiune() {
		flightcontinue.click();
	}

}
