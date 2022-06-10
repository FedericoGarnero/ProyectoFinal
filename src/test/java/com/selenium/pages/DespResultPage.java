package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DespResultPage {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	@FindBy(css = ".sub-nav-corners-container")
	private WebElement searchimput;
	
	@FindBy(css = "h1.sbox5-title")
	private WebElement textAlojamiento;
	
	public DespResultPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		PageFactory.initElements(driver, this);
	}
	
	public void validacionAlojamientos() {
		Assert.assertTrue(searchimput.isDisplayed(),"Error no se ve el la barra");
		Assert.assertEquals(textAlojamiento.getText(), "Alojamientos");
	}
}
