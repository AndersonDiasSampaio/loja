package br.com.lojalegal.store.system;

import java.util.Scanner;

import br.com.lojalegal.store.system.communication.Menu;
import br.com.lojalegal.store.system.model.Produto;
import br.com.lojalegal.store.system.service.Estoque;
import br.com.lojalegal.store.system.service.Vendas;

public class Principal {

	// Chamei o menu

	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * Menu menu = new Menu();
		 * 
		 * System.out.println("\n|-------------M E N U-------------|\n");
		 * System.out.println(" 1 - Descri��o do produto\n" + " 2 - Vendas\n" +
		 * " 3 - Formas de pagamento\n" +" 4 - Sair\n" +
		 * " 5 - Retornando ao in�cio do menu\n");
		 * System.out.println("\n|---------------------------------|\n");
		 * System.out.println("Digite um numero\n"); menu.menu();
		 */
		Vendas venda = new Vendas();
		Estoque estoque = new Estoque();
		Produto a = new Produto("SIMazuMASPEQ", 30, 10.0, "lindo");
		Produto b = new Produto("SIMazuFEMPEQ", 30, 10.0, "lindo");

		System.out.println(a);
		estoque.registrarProduto(a);
		estoque.registrarProduto(b);
		estoque.registrarProduto(a);

		// System.out.print(estoque.procurarProduto("SIMazuMASPEQ"));
		System.out.println(estoque.listItems());

		// estoque.excluirProduto("SIMazuFEMPEQ");
		// System.out.println(estoque.listItems());

		System.out.println(venda.addProductCard(a, 2));
		System.out.println(venda.addProductCard(b, 5));
		System.out.println("///////////////////////////////////////////////////////////////////");
		System.out.println(estoque.listItems());

		System.out.println(venda.getSellData().listProduct());
		venda.sellStockTestAndBuy(estoque, "09339394429", "PIX", "8299789", "anderson", "praca");
		System.out.println(venda.getSellData().listItens());
		System.out.println("///////////////////////////////////////////////////////////////////");
		System.out.println(estoque.listItems());
		System.out.println("///////////////////////////////////////////////////////////////////");
		System.out.println(venda.getSellData().listProduct());

		
		System.out.println("***********************************************************");

		System.out.println(venda.addProductCard(a, 8));
		System.out.println(venda.addProductCard(b, 10));
		System.out.println("///////////////////////////////////////////////////////////////////");
		System.out.println(estoque.listItems());

		System.out.println(venda.getSellData().listProduct());
		venda.sellStockTestAndBuy(estoque, "09339394429", "PIX", "8299789", "Flavia", "rua");
		System.out.println(venda.getSellData().listItens());

		/*
		 * venda.produtos(estoque);
		 * System.out.println(venda.colocarNoCarrinho("SIMazuFEMPEQ", 2, estoque));
		 * System.out.println(venda.colocarNoCarrinho("SIMazuFEMPEQ", 5, estoque));
		 * 
		 * System.out.println(venda.removerDoCarrinho("SIMazuFEMPEQ", 1));
		 * System.out.println(venda.getLista()); System.out.println(venda.valorFinal());
		 */

	}

}
