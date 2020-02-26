package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePage extends BasePage{
	
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
   
	By Navcheck = By.xpath("//span[@class='navigation_page'][contains(.,'Authentication')]");
	By Submit   = By.id("submitAccount");
	By Form     = By.id("account-creation_form");
	By Gender   = By.id("id_gender2");
	By CFirst   = By.id("customer_firstname");
	By CLast    = By.id("customer_lastname");
	By Password = By.id("passwd");
	By Newslet  = By.id("newsletter");
	By Days     = By.id("days");
	By Months   = By.id("months");
	By Years    = By.id("years");
	
	public CreatePage(WebDriver driver) {
		super(driver);
	}

	
	public boolean CheckUrl() {
		return CheckOutUrl(Url);
	}
	
	public boolean Chekcs() {
		if (CheckIfExist(Navcheck)&&CheckIfExist(Submit)&&CheckIfExist(Form)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void CreateAcount() {
		
		SendK(CFirst,"Jhpn");
		SendK(CLast,"Jhpn");
		SendK(Password,"12345");
		
		select("18",Days);
		select("4",Months);
		select("1984",Years);
		ClickIt(Newslet);
	}
	
	public void Submit() {
		ClickIt(Submit);
	}
	
	private void ClickIt(By Selector) {
		super.Click(Selector);
	}
	private void SendK(By Selector, String texto) {
		super.SendKeys(Selector, texto);
	}

	private boolean CheckOutUrl(String Url) {
		return super.CheckUrl(Url);
	}

	private boolean CheckIfExist(By Selector) {
		return super.CheckExist(Selector);
	}

	private void select(String i, By selectLocator) {
		super.selectDropDownValue(i, selectLocator);
	}

	private void MouseOverIt(By Selector) {
		super.MouseOver(Selector);
	}

	
	
}
