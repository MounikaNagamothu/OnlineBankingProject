package com.testng;

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

public class ActionsEx {
	
	WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
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
	public void close() {
		driver.quit();
	}
	
    @Test(groups= {"Smoke"})
	public void actions() {
		
		
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.manage().window().maximize();
		//It is for all the elements in the script
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement enabled = driver.findElement(By.xpath("//a[normalize-space()='Enabled']"));
		WebElement downloads = driver.findElement(By.xpath("//a[normalize-space()='Downloads']"));
		WebElement excel = driver.findElement(By.xpath("//a[normalize-space()='Excel']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(enabled).pause(3000).moveToElement(downloads).pause(3000).moveToElement(excel).click().build().perform();

	}

}