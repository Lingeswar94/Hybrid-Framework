package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThanksPage {

	static WebDriver driver;
	
	public ThanksPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(xpath = "//input[@id='btnContinue']")
	public static WebElement simulation;

	@FindBy(xpath = "//button[@type='button']")
	public static WebElement existing;

	@FindBy(xpath = "//h4[@class='rel-pos']")
	public static WebElement PNR;

	public void exit() {
		existing.click();
	}
}
