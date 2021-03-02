package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Registration extends Base{

	public Registration(WebDriver driver) {
		super(driver);
	}

	public boolean verifyErrorsFerstName() throws InterruptedException {
		click(By.cssSelector("registration-name"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		getText(By.xpath("//*[@id=\"spRegisterForm\"]/div[3]/label[2]/ul/li"));
		
		return true;
	}
	
	public boolean verifyErrorsLastName() throws InterruptedException {
		click(By.cssSelector("registration-last-name"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		getText(By.xpath("//*[@id=\"spRegisterForm\"]/div[4]/label[2]/ul/li"));
		
		return true;
	}
	
	public boolean verifyErrorsEmail() throws InterruptedException {
		click(By.cssSelector("#registration-email"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		getText(By.xpath("//*[@id=\"spRegisterForm\"]/div[5]/label[2]/ul/li"));
		
		return true;
	}
	
	public boolean verifyErrorsPassword() throws InterruptedException {
		click(By.cssSelector("#registration-password"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		getText(By.xpath("//*[@id=\"spRegisterForm\"]/div[6]/div/label[2]/ul/li"));
		
		return true;
	}
	
	public boolean verifyErrorsVerifypassword() throws InterruptedException {
		click(By.cssSelector("#registration-password"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		getText(By.xpath("//*[@id=\"spRegisterForm\"]/div[7]/div/label[2]/ul/li"));
		
		return true;
	}

}
