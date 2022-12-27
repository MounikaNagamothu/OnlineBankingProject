package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAndHoldEx {
WebDriver driver;
	
	@BeforeMethod
	@Parameters(value= {"Browser"})
	public void launch(String browser) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		if(browser.toLowerCase().contains("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.toLowerCase().contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.toLowerCase().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test(groups= {"Regression"})
	public void clickandhold() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		//It is for all the elements in the script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Swithch to Frame
		driver.switchTo().frame(0);
		
		List<WebElement> li = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions a =new Actions(driver);
		a.clickAndHold(li.get(0)).moveToElement(li.get(4)).release().build().perform();
		
		

	}

}