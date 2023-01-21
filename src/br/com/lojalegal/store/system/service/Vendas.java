package br.com.lojalegal.store.system.service;

import java.util.ArrayList;
import java.util.List;

import br.com.lojalegal.store.system.date.SellData;
import br.com.lojalegal.store.system.model.Produto;
import br.com.lojalegal.store.system.model.Venda;

public class Vendas {

	private SellData sellData = new SellData();

	public Vendas() {
		// TODO Auto-generated constructor stub
	}

	public String addProductCard(Produto product, int quantity) {
		Produto p = new Produto(product.getSku(), product.getQuantidade(), product.getValor(), product.getDescricao());

		if (p.getSku() == null) {
			return "Nao foi possivel adicionar ao carrinho de compras";
		} else {

			p.setQuantidade(quantity);
			Object p2 = p;
			sellData.update(p2);

			return "Adicionado com sucesso ao carrinho de compras: " + "\n" + p2.toString();
		}
	}

	public List<Produto> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}

	public List<Object> getSellDataList() {
		return sellData.listItens();
	}

	public void cancel() {
		sellData.refrestcard();

	}

	public void setAndVerifyCPF(String a) {
		this.sellData.setSellCPF(a);
	}

	public String sellStockTestAndBuy(Estoque Stock, String CPF, String PaymentMethod, String valueBancaryData,
			String name, String endereco) {
		double priceToBil = 0d;
		Object obj;
		int negativeCount = productIncardToSell().size();
		if (sellData.listProduct().size() > 0) {
			for (int x = 0; x < Stock.listItems().size(); x++) {
				// System.out.println("TEste +++" +Stock.getDataStock());
				for (int y = 0; y < productIncardToSell().size(); y++) {
					Produto p8 = (Produto) getSellData().getItem(y);
					// System.out.println("TEste +++" +p8);

					if (p8.getSku() == Stock.procurarProduto(x).getSku()
							&& p8.getQuantidade() <= Stock.procurarProduto(x).getQuantidade()) {
						negativeCount--;

					}

				}

			}
			if (negativeCount == 0) {
				for (int x = 0; x < Stock.listItems().size(); x++) {
					for (int y = 0; y < productIncardToSell().size(); y++) {
						Produto p8 = (Produto) getSellData().getItem(y);
						if (p8.getSku() == Stock.procurarProduto(x).getSku()) {
							Stock.procurarProduto(x)
									.setQuantidade(Stock.procurarProduto(x).getQuantidade() - p8.getQuantidade());
							priceToBil = (p8.getValor() * p8.getQuantidade()) + priceToBil;
							System.out.println(priceToBil);
							System.out.println(p8.toString());

						}

					}

				}
				System.out.println(negativeCount);
				System.out.println(priceToBil);
				System.out.println(PaymentMethod);
				sellData.save(priceToBil, CPF, PaymentMethod, valueBancaryData, name, endereco);

				return "Pedido realizado com sucesso";
			} else {
				sellData.refrestcard();
				return "Pedido cancelado, produtos do carrinho exedem a quantidade do estoque";
			}
		} else {
			return "Pedido cancelado, carinho vazio";
		}

	}
}
