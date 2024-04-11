package pagesObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import mapsObject.MapsObjectNewAcount;

public class PagesObjectNewAcount extends MapsObjectNewAcount{
	
	public Properties properties;
	public String nomTest;
	public File routerFolder;

	// CONSTRUCTOR DE LA CLASE
	public PagesObjectNewAcount(WebDriver driver) {
		super(driver);
	}

	public void createAcount(String email,File routerFolder) throws InterruptedException{
		try {
			click(btnCrearCuenta,routerFolder);
			click(btnCuentaPersonal, routerFolder);
			click(btnAgregarEmail, routerFolder);
			sendKey(email, inputEmail, routerFolder);
			sendKeyBoard(Keys.ARROW_DOWN,inputEmail);
			sendKeyBoard(Keys.ENTER,inputEmail);
			click(optionGmail,routerFolder);
			standByTime(3000);
			click(checkAutorizo, routerFolder);
			standByTime(1000);
			Assert.assertEquals(true, isEnabled(btnContinuar));
			System.out.println("Elemento continuar esta habilitado - Assert passed");
			click(btnContinuar,routerFolder);
			standByTime(5000);
			Assert.assertEquals("54673ggdstt@gmail.com", getText(textEmail));
			System.out.println("54673ggdstt@gmail.com texto esperado - Assert passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	



}
