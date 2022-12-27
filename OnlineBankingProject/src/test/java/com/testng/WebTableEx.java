package com.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableEx {
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
	@Test

	public void webtable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		
		//Get rows and columns
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		
		for(int i=1;i<=rows.size();i++) {
			for(int j=1;j<cols.size();j++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
				System.out.println("row:"+ i +" column:"+ j +" Text::"+ text);
			}
		}
		
	}

}