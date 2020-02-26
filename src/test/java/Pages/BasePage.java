package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;

	public BasePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void Click(By Selector) {
		driver.findElement(Selector).click();
	}
	
	public void Clear(By Selector) {
		driver.findElement(Selector).clear();
	}
	
	public void SendKeys(By Selector,String texto) {
		driver.findElement(Selector).sendKeys(texto);
	}
	
	public void Submit(By Selector) {
		driver.findElement(Selector).submit();
	}
	
	public List<WebElement>getList(By selector){
		return driver.findElements(selector);
	}
	
	public boolean CheckUrl(String Url) {
		if (driver.getCurrentUrl().equals(Url)) {
			return true;
		} else return false;
	}
	
	public boolean CheckExist(By Selector) {
		if (driver.findElement(Selector).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void selectDropDownIndex(int i, By selectLocator) {
        Select select = new Select(driver.findElement(selectLocator));
                               select.selectByIndex(i);;        
    }
	
	public void selectDropDownValue(String i, By selectLocator) {
        Select select = new Select(driver.findElement(selectLocator));
                               select.selectByValue(i);        
    }
	
	public void selectDropDownText(String i, By selectLocator) {
        Select select = new Select(driver.findElement(selectLocator));
                               select.selectByVisibleText(i);        
    }
	
	public void Wait(By Selector) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(Selector));
        driver.findElement(Selector).click();
	}
	
	public void MouseOver(By Selector) {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(Selector)).build().perform();
	}
}
