package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Vehiculo;

public interface VehiculoServicio {

	public List<Vehiculo> buscartodos();
	
	public void crearVehiculo (Vehiculo vehiculo);
	
	public void actualizarVehiculo (Vehiculo vehiculo);
	
	public void eliminarVehiculo (String vehiculo);
	
	Vehiculo buscarById (String Matriculavehiculo);
	
	public List<Vehiculo> saveAll(List<Vehiculo> lstvehiculo);
	
	
	
}
