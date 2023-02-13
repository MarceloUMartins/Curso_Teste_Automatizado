package page;

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

}
