package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.drivers.DriverFactory;
import com.selenium.pages.DespBarraHome;
import com.selenium.pages.WikiHomePage;

public class DespBarraTest extends DriverFactory{

	WebDriver driver = null;
	WikiHomePage buscar = null;
	
	

	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		
		String url = context.getCurrentXmlTest().getParameter("https://despegar.com.ar");
		
		driver = DriverFactory.AbrirBrowser(navegador, "https://despegar.com.ar");
	}
	
	

	@Test(description = "Validar que la barra funcione")
	public void testBarra() {
		DespBarraHome barra = new DespBarraHome(driver);
	    try {
			barra.recorrerbarra();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	  @AfterMethod
	  public void endSetup() {
		 DriverFactory.CerrarBrowser(driver);
	  }
}
