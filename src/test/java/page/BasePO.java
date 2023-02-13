package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para cria��o das novas pagesObjects.
 * Todas as pages devem ser herdadas dessa classe 
 * */

public abstract class BasePO {

	/** Driver base que sera usado pelas pages */
	protected WebDriver driver;
	
	/**
	 * Construtor base para cria��o da fabrica de elementos(PageFactory).
	 * */
	public BasePO(WebDriver driver) {
		this.driver = driver;
				
		PageFactory.initElements(driver, this);
		
			} 
	
}
