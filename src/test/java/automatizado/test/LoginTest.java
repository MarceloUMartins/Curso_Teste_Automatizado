package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta(){
	
		loginPage.executarAcaoDeLogar("Teste", "Teste");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
					
	}
	
	@Test
	public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta(){
	
		loginPage.executarAcaoDeLogar("admin@admin.com", "Teste");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
					
	}
	
	@Test
	public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){
	
		loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
					
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailCorretoESenhaCorreta(){
	
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
			
		assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
					
	}
	
}
