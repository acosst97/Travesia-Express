package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Venta;

public interface VentaServicio {

	
 public List<Venta> buscartodos();
	
	public void crearVenta (Venta Venta);
	
	public void actualizarVenta (Venta Venta);
	
	public void eliminarVenta (Integer Venta);
	
	Venta buscarById (Integer Venta);
    
	public List<Venta> saveAll(List<Venta> lstVenta);
	
	
}
