package Commonfunction;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import TestPage.AddonPage;
import TestPage.FlightResultPage;
import TestPage.PassengerPage;
import TestPage.PaymentPage;
import TestPage.SearchPage;
import TestPage.ThanksPage;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Helper {

	public static WebDriver driver;

	public static String getFailscreenshot(WebDriver driver, String screenshotName) {

		String screenshotDir = System.getProperty("user.dir") + "/NewScreenshot/FCfailTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			//System.out.println("Fail Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;
	}

	public static String getskipScreenshot(WebDriver driver, String screenshotName) throws IOException, AWTException {

		String screenshotDir = System.getProperty("user.dir") + "/NewScreenshot/FCskipTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Skip Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;
	}

	public static String getscreenshotcapture(WebDriver driver, String screenshotName) {

		String screenshotDir = System.getProperty("user.dir") + "/NewScreenshot/FCsuccessTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;

	}

	public static String getscreenshotbase64() {
		return	((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		 
	}
	
	public static void initElement() {
		PageFactory.initElements(Commondetails.getDriver(), SearchPage.getSearchPage());
		PageFactory.initElements(Commondetails.getDriver(), FlightResultPage.getFlightResultPage());
		PageFactory.initElements(Commondetails.getDriver(), PassengerPage.getPassengerPage());
		PageFactory.initElements(Commondetails.getDriver(), AddonPage.getAddonPage());
		PageFactory.initElements(Commondetails.getDriver(), PaymentPage.getPaymentPage());
		PageFactory.initElements(Commondetails.getDriver(), ThanksPage.getThanksPage());
	}

	public static String getCurrenttime() {

		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		return currentdate;
	}
}
