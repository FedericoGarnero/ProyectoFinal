package com.selenium.tests;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.drivers.DriverFactory;
import com.selenium.pages.WikiHomePage;


public class WikiBuscarTest extends DriverFactory{

	@Test(description = "Validar que la usqueda funcione")
	  public void BuscarWiki() throws Exception {
		  
		  WebDriver driver = DriverFactory.AbrirBrowser("CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
		  WikiHomePage buscar = new WikiHomePage(driver);	
		  
		  buscar.busqueda();
		  
		  
		  DriverFactory.CerrarBrowser(driver);
		  
	  }
}
