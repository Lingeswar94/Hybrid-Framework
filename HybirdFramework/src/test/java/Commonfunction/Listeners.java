package Commonfunction;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners extends Commondetails implements ITestListener {
public static	ExtentReports extentReports;
public static	ExtentTest test;
public static	WebDriver driver;


	@Override
	public void onStart(ITestContext context) {
	
		
	extentReports = ExtentReportdata.Extentreportfunction();
		System.out.println("Execution of project test started");
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extentReports.createTest(result.getName());
		test.log(Status.INFO, result.getName() + " started executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extentReports.createTest(result.getName());
		test.log(Status.PASS, result.getName() + " executed got success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String screenshot = Helper.getFailscreenshot(driver, result.getName());
		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL,result.getName()+"executed got failed " );
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.SKIP,result.getName()+"executed got skiped " );
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finised project got executed");
		extentReports.flush();
		String extentpath=System.getProperty("user.dir")+"/Reports/FCProject"+Helper.getCurrenttime()+".html";
		File file=new File(extentpath);
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
