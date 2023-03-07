package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import builder.ProdutoBuilder;
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
		
		controlleProdutoPage.buttonSair.click();
		controlleProdutoPage.buttonSair.click();
	}
	
	
	
	/*
	 * @Test public void
	 * TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
	 * 
	 * 
	 * controlleProdutoPage.buttonAdicionar.click();
	 * 
	 * controlleProdutoPage.cadastrarProduto("00001", "Martelo", 10, 59.9, "");
	 * 
	 * String mensagem =controlleProdutoPage.spanMensagem.getText();
	 * 
	 * assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
	 * 
	 * 
	 * }
	 */
	  
	  @Test
	  public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
		
		String mensagem = "Todos os campos são obrigatórios para o cadastro!";
		controlleProdutoPage.buttonAdicionar.click();
		
		//Aqui cria o objeto para adicionar na tela
		ProdutoBuilder ProdutoBuilder = new ProdutoBuilder(controlleProdutoPage);
		
		//Aqui estamos testando se o produto é adicionado sem codigo
		ProdutoBuilder
		.adicionarCodigo("")
		.builder();
		
		assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
				
		//Aqui estamos testando se o produto é adicionado sem quantidade
		ProdutoBuilder
		.adicionarCodigo("0005")
		.adicionarQuantidade(null)
		.builder();
		
		assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
		
		//Aqui estamos testando se o produto é adicionado sem nome
		ProdutoBuilder
		.adicionarQuantidade(null)
		.adicionarNome("")
		.builder();
				
		assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
		
		//Aqui estamos testando se o produto é adicionado sem valor
		ProdutoBuilder
		.adicionarNome("Cimento")
		.adicionarValor(null)
		.builder();
				
		assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
		
		//Aqui estamos testando se o produto é adicionado sem data
		ProdutoBuilder
		.adicionarValor(50.0)
		.adicionarData("")
		.builder();
				
		assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
		
		
	}
	
}
