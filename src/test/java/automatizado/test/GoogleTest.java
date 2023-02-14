package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import page.GooglePO;


public class GoogleTest extends BaseTest {

	public static GooglePO  googlePage;
		
	@BeforeClass
	public static void prepararTeste() {
		driver.get("https://www.google.com.br/");
		googlePage = new GooglePO(driver);
	}
	
	@Test
	public void deveSerPossivelPesquisarNoGoogleOTextoLinkedin(){
	
	googlePage.pesquisar("Linkedin");
	
	String resultado = googlePage.obterResultadoDaPesquisa();
	
	assertTrue(resultado, resultado.contains("Aproximadamente"));
	
	googlePage.inputPesquisa.clear();

	}
	
	@Test
	public void deveSerPossivelPesquisarNoGoogleOTextoUdemy(){
	
	googlePage.pesquisar("Udemy");
	
	String resultado = googlePage.obterResultadoDaPesquisa();
	
	assertTrue(resultado, resultado.contains("resultados"));
	
	googlePage.inputPesquisa.clear();
	}
}
