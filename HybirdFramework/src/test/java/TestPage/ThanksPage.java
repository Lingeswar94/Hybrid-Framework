package TestPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThanksPage {

	
	Logger logger= Logger.getLogger(ThanksPage.class);
private	static ThanksPage thanksPage;
	
	private ThanksPage() {
		
	}
	
	
	public static ThanksPage getThanksPage() {
		
		if(thanksPage==null) {
			thanksPage=new ThanksPage();
		}
		return thanksPage;
	}
	
	@FindBy(xpath = "//input[@id='btnContinue']")
	private WebElement simulation;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement existing;

	@FindBy(xpath = "//h4[@class='rel-pos']")
	private WebElement PNR;

	public void exit() {
		existing.click();
	}

	public void getPNR() {
	String BookingPNR	=PNR.getText();
	logger.info("Booking PNR"+BookingPNR);
	}
}
