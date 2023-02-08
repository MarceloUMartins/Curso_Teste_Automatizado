package automatizado.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class GoogleTest extends BaseTeste {

	@Test
	public void devePesquisarNoGoogle() {
			
	WebElement inputPesquisa = driver.findElement(By.name("q"));
	inputPesquisa.sendKeys("linkedin" + Keys.ENTER);
	
	String resultado = driver.findElement(By.id("result-stats")).getText();
	
	assertTrue(resultado, resultado.contains("Aproximadamente"));
	
	driver.quit();
	}
}
