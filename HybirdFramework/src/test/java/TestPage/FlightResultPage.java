package TestPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightResultPage {

	public static WebDriver driver;

	public FlightResultPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//div[@id='divOBFlightResults']/div/div/ul/li")
	public List<WebElement> Fareselection;

	@FindBy(xpath = "//*[@id='btnContinue']")
	public WebElement flightcontinue;

	public void Fareselecting(String fareClass) {

		int x = Fareselection.size();
		System.out.println(x);
		boolean fareFound = false;
		for (int i = 0; i < x && !fareFound;i++) {
			WebElement fare = Fareselection.get(i);
			String fareClassAttr = fare.getAttribute("class");
			if (fareClassAttr.equalsIgnoreCase(fareClass)) {
				System.out.println(fareClass);
				fare.click();
				fareFound = true;
			} 
			else  {
				System.out.println("No suitable fare found.");
			}
		}
		

	}

	public void FlightContiune() {
		flightcontinue.click();
	}

}
