package br.com.lojalegal.store.system.model;

import br.com.lojalegal.store.system.enums.CategoriaEnum;
import br.com.lojalegal.store.system.enums.CorEnum;
import br.com.lojalegal.store.system.enums.DepartamentoEnum;
import br.com.lojalegal.store.system.enums.TamanhoEnum;

public class Produto {
	 
	 
	private String sku;
	private int quantidade;
	private double valor;
	private String descricao;
	private DepartamentoEnum departamento;
	private CategoriaEnum categoria;
	private CorEnum cor;
	private TamanhoEnum tamanho;
    
     
	public Produto(String sku, int quantidade, double valor, String descricao) {
		super();
		this.sku = sku;
		this.quantidade = quantidade;
		this.valor = valor;
		this.descricao = descricao;
		
		dados();
	}
 
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public void setDepartamento(DepartamentoEnum departamento) {
		this.departamento = departamento;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public void setCor(CorEnum cor) {
		this.cor = cor;
	}

	public void setTamanho(TamanhoEnum tamanho) {
		this.tamanho = tamanho;
	}

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
		dados();
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
 
	public DepartamentoEnum getDepartamento() {
		return departamento;
	}

	 
	public CategoriaEnum getCategoria() {
		return categoria;
	}
 
	public CorEnum getCor() {
		return cor;
	}
 

	public TamanhoEnum getTamanho() {
		return tamanho;
	}

  //tive que refazer
	private void dados( ) {
		 this.categoria = CategoriaEnum.getCategoriaEnum(sku.substring(0,3));
		 this.cor = CorEnum.getCorEnum(sku.substring(3,6)); 
		 this. departamento = DepartamentoEnum.getDepartamentoEnum(sku.substring(6,9));
         this.tamanho = TamanhoEnum.getTamanhoEnum(sku.substring(9,12));
	}
   @Override
    public String toString() {
	return "\nSKU:" + sku + "\nQuantidade:" +quantidade +"\nValor:" + valor + "\nDescricao:" +descricao + 
			", " + categoria + ", " + cor + "," + departamento + ", " + tamanho + "\n";
  } 
  
}









