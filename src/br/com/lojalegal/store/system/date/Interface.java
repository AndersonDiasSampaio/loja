package br.com.lojalegal.store.system.date;

import java.util.List;

public interface Interface { 
	 
	
	boolean save (Object obj);  //salvar
	void update (Object obj); //mostrar
    boolean delete (Object obj); //deletar
    boolean edit(int arrumar, Object obj); //editar
    
    List<Object> listItems() ; //listar
   
	 
}
