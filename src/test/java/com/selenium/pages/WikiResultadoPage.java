package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WikiResultadoPage {
	@FindBy(id="firstHeading")
	
	private WebElement titulo;
	private WebDriver driver = null;
	
	public WikiResultadoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validar() {
		System.out.println("Texto encontrado: "+ titulo.getText());
		Assert.assertEquals(titulo.getText(), "Autobiografía de Rojo");
	}
}
