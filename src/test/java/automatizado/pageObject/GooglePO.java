package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

	@FindBy(name = "q")
	public WebElement inputPesquisa;
	
	@FindBy(id = "result-stats")
	public WebElement divResultadoPesquisa;
	
	/**
	 * Costrutor para criação da pagina do Google*/
	public GooglePO(WebDriver driver) {
		super(driver);
		}

	/**
	 * Metodo que ira efetuar uma pesquisa no google baseado no texto informado*/
	public void pesquisar(String texto) {
		inputPesquisa.sendKeys(texto + Keys.ENTER);
		}
	
	/**
	 * Metodo que ira retornar o resultado aproximado da pesquisa.*/
	public String obterResultadoDaPesquisa() {
		return divResultadoPesquisa.getText();
	}
	
}
