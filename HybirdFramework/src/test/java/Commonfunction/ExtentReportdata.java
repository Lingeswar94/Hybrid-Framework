package Commonfunction;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportdata {

	public static ExtentSparkReporter Reporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static Properties properties;

	@BeforeClass
	public static ExtentReports Extentreportfunction() {

		properties = new Properties();

		Reporter = new ExtentSparkReporter(
				new String(System.getProperty("user.dir") + "/Reports/FCProject " + Helper.getCurrenttime() + ".html"));
		Reporter.config().setDocumentTitle("Automation Test Report");
		Reporter.config().setReportName("FC Normal Flow Project");
		Reporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(Reporter);
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("Application URL", properties.getProperty("URL"));
		extentReports.setSystemInfo("BRowser Name", properties.getProperty("Browser"));
		return extentReports;

	}

}
