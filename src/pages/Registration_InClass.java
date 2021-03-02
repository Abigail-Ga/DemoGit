package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Registration_InClass extends Base {

	public Registration_InClass(WebDriver driver) {
		super(driver);
	}

	public boolean verifyErrorsInRegistration_FirstName(String expectedErrMsg) {
		// Click on WebElement
		click(By.id("registration-name"));

		// SendKey
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();

		String errorMsg = getText(By.xpath("//form[@id=\"spRegisterForm\"]/div[3]/label[2]/ul/li"));

		if (errorMsg.equals(expectedErrMsg))
			return true;
		else
			return false;
	}
	
	public boolean verifyErrorsInRegistration_LastName(String expectedErrMsg) {
		// Click on WebElement
		click(By.id("registration-last-name"));

		// SendKey
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();

		String errorMsg = getText(By.xpath("//form[@id=\"spRegisterForm\"]/div[4]/label[2]/ul/li"));

		if (errorMsg.equals(expectedErrMsg))
			return true;
		else
			return false;
	}
	
	public boolean verifyErrorsInRegistration_Password(String expectedErrMsg) {
		// Click on WebElement
		click(By.id("registration-password"));

		// SendKey
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();

		String errorMsg = getText(By.xpath("//form[@id=\"spRegisterForm\"]/div[6]/div/label[2]/ul/li"));

		if (errorMsg.equals(expectedErrMsg))
			return true;
		else
			return false;
	}

}
