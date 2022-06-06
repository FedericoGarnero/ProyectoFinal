package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespAlojaPage {

	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	
	@FindBy(css = ".sbox5-box-container .input-container [placeholder=\"Ingresá una ciudad, alojamiento o punto de interés\"]")
	private WebElement origen;
	
	@FindBy(css = ".ac-wrapper.-desktop.-show.sbox-ab-ls .ac-container")
	private WebElement waitOrigen;
	
	@FindBy(css = "div.sbox5-box-dates-ovr.sbox5-dates-container  div.sbox5-dates-input1 ")
	private WebElement fecha;
	
	@FindBy(css = "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened:nth-child(4) div.sbox5-3-floating-tooltip-datepicker-wrapper.sbox5-compact-view > div.calendar-container")
	private WebElement waitFecha;
	
	@FindBy (xpath = "//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid-datenumber -weekday']//*[@class='sbox5-monthgrid-datenumber-number'][text()=11]")
	private WebElement numeroentrada;
	
	@FindBy (xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-30']//div[text()=18]")
	private WebElement numerosalida;
	
	@FindBy (css = "a.lgpd-banner--button.eva-3-btn.-white.-md")
	private WebElement entendicookies;
	
	@FindBy (css = ".sbox5-floating-tooltip.sbox5-floating-tooltip-opened button.sbox5-3-btn.-primary.-md")
	private WebElement aceptarFecha;
	
	@FindBy (css = ".sbox5-3-second-input")
	private WebElement habitaciones;
	
	@FindBy (css = ".distribution__container.distribution__type__rooms .stepper__room__footer .sbox5-3-btn.-md.-primary")
	private WebElement waitHabitaciones;
	
	@FindBy (css = "div.distribution__container.distribution__type__rooms div.stepper__room div.stepper__room__row:nth-child(1)  div.sbox5-3-steppers.-md > button.steppers-icon-right.stepper__icon")
	private WebElement agregarAdulto;
	
	
	@FindBy (css = "div.distribution__container.distribution__type__rooms div.stepper__room div.stepper__distribution_container div.stepper__room__row:nth-child(2) div.stepper__room__row__stepper__contaer div.sbox5-3-steppers.-md > button.steppers-icon-right.stepper__icon")
	private WebElement agregarMenor;
	
	@FindBy(css = ".select-container .select")
	private WebElement abrirComboEdad;
	
	@FindBy(xpath = "//div[@class='select-container'] /select[@class='select'] /option[@value=3]")
	private WebElement edad;
	
	@FindBy(css = ".distribution__container.distribution__type__rooms .stepper__room__footer .sbox5-3-btn.-md.-primary")
	private WebElement aplicarCantidad;
	
	@FindBy(css = ".sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg")
	private WebElement buscar;
	
	public DespAlojaPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		PageFactory.initElements(driver, this);
	}
	
	public void ingresarCiudad(String text) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(origen));
		origen.click();
		origen.sendKeys(text);
		Thread.sleep(2000);
		origen.sendKeys(Keys.CONTROL);
		Thread.sleep(2000);
		origen.sendKeys(Keys.ENTER);
		
	}
	
	public void fechaEntrada() {
		fecha.click();
		wait.until(ExpectedConditions.visibilityOf(waitFecha));
		
		numeroentrada.click();	
	}
	
	public void entendiCook() {
		entendicookies.click();
	}
	
	public void fechaSalida() {
		numerosalida.click();
		aceptarFecha.click();
		
	}
	
	public void cantidades() {
		habitaciones.click();
		
		wait.until(ExpectedConditions.visibilityOf(waitHabitaciones));
		
		agregarAdulto.click();		
		agregarMenor.click();
		
		abrirComboEdad.click();
		
		edad.click();
		
		aplicarCantidad.click();
	}
	
	public DespResultPage resultpage() {
		buscar.click();
		
		return new DespResultPage(this.driver);
	}
}
