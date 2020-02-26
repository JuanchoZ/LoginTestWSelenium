package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
	
	String Url    = "http://automationpractice.com/index.php?id_product=6&controller=product";
    By SignOut    = By.linkText("Sign out"); 
    By Account    = By.xpath("//span[contains(.,'Jack jp')]");
    By DropDown   = By.id("group_1");
    By Color      = By.id("color_8");
    By AddCart    = By.id("add_to_cart");
    By Checkout   = By.xpath("//span[contains(.,'Proceed to checkout')]");
    
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void Buy() {
		selectDropDownByValue("1",DropDown);
	    ClickIt(Color);
	    ClickIt(AddCart);
	    ClickIt(Checkout);
	}
	public boolean CheckLogIn() {
		if (CheckIfExist(SignOut) && CheckIfExist(Account)) {
			return true;
		}else {
			  return false;
		}
	}
	
	public boolean CheckCart() {
		return CheckIfExist(AddCart);
	}	
	
	public boolean CheckUrl() {
		return CheckOutUrl(Url);
	}
	
	
	private void ClickIt(By Selector) {
		super.Click(Selector);
	}

	private boolean CheckOutUrl(String Url) {
		return super.CheckUrl(Url);
	}

	private boolean CheckIfExist(By Selector) {
		return super.CheckExist(Selector);
	}

	private void selectDropDownByValue(String i, By selectLocator) {
		super.selectDropDownValue(i, selectLocator);
	}
    
	private void Mouse(By Selector) {
		super.MouseOver(Selector);
	}
}
