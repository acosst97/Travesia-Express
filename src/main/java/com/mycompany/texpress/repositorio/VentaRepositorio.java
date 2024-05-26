package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Venta;

@Repository
public interface VentaRepositorio  extends JpaRepository<Venta,Integer>{

	
	public Venta findBydetalleventa(String  detalleventa);
}
