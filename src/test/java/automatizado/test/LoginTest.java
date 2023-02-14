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
	
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("");
		
		loginPage.bottonEntrar.click();
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
}
