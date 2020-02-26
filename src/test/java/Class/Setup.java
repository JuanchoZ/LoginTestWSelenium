package Class;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

	  WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	public WebDriver setup() {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.manage().window().setSize(new Dimension(1050, 708));
	    driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		return driver;
	}
}
