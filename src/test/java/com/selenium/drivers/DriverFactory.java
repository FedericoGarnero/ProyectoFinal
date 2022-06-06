package com.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DriverFactory {
	
	public static WebDriver AbrirBrowser(String browserName, String url){
		WebDriver driver = null;
		switch(browserName){
			case "CHORME":
			{
				System.setProperty("webdriver.chrome.driver", "C:/Users/fedec/Downloads/ChromeDriver/2/chromedriver.exe");  
				Reporter.log("Abrir Navegador Chrome");
				driver = new ChromeDriver();
				break;
			}
			case "FIREFOX":
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\fedec\\Downloads\\gekodriver\\geckodriver.exe");  
				Reporter.log("Abrir Navegador Firefox");
				driver = new FirefoxDriver();
				break;
			}
			default:
			{
				Reporter.log("No se seleciono ningun navegador");
				System.setProperty("webdriver.chrome.driver", "C:/Users/fedec/Downloads/ChromeDriver/2/chromedriver.exe");  
				Reporter.log("Abrir Navegador Chrome");
				driver = new ChromeDriver();
				break;
				
			}
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		
		
		
		return driver;
	}
	
	public static void CerrarBrowser(WebDriver driver) {
		driver.quit();
	}
}
