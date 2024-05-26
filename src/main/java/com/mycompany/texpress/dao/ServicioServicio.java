package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Servicio;


public interface ServicioServicio {

    public List<Servicio> buscartodos();
	
    public void crearServicio (Servicio servicio);
	
	public void actualizarServicio (Servicio servicio);
	
	public void eliminarServicio (Integer idservicio);

	Servicio buscarById(Integer idservicio);
}
