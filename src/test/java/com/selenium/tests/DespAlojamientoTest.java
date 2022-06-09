package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.drivers.DriverFactory;
import com.selenium.pages.DespAlojaPage;
import com.selenium.pages.DespPage;
import com.selenium.pages.DespResultPage;

public class DespAlojamientoTest extends DriverFactory {

	 WebDriver driver ;
	
	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		
		String url = context.getCurrentXmlTest().getParameter("URLDesp");
		driver = DriverFactory.AbrirBrowser(navegador,url);
	}
	
	@DataProvider(name = "lugares")
	public Object[][] dataProviderTest(){
		return new Object[][] {{"Córdoba, Córdoba"},{"Capital Federal"},{"Mendoza"}};
	}
	
	
	 @Test(description = "Validar alojamientos", dataProvider="lugares")
	  public void Des(String lugares) throws Exception {
		  
		  DespPage buscar = new DespPage(driver);	
		  
		  buscar.alojamientos();
		  
		  DespAlojaPage alojamientospage = buscar.alojamientos();
		  
		  
		  alojamientospage.ingresarCiudad(lugares);
		  
		  alojamientospage.fechaEntrada();
		  
		  alojamientospage.entendiCook();
		  
		  alojamientospage.fechaSalida();
		  
		  alojamientospage.cantidades();
		  
		  alojamientospage.resultpage();
		  
		  DespResultPage resultadoPage = alojamientospage.resultpage();
		  
		  resultadoPage.validacion();
		  
	  }
	 
	  @AfterMethod
	  public void endSetup() {
		 DriverFactory.CerrarBrowser(driver);
	  }
}
