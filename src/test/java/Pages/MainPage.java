package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
	
	String Url    = "http://automationpractice.com/index.php";
    By Selector   = By.linkText("Sign in");
    By SignOut    = By.linkText("Sign out"); 
    By Account    = By.xpath("//span[contains(.,'Jack jp')]");
    By Popular    = By.className("homefeatured");
    By BestSeller = By.className("blockbestsellers");
    By TSHIRTS    = By.linkText("T-SHIRTS");
    By WOMEN      = By.linkText("WOMEN");
    By Dresses    = By.linkText("DRESSES");
    By Summer     = By.xpath("(//a[contains(.,'Summer Dresses')])[3]");
    By SummerAser = By.xpath("//span[@class='category-name'][contains(.,'Summer Dresses')]");
    By DressMore  = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line hovered']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]");
    By Move       = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']//img[@class='replace-2x img-responsive']");
    
	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void Nav() {
		ClickIt(Popular);
		ClickIt(BestSeller);
		ClickIt(WOMEN);
		ClickIt(TSHIRTS);
	    ClickIt(Dresses);
	    ClickIt(Summer);
	}
	
	
	
	public boolean CheckLogIn() {
		if (CheckIfExist(SignOut) && CheckIfExist(Account)) {
			return true;
		}else {
			  return false;
		}
	}
	
	public boolean CheckSummer() {
		return CheckIfExist(SummerAser);
	}
	
	public boolean CheckSingIn() {
		return CheckIfExist(Selector);
	} 
	
	public boolean CheckUrl() {
		return CheckOutUrl(Url);
	}
	
	public void ClickSignIn() {
		ClickIt(Selector);
	}
	
	public void ClickSignOut() {
		ClickIt(SignOut);
	}
	
	public void ClickDressMore() {
		Mouse(Move);
		ClickIt(DressMore);
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

	private void WaitIt(By Selector) {
		super.Wait(Selector);
	}

	private void Mouse(By Selector) {
		super.MouseOver(Selector);
	}
}
