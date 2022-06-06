package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespPage {

	@FindBy(css = ".shifu-3-header .header-products-container [href=\"//www.despegar.com.ar/hoteles/\"]")
	private WebElement aloja;
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	public DespPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		PageFactory.initElements(driver, this);
	}
	
	public DespAlojaPage alojamientos() {
		aloja.click();
		
		return new DespAlojaPage(this.driver);
	}
}
