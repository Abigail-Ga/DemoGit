package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main extends Base{

	public Main(WebDriver driver) {
		super(driver);
	}

	/*
	 * Method name: searchProduct Method param: product name (String) Return value:
	 * boolean Author: Hagai
	 */

	public boolean searchProduct(String product) throws InterruptedException {

		//Using general method from Base page
		typeTextSubmit(By.id("search-field"), product);
		
		
		String text = driver.findElement(By.cssSelector(".orders-counter")).getText();

		// Verify results of search
		if (text.contains("פריטים"))
			return true;
		else
			return false;

	}

	/*
	 * Method name: add product to cart Method param: null Return value: boolean
	 * Author: Hagai
	 */

	public boolean addToCart() throws InterruptedException {
		
		click(By.xpath("//*[@id=\"results-boxes\"]/a[1]/div/div[3]"));
		click(By.id("addProductToCart"));

		String text = getText(By.id("cart-number"));
		
		if (text.equals("1"))
			return true;
		else
			return false;
	}
	
	
	
	/* method name: go to main cart, param: null
	 * Author: Hagai
	 * 
	 * 	*/ 

	
	public void goToCart() throws InterruptedException {
//		 Click on the cart logo
		click(By.xpath("//img[@alt='עגלת קניות']"));
	
		// Click on go to cart
		click(By.xpath("//a[@href='/cart']"));
		
	}

	public void goRegistration() {
		click(By.cssSelector("#trigger-signin-overlay > a:nth-child(1)"));

	}
}
