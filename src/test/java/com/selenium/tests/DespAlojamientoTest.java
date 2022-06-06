package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.drivers.DriverFactory;
import com.selenium.pages.DespAlojaPage;
import com.selenium.pages.DespPage;
import com.selenium.pages.DespResultPage;

public class DespAlojamientoTest extends DriverFactory {

	 @Test(description = "Validar alojamientos")
	  public void Des() throws Exception {
		  
		  WebDriver driver = DriverFactory.AbrirBrowser("CHROME", "https://www.despegar.com.ar/");
		  
		  
		  DespPage buscar = new DespPage(driver);	
		  
		  
		  buscar.alojamientos();
		  
		  DespAlojaPage alojamientospage = buscar.alojamientos();
		  
		  alojamientospage.ingresarCiudad("Cordoba, cordoba");
		  
		  alojamientospage.fechaEntrada();
		  
		  alojamientospage.entendiCook();
		  
		  alojamientospage.fechaSalida();
		  
		  alojamientospage.cantidades();
		  
		  alojamientospage.resultpage();
		  
		  DespResultPage resultadoPage = alojamientospage.resultpage();
		  
		  resultadoPage.validacion();
		  
		  DriverFactory.CerrarBrowser(driver);
		  
	  }
}
