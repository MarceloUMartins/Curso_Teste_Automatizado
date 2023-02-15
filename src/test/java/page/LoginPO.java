package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement bottonEntrar;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	
	/**
	 * Construtor padrão para criação de uma nova instancia da pagina de login.*/
	public LoginPO(WebDriver driver) {
		super(driver);
		
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	/**
	 * Metodo que tenta executar a ação de logar no sistema
	 * @param email E-mail para a tentativa de login
	 * @param senha Senha para a tentativa de login*/
	public void executarAcaoDeLogar(String email, String senha) {
		
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
				
		bottonEntrar.click();
		
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
	
}
