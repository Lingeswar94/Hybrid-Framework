package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddonPage {
	static WebDriver driver;
	
	public AddonPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	//@FindBy (xpath="//button[@id='btnAddBaggage']")
	//public static WebElement Baggage;
	
	//@FindBy (xpath="//select[@id='lvPaxBaggages_ucPaxBaggage_0_ucOBBaggageInformation_0_0PaxddlOBBaggages0_0']")
	//public static WebElement bagselect;
	
	//@FindBy (xpath="//select[@id='lvPaxBaggages_ucPaxBaggage_0_ucOBBaggageInformation_0_0PaxddlOBBaggages0_0']//option[@value='1']")
	//public static WebElement baggageselection;
	
	@FindBy (xpath="//input[@id='btnProceedBooking']")
	public static WebElement Addonctn;
	
	
	public void AddonContinuebutton() {
		Actions actions=new Actions(driver);
		actions.moveToElement(AddonPage.Addonctn);
		actions.click().build().perform();
	}
}
