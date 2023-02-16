package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.ControleDeProdutoPO;
import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {
	
	public static LoginPO loginPage;
	private static ControleDeProdutoPO controlleProdutoPage;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPage = new LoginPO(driver);
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		controlleProdutoPage = new ControleDeProdutoPO(driver);
		assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
	}

	@Test
	public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
		controlleProdutoPage.buttonAdicionar.click();
		controlleProdutoPage.buttonAdicionar.click();
		
		String titulo = controlleProdutoPage.tituloModal.getText();
		assertEquals("Produto", titulo);
	}
	
}
