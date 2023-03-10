package builder;

import page.ControleDeProdutoPO;

public class ProdutoBuilder {

	private String codigo = "0001";
	private String nome = "Produto Padr?o";
	private Integer quantidade = 1;
	private Double valor = 1.0;
	private String data = "03/11/2021";
	
	private ControleDeProdutoPO controleDeProdutoPO;
	
	public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
		this.controleDeProdutoPO = controleDeProdutoPO;
	}
	
	public ProdutoBuilder adicionarCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public ProdutoBuilder adicionarNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}
	
	public ProdutoBuilder adicionarValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public ProdutoBuilder adicionarData(String data) {
		this.data = data;
		return this;
	}
	
	public void builder() {
		
		controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
		controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
		controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade) != null ? quantidade.toString() : "");
		controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor) != null ? valor.toString() : "");
		controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
		
		controleDeProdutoPO.buttonSalvar.click();
	}
}
