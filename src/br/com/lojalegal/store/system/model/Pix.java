package br.com.lojalegal.store.system.model;

public class Pix  implements TipoDePagamento  {
	
	private String chavePix;




	@Override
	public void TipoDPagemento(String value) {
		// TODO Auto-generated method stub
		this.chavePix= value;
		
	}
	
	@Override
	public String toString() {
		return "Pix [Chave PIX=" + chavePix + "]";
	}
}
