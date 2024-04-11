package test;

import org.testng.annotations.Test;

import base.ClaseBase;
import pagesObject.PagesObjectDetails;
import pagesObject.PagesObjectHome;
import pagesObject.PagesObjectNewAcount;
import pagesObject.PagesObjectSearch;
import utilities.ExcelUtilidades;
import utilities.GenerarReportePdf;
import utilities.MyScreenRecorder;
import utilities.ReadExcelFile;
import utilities.WriteExcelFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunTestShoping {
	private WebDriver driver;
	private PagesObjectHome pagesObjectHome;
	private PagesObjectSearch pagesObjectSearch;
	private PagesObjectDetails pagesObjectDetails;
	private PagesObjectNewAcount pagesObjectNewAcount;
	Properties properties;
	ReadExcelFile read;
	WriteExcelFile write;
	ClaseBase claseBase;
	public String nomTest;
	public File routerFolder;

	public String path;
	public String pathOuput;
	GenerarReportePdf generarReportePdf;

	@BeforeClass
	public void beforeClass() {
		pagesObjectHome = new PagesObjectHome(driver);
		// INSTANCIAR CLASE PAGEOBJECTSHOPING
		driver = pagesObjectHome.chromeDriverConnection();
		// INSTANCIAS DE LOS PAGESOBJECT
		pagesObjectSearch = new PagesObjectSearch(driver);
		pagesObjectDetails = new PagesObjectDetails(driver);
		pagesObjectNewAcount = new PagesObjectNewAcount(driver);
		// INSTANCIAR DE PROPERTIES
		properties = new Properties();
		// INSTANCIAR CLASE BASE
		claseBase = new ClaseBase(driver);
		// CREAR VARIABLE TIPO INPUTSTREAM
		InputStream entrada = null;
		// INSTANCIAR DE GENERAR REPORTE
		generarReportePdf = new GenerarReportePdf();

		// INSTANCIAR CLASE DE EXCEL
		read = new ReadExcelFile();
		write = new WriteExcelFile();

		// VALIDAR SI GENERA EEROR AL ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/properties");
			// CARGAR LAS PROPIEDADES
			properties.load(entrada);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// ACCEDER AL METODO DE ABRIR PAGINA
		pagesObjectHome.urlAccess(properties.getProperty("url"));

		// PROPERTIES
		path = properties.getProperty("filePathExcel");
		pathOuput = properties.getProperty("outputFile");
		generarReportePdf.setRutaImagen(properties.getProperty("rutaImagenReporte"));

	}

	@DataProvider(name = "shoping")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray(path, "dataShoping");
		return arreglo;
	}

	@Test(dataProvider = "shoping")
	public void shopingTest(String search, String product, String email) throws Exception {
		// OBTENER EL NOMBRE DEL TEST
		nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR LA RUTA DEL FOLDER OUTPUT
		routerFolder = claseBase.createFolder(properties, nomTest, pathOuput);
		// INICIAR LA GRABACION
		MyScreenRecorder.startRecording(nomTest, routerFolder);
		// GENERAR REPORTE
		generarReportePdf.crearPlantilla(nomTest, routerFolder);
		// EJECUTAR LOS TEST DEL PAGES
		try {
			// INGRESO A PAGINA MERCADO LIBRE
			pagesObjectHome.enterAHome(search,product,routerFolder);
			pagesObjectSearch.selectProduct(routerFolder);
			pagesObjectDetails.addToCar(routerFolder);
			pagesObjectNewAcount.createAcount(email,routerFolder);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// CERRAMOS LA PLANTILLA DEL REPORTE
		generarReportePdf.cerrarPlantilla();
		// PARAR LA GRABACION
		MyScreenRecorder.stopRecording();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
