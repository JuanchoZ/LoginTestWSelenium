package Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Navegador {

	WebDriver driver;
	public DriverList browser;
	
	public void Ending ()
	{
		try {
			driver.manage().deleteAllCookies();
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
				{
				
				}
			driver.quit();
			if(browser == DriverList.IE)
			{
				try {
					Runtime.getRuntime().exec("taskkill /F /IM iexplore.es");
					
				} catch (Exception e) {
					
				}
			}
			
			
		} catch (Throwable t) {
			
		}
	}
	
	public WebDriver navegador() throws Throwable
	{
		 try {
			driver = null;
			 
			 String browserName = System.getProperty("browser", DriverList.ANDROID.toString());
			 browser = DriverList.valueOf(browserName);
			switch (browser) {
			case CHROME:
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case EDGE:
				
				System.setProperty("webdriver.edge.driver", "C:\\Users\\usuario\\.m2\\repository\\webdriver\\MicrosoftWebDriver\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				break;
			case OPERA:
				
				WebDriverManager.operadriver().setup();
				OperaOptions oOptions = new OperaOptions();
				oOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				oOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				oOptions.setBinary("C:\\Users\\usuario\\AppData\\Local\\Programs\\Opera\\66.0.3515.115\\opera.exe");
				driver = new OperaDriver(oOptions);
				break;
			case IE:
				
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case ANDROID:
				
				DesiredCapabilities capa = new DesiredCapabilities().android();
				
				driver = new SelendroidDriver(capa);
				break;
			default:
				break;
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(browser != DriverList.ANDROID)
			{
				driver.manage().window().maximize();
			}
			return driver;
		} catch (Exception e) {
			throw e;
		}
	}
}
