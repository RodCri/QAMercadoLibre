package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ClaseBase;

public class MapsObjectDetails extends ClaseBase{

	// CONSTRUCTOR DE LA CLASE
	public MapsObjectDetails(WebDriver driver) {
		super(driver);
	}
	// MAPING ELEMENTS PAGE
	protected By btnAgregar = By.xpath("//button[@id=':R16d7a6c4um:']");

}
