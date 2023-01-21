package br.com.lojalegal.store.system.model;

import java.util.List;

public class Dinheiro implements TipoDePagamento {
	String dinheiro;

	public Dinheiro() {
		this.dinheiro="pagamento em dinheiro";
	}

	

	@Override
	public void TipoDPagemento(String value) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public String toString() {
		return " [Dinheiro=" + dinheiro + "]";
	}
	 
}
