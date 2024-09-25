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
	private List<WebElement> Fareselection;

	@FindBy(xpath = "//*[@id='btnContinue']")
	private WebElement flightcontinue;

	public void Fareselecting(String fareClass) {

		int x = Fareselection.size();
		// System.out.println(x);
		boolean fareFound = false;
		for (int i = 0; i < x && !fareFound; i++) {
			WebElement fare = Fareselection.get(i);

			String fareClassAttr = fare.getAttribute("class");
			String[] cabin = fareClassAttr.split(" ");
			if (cabin[0].equalsIgnoreCase(fareClass)) {
				// System.out.println(fareClass);
				fare.click();
				fareFound = true;
			}

		}

	}

	public void FlightContiune() {
		flightcontinue.click();
	}

}
