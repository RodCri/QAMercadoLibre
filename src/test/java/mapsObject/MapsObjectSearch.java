package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ClaseBase;

public class MapsObjectSearch extends ClaseBase{

	//CONSTRUCTOR DE LA CLASE
	public MapsObjectSearch(WebDriver driver) {
		super(driver);
	}
	
	//MAPING ELEMENTS PAGE
	//protected By imgProduct = By.xpath("//img[@alt='Portatil Lenovo Ryzen 7 5700u Ram 20gb Ssd 512gb Fhd Ideapad Color Abyss Blue']");
	protected By imgProduct = By.xpath("//a[@title='Portatil Lenovo Ryzen 7 5700u Ram 20gb Ssd 512gb Fhd Ideapad Color Abyss Blue']");

}
