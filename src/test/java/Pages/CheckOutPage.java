package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{
	
	String Url     = "http://automationpractice.com/index.php?controller=order";
    By SignOut     = By.linkText("Sign out"); 
	By Account     = By.xpath("//span[contains(.,'Jack jp')]");
	By CheckOut    = By.id("order-detail-content");
	By KeepCheck   = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
	By Adress      = By.id("ordermsg");
    By CheckAdress = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
	By Ship        = By.id("delivery_option_240971_0");
    By Terms       = By.id("cgv");
    By keepShips   = By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
    By BankWire    = By.xpath("//a[@class='bankwire']//span[contains(text(),'(order processing will be longer)')]");
    By LastButton  = By.xpath("//span[contains(text(),'I confirm my order')]");
    By LastCheck   = By.cssSelector("body.order-confirmation.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 > div.box");
    By Home        = By.xpath("//i[contains(@class,'icon-home')]");
    
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	
	public boolean CheckLogIn() {
		if (CheckIfExist(SignOut) && CheckIfExist(Account)) {
			return true;
		}else {
			  return false;
		}
	}
	
	public void ProceedCheck() {
		ClickIt(KeepCheck);	
    }
	
	public void ConfirmAddress() {
		ClickIt(Adress);
		ClickIt(CheckAdress);
	}
	
	public void ConfirmShip() {
		ClickIt(Ship);
		ClickIt(Terms);
		ClickIt(keepShips);
	} 
	
	public void ConfirmeBank(){
		ClickIt(BankWire);
	}	
	
	public void LasConf() {
		ClickIt(LastButton);
	}
	
	public void Home() {
		ClickIt(Home);
	}
	
	public boolean LastCheck() {
		return CheckIfExist(LastCheck);
	}
	
	public boolean CheckBankButton() {
		return CheckIfExist(BankWire);	
	}
	
	public boolean CheckCheckOut() {
		return CheckIfExist(CheckOut);	
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

	private void send(By Selector,String texto) {
		super.SendKeys(Selector, texto);
	}
	
	private void WaitIt(By Selector) {
		super.Wait(Selector);
	}

}
