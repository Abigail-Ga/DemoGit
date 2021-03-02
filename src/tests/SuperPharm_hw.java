package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Cart;
import pages.Main;
import pages.Registration;
import utilites.GetDriver;
import utilites.Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class SuperPharm_hw {

	// Global variables 
	// Add extent reports
	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\SuperPharm.html";

	private WebDriver driver;
	private String baseUrl;
	
	
	//pages
	private Main main;
	private Registration registration;
	

	@BeforeClass
	public void beforeClass() {
		extent = new ExtentReports(reportPaht);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\resources\\superpharm-.xml"));
		baseUrl = "https://shop.super-pharm.co.il/";
		driver = GetDriver.getDriver("chrome", baseUrl);
		main = new Main(driver);
		registration = new Registration(driver);
	}

	
	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
	}
	
	/*  Prerequisite: 
	 * 		Given: client is in SuperPharm registration page
	 * 		When: client try to continue without filling data
	 *  	Errors message appear
	 */
	
	@Test(priority = 1, enabled = true, description = "Error message text First name field")
	public void errorMessageFirsname() throws InterruptedException, IOException {	
		main.goRegistration();
		Assert.assertTrue(registration.verifyErrorsFerstName(), "could not verify error message");
	}
	
	@Test(priority = 2, enabled = true, description = "Error message text Last name field")
	public void errorMessageLastname() throws InterruptedException, IOException {	
		Assert.assertTrue(registration.verifyErrorsLastName(), "could not verify error message");
	}
	
	@Test(priority = 3, enabled = true, description = "Error message text Email field")
	public void errorMessageEmail() throws InterruptedException, IOException {	
		Assert.assertTrue(registration.verifyErrorsEmail(), "could not verify error message");
	}
	
	@Test(priority = 4, enabled = true, description = "Error message text Password field")
	public void errorMessagePassword() throws InterruptedException, IOException {	
		Assert.assertTrue(registration.verifyErrorsPassword(), "could not verify error message");
	}
	
	@Test(priority = 5, enabled = true, description = "Error message text Verify password field")
	public void errorMessageVerifypassword() throws InterruptedException, IOException {	
		Assert.assertTrue(registration.verifyErrorsVerifypassword(), "could not verify error message");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			myTest.log(LogStatus.FAIL, "Test failed: " + result.getName());
			myTest.log(LogStatus.FAIL, "Test failed reason: " + result.getThrowable());
			myTest.log(LogStatus.FAIL, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		}
		else {
			myTest.log(LogStatus.PASS, result.getName(), "Verify successful ");
			myTest.log(LogStatus.PASS, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));

		}

		myTest.log(LogStatus.INFO, "Finish test", "Finish test ");
		extent.endTest(myTest);
	
		//return to base URL 
		//driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		extent.close();
		driver.quit();

	}

	
}
