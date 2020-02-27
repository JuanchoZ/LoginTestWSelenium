package test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Class.*;
import Pages.*;

public class TestLoginPageObject {

	   WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  Navegador sele = new Navegador();
	  MainPage Main;
	  SignInPage Sign;
	  AccountPage Accpage;
	  ProductPage Product;
	  CheckOutPage Check;
	  
	  String Url = "http://automationpractice.com/index.php";
	  
	@Before
	public void setUp() throws Throwable {
		
		System.out.println("Starting test");
		
		driver  = sele.navegador();
		Main    = new MainPage(driver);
		Sign    = new SignInPage(driver);
		Accpage = new AccountPage(driver);
	    Product = new ProductPage(driver);
	    Check   = new CheckOutPage(driver);
		driver.get(Url);
	}

	@Test
	public void testLogin() {
        
		//In the main page we assert to be SignOut   and we click Sign in to access the Sign in page\\ 
		assertTrue(Main.CheckUrl());
		assertTrue(Main.CheckSingIn());
	    Main.ClickSignIn();
	    
		//In Sign in page we check the form is visible and we introduce the data\\
		assertTrue(Sign.CheckUrl());
		assertTrue(Sign.CheckSignIn());
		Sign.SigIn();
		
		//In the Account page we assert we are log correctly and we go back to the main page\\
		assertTrue(Accpage.CheckUrl());
		assertTrue(Accpage.CheckLogIn());
		Accpage.ClickHome();
		
		//In the main Page we check we are Log and we proceed  to move around and navigate the page\\
		assertTrue(Main.CheckLogIn());
		assertTrue(Main.CheckUrl());
		Main.Nav();
		assertTrue(Main.CheckSummer());
		Main.ClickDressMore();
		
		//In the product page we Check if we are log and we add a product to the cart\\
		assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?id_product=6&controller=product");
		assertTrue(Product.CheckUrl());
		assertTrue(Product.CheckLogIn());
		assertTrue(Product.CheckCart());
		Product.Buy();
		
		//In the Checkout we Check again, and we proceed with the buy\\
		Check.CheckUrl();
		Check.CheckCheckOut();
		Check.CheckLogIn();
		Check.ProceedCheck();
		Check.ConfirmAddress();
		Check.ConfirmShip();
		assertTrue(Check.CheckBankButton());
		Check.ConfirmeBank();
		Check.LasConf();
		assertTrue(Check.LastCheck());
		Check.Home();
		//We SignOut and Quit the driver\\
		assertTrue(Main.CheckUrl());
		Main.ClickSignOut();
    }
   
    @After
	public void tearDown() throws Exception {
    	System.out.println("Ending test");
    	driver.manage().deleteAllCookies();
    	driver.quit();
	}
}
