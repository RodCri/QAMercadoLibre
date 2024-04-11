package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ClaseBase;

public class MapsObjectHome extends ClaseBase {

	//CONSTRUCTOR DE LA CLASE
	public MapsObjectHome(WebDriver driver) {
		super(driver);
	}

	// MAPPING PAGE ELEMENTS
	protected By txtSearchGoogle = By.name("q");
	protected By btnSearch = By.name("btnK");
	protected By linkPage = By.xpath("//a[@href='https://www.mercadolibre.com.co/']");
	// button[@class='onboarding-cp-button andes-button andes-button--transparent
	// andes-button--small']
	protected By modalUbicacion = By.xpath("//span[normalize-space()='Más tarde']");

	// MAPPING PAGE ELEMENTS MERCADO LIBRE
	protected By txtSearchProduct = By.id("cb1-edit");
	protected By btnSerachProducts = By.className("nav-search-btn");
	protected By btnCookies = By.xpath("//button[normalize-space()=\"Aceptar cookies\"]");
}
