package br.com.lojalegal.store.system.date;

import java.util.ArrayList;
import java.util.List;

import br.com.lojalegal.store.system.model.Produto;
import br.com.lojalegal.store.system.model.Venda;

public class SellData {

	private List<Object> sellData = new ArrayList();
	private Venda sell = new Venda();

	public SellData() {
		// TODO Auto-generated constructor stub
	}

	public boolean delete(Object obj) {
		// SellData.remove((int) obj);
		return false;
	}

	public void update(Object obj) {
		boolean b = false;
		Produto pr = (Produto) obj;
		for (Object element : sell.getVender()) {
			Produto product = (Produto) element;
			System.out.println(product.getSku());
			if (pr.getSku() == product.getSku()) {
				product.setCategoria(pr.getCategoria());
				product.setCor(pr.getCor());
				product.setDepartamento(pr.getDepartamento());
				product.setDescricao(pr.getDescricao());
				product.setValor(pr.getValor());
				product.setQuantidade(pr.getQuantidade() + product.getQuantidade());
				product.setTamanho(pr.getTamanho());
				b = true;
			}
		}
		if (b == false) {
			save(obj);
		}
	}

	public List<Object> listItens() {
		return sellData;
	}

	public Object getItem(Object obj) {

		return this.sell.getProductInTheList((int) obj);
		// this.sell.getProductList().get((int) obj);
	}

	public void save(Object obj) {
		Produto product = (Produto) obj;
		// TODO Auto-generated method stub
		this.sell.setVender(product);

	}

	public void refrestcard() {
		this.sell = new Venda();
	}

	public void save(double b) {
		
		this.sell.setDateTime();
		this.sell.setPrice(b);

		sellData.add(sell);

	}

	public void save(double price, String CPF, String PaymentMethod, String valueBancaryData, String name, String endereco ) {
		this.sell.setTipoDePagamento(PaymentMethod, valueBancaryData);
		this.sell.setDateTime();
		this.sell.setPessoa(CPF, endereco, name);

		sellData.add(sell);

	}
	
	public void setSellCPF(String a) {
		this.sell.setPessoa(null, null, a);
	}


	public List<Produto> listProduct() {

		return this.sell.getVender();
	}

}
