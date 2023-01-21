package br.com.lojalegal.store.system.date;

import java.util.ArrayList;
import java.util.List;

public class Geral implements Interface { 
	
         List<Object> linhaDoTempo = new ArrayList<Object>();
	
    @Override
	public boolean save(Object obj) {
		
		if(linhaDoTempo.add(obj)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void update(Object obj) {
	  ((Geral) this.linhaDoTempo).update(obj);
		
	}

	@Override
	public boolean delete(Object obj) {
		if(linhaDoTempo.remove(obj)) {
          return true;			
		}else {
			return false;
		}
	}

	@Override
	public boolean edit(int arrumar, Object obj) {
		linhaDoTempo.set(arrumar, obj);
		return true;
	}

	@Override
	public List<Object> listItems() {
		return linhaDoTempo;
		 
	}

}
