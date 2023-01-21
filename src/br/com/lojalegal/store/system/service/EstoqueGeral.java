package br.com.lojalegal.store.system.service;

import java.util.List;

import br.com.lojalegal.store.system.date.Geral;

public class EstoqueGeral { 
	Geral historico = new Geral();
	
	public boolean registroDoHistorico(Object obj) { 
		if (historico.save(obj)) {
			return true;
		}else {
			return false;
		}
	 
	}
	
	public List<Object> listaHistorico() {
			 return historico.listItems();
		 }
}
