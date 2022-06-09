package com.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DespBarraHome {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	public DespBarraHome(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		PageFactory.initElements(driver, this);
	}
	

	public void recorrerbarra() throws Exception {
		
		List<WebElement> listaElementos = driver.findElements(By.cssSelector(".header-products-container .header-product-item "));   
		
		for (WebElement elementos : listaElementos) {
			elementos.click();
			Thread.sleep(15000);
			WebElement imgElemento = elementos.findElement(By.xpath("//img"));
			Assert.assertTrue(imgElemento.isDisplayed(),"El elemento no es visible");
			
		}
	} //consultar por que solo hace 3 vueltas
}
