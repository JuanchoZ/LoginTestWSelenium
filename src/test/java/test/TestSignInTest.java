package test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Class.*;
import Pages.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

@RunWith(JUnitParamsRunner.class)
public class TestSignInTest {

	WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Navegador sele = new Navegador();
	MainPage Main;
	SignInPage Sign;
	AccountPage Accpage;
	CreatePage Create;
	
	String Url = "http://automationpractice.com/index.php";
	
	@Before
	public void setUp() throws Throwable {
		
		System.out.println("Starting test");
		
		driver  = sele.navegador();
		Main    = new MainPage(driver);
		Sign    = new SignInPage(driver);
		Accpage = new AccountPage(driver);
		Create  = new CreatePage(driver);
		
	}

	@Test
	public void testSignIn() {
		
		driver.get(Url);
		//In The main page we assert to be SignOut and we click SignIn to get to the Sign in page\\
		assertTrue(Main.CheckUrl());
		assertTrue(Main.CheckSingIn());
		Main.ClickSignIn();
		
		//In Sign we check the form to be displayed and we type the Email and CLick to move to the SignIn page\\
		assertTrue(Sign.CheckUrl());
		assertTrue(Sign.CheckSignIn());
		Sign.Create();
		
		//In the create Account page we assert the form to be present and we proceed with the creation process\\
		//assertTrue(Create.CheckUrl());
		assertTrue(Create.Chekcs());
		Create.CreateAcount();
	}
	
	@Test
	@TestCaseName(value = "{index}{method} Navegador = {0}")
	@FileParameters("src\\test\\resources\\Email.csv")
	public void WrongEmail(String email)
	{
		driver.get(Url);
		Main.ClickSignIn();
		Sign.CreatePara(email);
		//assertTrue(Create.CheckUrl());
		assertTrue(Create.Chekcs());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending test");
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
