package pagesObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObject.MapsObjectSearch;

public class PagesObjectSearch extends MapsObjectSearch{

	public Properties properties;
	public String nomTest;
	public File routerFolder;
	
	// CONSTRUCTOR DE LA CLASE
	public PagesObjectSearch(WebDriver driver) {
		super(driver);
	}

	// METODO SELECT PRODUCT
	public void selectProduct(File routerFolder) throws InterruptedException{
		try {
			scrollWeb(100, 1);
			click(imgProduct,routerFolder);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
