package pagesObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObject.MapsObjectDetails;

public class PagesObjectDetails extends MapsObjectDetails{
	
	public Properties properties;
	public String nomTest;
	public File routerFolder;

	// CONSTRUCTOR DE LA CLASE
	public PagesObjectDetails(WebDriver driver) {
		super(driver);
	}
	
	// METODO AGREGAR AL CARRITO
	public void addToCar(File routerFolder) throws InterruptedException{
		try {
			click(btnAgregar, routerFolder);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
