package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{
	
	String Url  = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	double Num     = Math.random()*10; 
	
	By Mail     = By.id("email");
    By Password = By.id("passwd");
	By Submit   = By.id("SubmitLogin");
	By Form     = By.id("create-account_form");
	By NewEmail = By.id("email_create");
    By Create   = By.id("SubmitCreate");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public void SigIn() {
		
		ClickIt(Mail);
		  SendThemKeys(Mail,"juan4@gmail.com");
		ClickIt(Password);
		  SendThemKeys(Password,"12345");
		ClickIt(Submit);
	}
		
	public void Create() 
	{	
		ClickIt(NewEmail);
		  SendThemKeys(NewEmail,"jhpn"+Num+"@gmail.com");
		ClickIt(Create);
	}
	
	public void CreatePara(String text) 
	{	
		ClickIt(NewEmail);
		  SendThemKeys(NewEmail,text);
		ClickIt(Create);
	}
	
	public boolean CheckForm() {
		return CheckIfExist(Form);
	}
	
	public boolean CheckSubmit() {
		return CheckIfExist(Submit);
	}
	
	public boolean CheckSignIn() {
		if(CheckForm() == true && CheckSubmit() == true) {
			return true;
		} else {
		    return false;
		}
	}
	
	public boolean CheckUrl() {
		return CheckOutUrl(Url);
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
