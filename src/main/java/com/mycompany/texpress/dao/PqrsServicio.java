package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Pqrs;

public interface PqrsServicio {

	
	public List<Pqrs> buscartodos();
	
	public void crearPqrs(Pqrs pqrs);
	
	public void editarPqrs(Pqrs pqrs);
	
	public void eliminarPqrs(Pqrs pqrs);
	
}
