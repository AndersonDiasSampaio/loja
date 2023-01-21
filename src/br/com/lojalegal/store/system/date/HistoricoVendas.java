package br.com.lojalegal.store.system.date;

import java.util.ArrayList;
import java.util.List;

public class HistoricoVendas implements Interface {  
	
	List<Object> historicoVendas = new ArrayList<Object>();
	

	@Override
	public boolean save(Object obj) {
         if(historicoVendas.add(obj)) {
			
		}
		else {
			return true;
		}
		return false;
 	}

	@Override
	public void update(Object obj) {
		((HistoricoVendas) this.historicoVendas).update(obj);
	 	 
	}

	@Override
	public boolean delete(Object obj) {
		if (historicoVendas.remove(obj)) {
			return true;
	 	}
		else {
			return false;
		}
	 }
 	  
	@Override
	public List<Object> listItems() {
		
		 return historicoVendas;  
	}
 
	public boolean edit(int arrumar, Object obj) {
		historicoVendas.set(arrumar, obj);
		return true;
	}
 
 
}
