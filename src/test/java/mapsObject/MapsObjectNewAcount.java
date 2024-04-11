package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ClaseBase;

public class MapsObjectNewAcount extends ClaseBase{

	// CONSTRUCTOR DE LA CLASE
	public MapsObjectNewAcount(WebDriver driver) {
		super(driver);
	}

	// MAPING ELEMENTS PAGE
	protected By btnCrearCuenta = By.xpath("//span[normalize-space()='Crear cuenta']");
	protected By btnCuentaPersonal = By.xpath("//span[normalize-space()='Crear cuenta personal']");
	protected By btnAgregarEmail = By.xpath("//button[@id='hub-item-button']");//span[@class='andes-button__text']
	protected By optionGmail = By.xpath("//li[@id='email-without-android-listbox-option-0']");
	protected By inputEmail = By.xpath("//input[@id='email-without-android']");//div[@class='andes-form-control__control']
	protected By checkAutorizo = By.xpath("//input[@id='policies']");
	protected By btnContinuar = By.xpath("//button[@id=':R1td9:']");
	
	protected By textEmail = By.xpath("//span[normalize-space()='54673ggdstt@gmail.com']");
}
