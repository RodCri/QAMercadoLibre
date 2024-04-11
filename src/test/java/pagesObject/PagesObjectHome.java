package pagesObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObject.MapsObjectHome;

public class PagesObjectHome extends MapsObjectHome{
	public Properties properties;
	public String nomTest;
	public File routerFolder;

	public PagesObjectHome(WebDriver driver) {
		super(driver);
	}
	

	// METHOD SEARCH URL
	public void urlAccess(String url) {
		driver.get(url);
	}
	
	// METODO INGRESO A HOME
	public void enterAHome(String search, String searchProduct, File routerFolder) throws Exception {
		try {
			sendKey(search, txtSearchGoogle,routerFolder);
			submit(txtSearchGoogle,routerFolder);
			click(linkPage,routerFolder);
			click(modalUbicacion, routerFolder);
			click(btnCookies,routerFolder);
			sendKey(searchProduct, txtSearchProduct,routerFolder);
			click(btnSerachProducts,routerFolder);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
