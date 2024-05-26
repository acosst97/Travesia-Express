package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.VentaServicio;
import com.mycompany.texpress.model.Venta;
import com.mycompany.texpress.repositorio.VentaRepositorio;

@Service
public class VentaImp implements VentaServicio {

	@Autowired
	VentaRepositorio ventaRepositorio;

	@Override
	public List<Venta> buscartodos() {
		
		return ventaRepositorio.findAll();
	}

	@Override
	public void crearVenta(Venta Venta) {
		int res=0;
		Venta vent=ventaRepositorio.save(Venta);
		if(!vent.equals(null)) {
			res=1;
		}
		
	}

	@Override
	public void actualizarVenta(Venta Venta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarVenta(Integer idventa) {
	ventaRepositorio.deleteById(idventa);
	
	}

	@Override
	public Venta buscarById(Integer Venta) {
		
		return null;
	}

	@Override
	public List<Venta> saveAll(List<Venta> lstVenta) {
		
			return this.ventaRepositorio.saveAll(lstVenta);
		
	}
	
    
	
	
}
