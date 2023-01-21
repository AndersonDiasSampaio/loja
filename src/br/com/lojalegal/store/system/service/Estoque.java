package br.com.lojalegal.store.system.service;
 
import java.util.List;
import java.util.Scanner;

import br.com.lojalegal.store.system.date.EstoqueDate;
import br.com.lojalegal.store.system.model.Produto;

public class Estoque { 
	 
	EstoqueDate estoqueservice = new EstoqueDate();
 
	public List<Object> listItems()  {
		return estoqueservice.listItems(); 
	 	
	}
 
	//Procurar produto por sku
	public Produto procurarProduto(String sku) {
		
		for(int x = 0; x<listItems().size(); x++) {
			Produto produto = (Produto) listItems().get(x);
			if(sku.equals(produto.getSku())) {
				return produto;
			}
			
		}
		return null;
	}
	
 //registrar o produto
	public String registrarProduto(Produto produto) {

		 if(produto.getCategoria() == null || produto.getDepartamento() == null || produto.getCor() == null || produto.getDescricao() 
	 			== null || produto.getTamanho() == null) {
			return "N�o existe";
			
		} else {
			 Produto produtoSku = procurarProduto(produto.getSku());
		 	  if(produtoSku == null && produto.getQuantidade() > 0) {
				 boolean save = estoqueservice.save(produto);
				 
				 if(save) {
					 return "Falhou";
				 }
				 else {
					 return "Cadastrado";
				 }
				  
			 }else {
				 return "N�o existe";
			 }
 			  
		}  
	 
	}

	//Não funciona refazer com if e else, da pra usar o procurar produto, pois ele funciona
 	//update do date  
	public void atualizarProduto() {
		Scanner sc = new Scanner(System.in);
		int opcao = 1;
		while (opcao != 0) {
			System.out.println("1 - Atualizar\n");
			System.out.println("2 - Atualizado\n");
			System.out.println("3 - Sair\n");
			opcao = sc.nextInt();
		 
			switch (opcao) {
			case 1:
				procurarProduto(null);
				break;
				
			case 2:
				organizarProduto(null, opcao);
				break;
				
				default:
					if (opcao != 0) {
				System.out.println("Erro tente de novo\n");
			
			}
		}
	 
		}
	}
   //acho que da pra retirar
	 //editar produto  
 public String organizarProduto(Produto produto, int quantidade) {
	 int arrumar = 1;
	 for(int x = 0; x<listItems().size(); x++) {
		 Produto produtoSku = (Produto) listItems().get(x);
		 if(produto.getSku().equals(produtoSku.getSku())) {
			 arrumar = x;
		 }
		 
	 }
	 switch (arrumar) {
	 case 1:
		 return "N�o foi encontrado";
	 default:
		 if(quantidade != 0) {
			 
			 produto.setQuantidade(produto.getQuantidade() +(quantidade));
			 if(produto.getQuantidade() < 0) {
				 return "Inv�lido";
	 		 }
	 	 }
	  
		 if(estoqueservice.edit(arrumar, produto)) {
			 return "Arrumado";
			 
		 }else {
			 return "Erro";
		 }
	 }
 }
	
  
//excluir o produto
	public String excluirProduto(String sku) {
		Produto produto = procurarProduto(sku);
		if(produto != null) {
			if(estoqueservice.delete(produto)) {
				return "Produto exclu�do";
		 	}else {
		 		return "Erro ao excluir";
		 	}
		}else {
			return "Inv�lido";
		}
	 	
	}
 
}
