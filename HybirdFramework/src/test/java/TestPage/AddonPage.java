package TestPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commonfunction.Commondetails;

public class AddonPage {

	private static AddonPage addonPage;

	private AddonPage() {

	}

	public static AddonPage getAddonPage() {
		if (addonPage == null) {
			addonPage = new AddonPage();
		}
		return addonPage;
	}

	@FindBy(xpath = "//button[@id='btnAddBaggage']")
	public WebElement Baggagebutton;

	@FindBy(xpath = "//input[@id='btnProceedBooking']")
	public WebElement Baggagecontine;
	
	@FindBy(xpath = "//*[@id='divOBSeg0']/div[5]")
	public List<WebElement> seatSelectionElements;

	@FindBy(xpath = "//button[@id='btnAddSeat']")
	public WebElement Seatselection;

	public WebElement getMainPaxBaggage(int index) {
		String MainPaxbagg = "//select[contains(@id,'lvPaxBaggages_ucPaxBaggage_" + index + "_ucOBBaggageInformation_"
				+ index + "')]";
		return Commondetails.getDriver().findElement(By.xpath(MainPaxbagg));
	}

	public WebElement getMainReturnPaxBaggage(int index) {
		String ReturnPaxbagg = "//select[contains(@id,'lvPaxBaggages_ucPaxBaggage_" + index + "_ucIBBaggageInformation_"
				+ index + "')]";
		return Commondetails.getDriver().findElement(By.xpath(ReturnPaxbagg));
	}

	public String availseat() {
		String availseat = Commondetails.getDriver().findElement(By.xpath("//li[@class='availseat']"))
				.getAttribute("class");
		return availseat;
	}

	public WebElement OBSeat(String SeatNo) {
		String OBseat = "//li[@onclick='Javascript:AddSeat('" + SeatNo + "')']";
		return Commondetails.getDriver().findElement(By.xpath(OBseat));
	}

	public List<WebElement> name(String seat) {

		String seatno = "//div[@id='divOBSeatLayout']/div/div[4]/div[5]/ul/li";
		return Commondetails.getDriver().findElements(By.xpath(seatno));

	}

	
	public void seatSelection(int ADTcount, int Chcount, boolean isReturnTrip, boolean addSeat,
			boolean addDepartureSeat, boolean addReturnSeat, String OBMainseat, String OBAdultseat,
			String OBChildseat, String IBMainseat,String IBAdultseat,String IBChildseat) {
// Check if seat selection is enabled
		if (!addSeat) {
			System.out.println("Seat is not selected for this booking");
			return;
		}

// Click on Seat Selection
		Seatselection.click();
		System.out.println("Seat" + OBMainseat);
		System.out.println("Seat" + OBChildseat);
// Departure Seat Selection
		if (addDepartureSeat) {
			OBselectSeats(ADTcount, Chcount, OBMainseat, OBAdultseat, OBChildseat);
		} else {
			System.out.println("Departure Seat is not selected");
		}

// Return Seat Selection (if applicable)
		if (isReturnTrip && addReturnSeat) {
			IBselectSeats(ADTcount, Chcount, IBMainseat, IBAdultseat, IBChildseat);
		}else {
			System.out.println("Arrival Seat is not selected");
		}
	}

	
	public void OBselectSeats(int ADTcount, int Chcount, String OBMainseat, String OBAdultseat, String OBChildseat) {
		WebDriverWait wait = new WebDriverWait(Commondetails.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(seatSelectionElements));

		int Adult = ADTcount + 1;
		int totalSeats = Adult + Chcount;
		System.out.println(totalSeats);
		int currentADTseat = 0;
		int currentChseat = 0;

		for (int i = 0; i < totalSeats; i++) {
			if (currentADTseat < Adult) {
				if (currentADTseat == 0) {
					getSeat(OBMainseat).click();
				} else {
					getSeat(OBAdultseat).click();
				}
				currentADTseat++;
			} else if (currentChseat < Chcount) {
				getSeat(OBChildseat).click();
				currentChseat++;
			} else {
				System.out.println("Departure Addon Seat is not selected");
			}
		}

	}
	
	public void IBselectSeats(int ADTcount, int Chcount, String IBMainseat, String IBAdultseat, String IBChildseat) {
		int Adult = ADTcount + 1;
		int totalSeats = Adult + Chcount;

		int currentADTseat = 0;
		int currentChseat = 0;

		for (int i = 0; i < totalSeats; i++) {
			if (Adult > currentADTseat) {
				if (currentADTseat == 0) {
					getSeat(IBMainseat).click();
				} else {
					getSeat(IBAdultseat).click();
				}
				currentADTseat++;
			} else if (currentChseat < Chcount) {
				getSeat(IBChildseat).click();
				currentChseat++;
			} else {
				System.out.println("Arrival Addon Seat is not selected");
			}
		}
	}
	
	
	
	public void selectBaggage(int ADTcount, int Chcount, boolean isReturnTrip, boolean addBaggage,
			boolean addDepartureBaggage, boolean addReturnBaggage, String Baggagename) {

		// If the user does not want to add baggage, skip the baggage selection process
		if (!addBaggage) {

			System.out.println("No baggage selected for this booking.");
			return; // Skip the baggage selection if baggage is not needed
		} 
			Baggagebutton.click();
		

		// Check if departure baggage is needed
		if (addDepartureBaggage) {
			DepartureAddBaggage(ADTcount, Chcount, Baggagename);
		} else {
			System.out.println("Departure baggage is not selected.");
		}

		// Check if return baggage is needed
		if (isReturnTrip && addReturnBaggage) {
			ReturnAddBaggage(ADTcount, Chcount, Baggagename);
		} else {
			System.out.println("Return baggage is not selected.");
		}
	}

	public void DepartureAddBaggage(int ADTcount, int Chcount, String Baggage) {

		int adult = ADTcount + 1;
		int totalPassengers = adult + Chcount;
		// System.out.println(totalPassengers);
		// System.out.println("ADTBaggCount: " + (ADTcount + 1) + ", ChBaggcount: " +
		// Chcount);

		int currentADTBagg = 0;
		int currentChBagg = 0;

		for (int index = 0; index < totalPassengers; index++) {
			if (currentADTBagg < adult) {
				if (currentADTBagg == 0) {
					getMainPaxBaggage(index, Baggage);
				} else {
					getAdultPaxBaggage(index, Baggage);

				}
				currentADTBagg++;
			} else if (currentChBagg < Chcount) {
				getChildPaxBaggage(index, Baggage);
				currentChBagg++;
			} else {
				System.out.println("Departure Addon Baggage is not selected ");
			}
		}
	}

	public void ReturnAddBaggage(int ADTcount, int Chcount, String Baggagename) {

		// int index=0;
		int adult = ADTcount + 1;
		int totalPassengers = adult + Chcount;
		// System.out.println(totalPassengers);
		// System.out.println("ADTBaggCount: " + (ADTcount + 1) + ", ChBaggcount: " +
		// Chcount);

		int currentADTBagg = 0;
		int currentChBagg = 0;
		for (int index = 0; index < totalPassengers; index++) {
			if (currentADTBagg < adult) {
				if (currentADTBagg == 0) {
					getReturnMainPaxBaggage(index, Baggagename);
				} else {
					getReturnAdultPaxBaggage(index, Baggagename);

				}
				currentADTBagg++;
			} else if (currentChBagg < Chcount) {
				getReturnChildPaxBaggage(index, Baggagename);
				currentChBagg++;
			} else {
				System.out.println("Return Addon Baggage is not selected ");
			}
		}

	}

//Generic method to fetch and click seat and Baggage WebElement
			public WebElement getSeat(String OBMainseat) {
				String xpath = "//li[@class='availseat' and contains(@onclick, \"AddSeat('" + OBMainseat + "')\")]";
				return Commondetails.getDriver().findElement(By.xpath(xpath));
			}

	public void getMainPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getAdultPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getChildPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getReturnMainPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getReturnAdultPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getReturnChildPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	

}
