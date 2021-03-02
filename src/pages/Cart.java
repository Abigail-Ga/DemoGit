package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart extends Base{
	
	
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	
	
	/*
	 * Method name: Remove product from cart param: null Return boolean(True/False):
	 * boolean Author: Hagai
	 */

	public boolean removeProductFromCart() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("search-field"))).build().perform();
			
		click(By.xpath("//div[@id=\"shoppingCart\"]/main/ul/div[2]/button"));		
		String text = getText(By.cssSelector("#emptyCart .empty-headline"));
		
		if (text.contains("סל הקניות שלך ריק"))
			return true;
		else
			return false;
	}
	
	

}
