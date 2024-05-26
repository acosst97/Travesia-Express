package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.VehiculoServicio;
import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.repositorio.VehiculoRepositorio;

@Service
public class VehiculoImp implements VehiculoServicio{

	
	@Autowired
	VehiculoRepositorio vehiculoRepositorio;
	
	@Override
	public List<Vehiculo> buscartodos() {
		// TODO Auto-generated method stub
		return vehiculoRepositorio.findAll();
	}

	

	@Override
	public void crearVehiculo(Vehiculo vehiculo) {
		int res=0;
		Vehiculo vehi=vehiculoRepositorio.save(vehiculo);
		if(!vehi.equals(null)) {
			res=1;
		}
		
	}


	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		int res=0;
		Vehiculo vehi=vehiculoRepositorio.save(vehiculo);
		if(!vehi.equals(null)) {
			res=1;
		}
		
	}
	

	@Override
	public Vehiculo buscarById(String matriculavehiculo) {
		
		return vehiculoRepositorio.getById(matriculavehiculo);
	}



	@Override
	public void eliminarVehiculo(String matriculavehiculo) {

     vehiculoRepositorio.deleteById(matriculavehiculo);
		
	}



	@Override
	public List<Vehiculo> saveAll(List<Vehiculo> lstvehiculo) {
		
		return  this.vehiculoRepositorio.saveAll(lstvehiculo);
	}



	
	
}
