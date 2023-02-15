package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import page.LoginPO;

public class LoginTest extends BaseTest {

	public static LoginPO loginPage;
		
	
	@BeforeClass
	public static void prepararTeste() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
	
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
	
		loginPage.executarAcaoDeLogar("Teste", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
	
		loginPage.executarAcaoDeLogar("", "Teste");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
					
	}
	
}
