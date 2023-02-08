package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {
	
	protected static WebDriver driver;
	private static final String URL_BASE = "https://www.google.com.br/" ;
	private static final String CAMINHO_DRIVER = "C:\\driver\\chromedriver-v10905114.exe" ;
	
	@BeforeClass
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
	
}