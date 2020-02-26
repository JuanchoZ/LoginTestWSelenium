package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
	
	String Url  = "http://automationpractice.com/index.php?controller=my-account";
    By SignOut  = By.linkText("Sign out");
    By Account  = By.className("header_user_info");
	By Home     = By.linkText("Home");
    
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean CheckLogIn() {
		if (CheckIfExist(SignOut) && CheckIfExist(Account)) {
			return true;
		}else {
			  return false;
		}
	}
	
	public boolean CheckUrl() {
		return CheckOutUrl(Url);
	}
	
	public void ClickHome() {
		 ClickIt(Home);
	}
	
	
	private void ClickIt(By Selector) {
		super.Click(Selector);
	}

	private void SendThemKeys(By Selector, String texto) {
		super.SendKeys(Selector, texto);
	}

	private void SubmitIt(By Selector) {
		super.Submit(Selector);
	}

	private boolean CheckOutUrl(String Url) {
		return super.CheckUrl(Url);
	}

	private boolean CheckIfExist(By Selector) {
		return super.CheckExist(Selector);
	}
}
