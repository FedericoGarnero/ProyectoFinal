package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WikiHomePage {

	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	@FindBy(css = ".main-box-responsive-image .main-footer .mw-ui-button")
	private WebElement searchInput;
	
	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		PageFactory.initElements(driver, this);
	}
	

	public WikiResultadoPage busqueda() {
		
		Assert.assertTrue(searchInput.isDisplayed(),"el error nose ve");
	    searchInput.click();
	    
	    return new WikiResultadoPage(this.driver);

	    
	}
}
