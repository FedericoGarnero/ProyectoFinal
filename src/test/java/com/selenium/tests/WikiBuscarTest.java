package com.selenium.tests;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.drivers.DriverFactory;
import com.selenium.pages.WikiHomePage;


public class WikiBuscarTest extends DriverFactory{
	
	
	WebDriver driver = null;
	WikiHomePage buscar = null;
	
	

	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		
		String url = context.getCurrentXmlTest().getParameter("URLWiki");
		
		driver = DriverFactory.AbrirBrowser(navegador, url);
	}
	

	@Test(description = "Validar que la usqueda funcione")
	public void testWiki() {
		WikiHomePage buscar = new WikiHomePage(driver);
		
		buscar.busqueda();
	}
	
	  @AfterMethod
	  public void endSetup() {
		 DriverFactory.CerrarBrowser(driver);
	  }
	  
}
