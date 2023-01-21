package br.com.lojalegal.store.system.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Venda  {

	
	private Pessoa pessoa;
	private String total;
	private TipoDePagamento tipoDePagamento;
	private String dateTime;
	private Double price;

 	private List<Produto> vender = new ArrayList<Produto>();
	
	 
 	
 	public Venda(String nome, String cpf, String endereco) {
		//super(nome, cpf, endereco);
 		this.pessoa.setNome(nome);
 		this.pessoa.setCpf(cpf);
 		this.pessoa.setEndereco(endereco);
 		
		 
	}
  
	public Venda() {
		// TODO Auto-generated constructor stub
		pessoa = new Pessoa();
	}
	
	public Produto getProductInTheList(int x) {
		return vender.get(x);
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		LocalDateTime dateTime2 = LocalDateTime.now();
		String a= dateTime2.toString();
		dateTime = a.substring(0, 10);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(String cpf, String endereco, String nome) {
		this.pessoa.setCpf(cpf);
		this.pessoa.setEndereco(endereco);
		this.pessoa.setNome(nome);
		
	}

	public TipoDePagamento getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento, String value) {
		if (tipoDePagamento.equals("PIX")) {
			Pix a = new Pix();
			a.TipoDPagemento(value);
			this.tipoDePagamento=a;

		} else if (tipoDePagamento.equals("DINHEIRO")) {
			Dinheiro a = new Dinheiro();
			a.TipoDPagemento(value);
			this.tipoDePagamento=a;

		}/* else if (method.equals("CARTAO_DE_CREDITO")) {
			CredCard a = new CredCard();
			a.TypeOfPayment(Data);
			this.paymentMethod=a;
		} else if (method.equals("CARTAO_DE_DEBITO")) {
			Debit a = new Debit();
			a.TypeOfPayment(Data);
			this.paymentMethod=a;
		}*/
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Produto> getVender() { 
		return  vender;
	}
	public void setVender(Produto vender) {
		this.vender.add(vender);
	}

	@Override
	public String toString() {
		return "Venda [pessoa=" + pessoa + ", total=" + total + ", tipoDePagamento=" + tipoDePagamento + ", dateTime="
				+ dateTime + ", price=" + price + ", vender=" + vender + "]";
	}
	
}
