package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Rol;



public interface RolServicio {
  
	public List<Rol> buscartodos();
	
	public void CrearRol(Rol rol);
	
	 Rol buscarById(Integer idrol); 
	
}
