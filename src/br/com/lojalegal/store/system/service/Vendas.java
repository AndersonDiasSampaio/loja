package br.com.lojalegal.store.system.service;

import java.util.ArrayList;
import java.util.List;
 
import br.com.lojalegal.store.system.model.Produto;
import br.com.lojalegal.store.system.model.Venda;

public class Vendas { 

	 List<Produto> lista = new ArrayList<Produto>();
	 Estoque estoqueProduto;
	 Venda vendaFinalizada = new Venda();
	 
	 //Dados do list
	 public void produtos(Estoque produtos) {
		 estoqueProduto = produtos;
		  
	 }
	 
	 //listar produto no carrinho  
	 public List<Produto> getLista() {
		 return lista;
		 
		 
	 }
	 //procurar produto no carrinho  
	 public Produto procurandoSku(String sku) {
		 
		for(int x = 0; x<lista.size(); x++) {
			Produto produto = (Produto) lista.get(x);
			if(sku.equals(produto.getSku())) {
				return produto;
			}
		}
		 return null;
		 
	 }
	 //tá colocando e atualizando caso já aja, resolvido
	//Colocar no carrinho usando do sku
	 public String colocarNoCarrinho(String sku, int quantidade, Estoque estoque ) { 
		 boolean produtoNalista= false;
		 if(estoque.procurarProduto(sku)!=null) {
		 Produto p = estoque.procurarProduto(sku); 
		 for(int x = 0; x<lista.size(); x++) {
				Produto produto = (Produto) lista.get(x);
				if(sku.equals(produto.getSku())) {
					produto.setQuantidade(quantidade);
					produtoNalista=true;
				}
			}
		 
		 if(produtoNalista==false) {
			 Produto produto = new Produto(p.getSku(), quantidade, p.getValor(), p.getDescricao());
				
			 lista.add(produto);
		 }
		 
		 
		
		 return lista.toString();}
		 else {
			 return null;
		 }
		 
			 
	 }
 	 //MÉTODO NEM É USADO
	 //editar produto no carrinho  
	 private int arrumandoProdutonoCarrinho(Produto produto) { 
		 int arrumar = 1;
		 for(int x= 0; x<getLista().size(); x++) {
			 Produto produtoSku = getLista().get(x);
			 if(produto.getSku().equals(produtoSku.getSku())) {
				 arrumar = x; 
			 }
			 
		 }
		 switch(arrumar) {
		 case 1:
			 return 2;  
		 
		 default:
		if(lista.set(arrumar, produto) != null) {
			conferindoProdutos();  
			return 0;
		
		}else {
			return 2;
    }
			 
   } 
 }
	 //USADO EM UM MÉTÓDO NEM USADO
	//verificar os produtos  
	 private void conferindoProdutos() {
		 for(int x = 0; x<lista.size(); x++) {
			 Produto produto = lista.get(x);
			 if(produto.getQuantidade() <= 0) {
				 lista.remove(produto);
			 }
		 }
	}
	 //VERIFICAR TÁ INTERESSANTE ------------------ funcionando
	 //retirar produto do carrinho  
	 public String removerDoCarrinho(String sku, int quantidade) {
		 Produto produto = procurandoSku(sku);
		 
		 if(produto == null) {
			 return "N�o existe";
		 
		 }else if(produto.getQuantidade() < quantidade) {
			 return "N�o tem essa quantidade";
			 
		 }else if(quantidade <= 0) {
			 return "Digite de novo";
		 }else {
			 devolverProdutoAoEstoque(produto.getSku(), quantidade);
		     produto.setQuantidade(produto.getQuantidade() - quantidade);
			 return "Removido";
		 } 
	 	 
	 }
	 //Devolver produto  
	 public void devolverProdutoAoEstoque(String sku, int quantidade) {
		 Produto produtoNoEstoque =  estoqueProduto.procurarProduto(sku);
		 if(produtoNoEstoque == null) {
			 estoqueProduto.registrarProduto(produtoNoEstoque);
		 }else {
			 quantidade = produtoNoEstoque.getQuantidade() + quantidade;
			 Produto mostrarPoduto = new Produto(produtoNoEstoque.getSku(), produtoNoEstoque.getQuantidade(), produtoNoEstoque.getValor(), produtoNoEstoque.getDescricao());
			 estoqueProduto.organizarProduto(mostrarPoduto, 0);
		 }
 		  
	 }
 	 
	 private int excluirProdutoEstoqueDate(Produto produto, int quantidade) {
		 
		 if(produto.getQuantidade() < quantidade) {
			 return 1;
		 }else {
			 quantidade = produto.getQuantidade() - quantidade;
			 Produto produtoRt = new Produto(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());
			 estoqueProduto.organizarProduto(produtoRt, 0);
		 return 2;
		  }
		 	
	}
	//retirar produto do estoque  
	  
	 public int tirandoProdutoDoEstoque(Produto produto, int quantidade) {
		 
		 if(produto.getQuantidade() < quantidade) {
			 return 1;
	 	 } else {
	 		 quantidade = produto.getQuantidade() - quantidade;
	 		 Produto mostrar = new Produto(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());
	 		estoqueProduto.organizarProduto(mostrar, 0);
	 		return 2; 
	 		 
	 	 }
		   
	 }
	 //valor total  
 	 public  double valorFinal( ) {
 		 Double valorFinal = 0.0;
 		 for(int x = 0; x<lista.size(); x++) {
 			valorFinal = valorFinal + (lista.get(x).getValor()* lista.get(x).getQuantidade());
 		  }
 		 return valorFinal;
 	 }
 	 //Esvaziar carrinho
public String cancelarCompra() {
	
	for (int x = 0; x<getLista().size(); x++) {
		Produto produto = getLista().get(x);
		removerDoCarrinho(produto.getSku(), produto.getQuantidade());
		
	}
	     return "Desistindo de compra";
  }
}
