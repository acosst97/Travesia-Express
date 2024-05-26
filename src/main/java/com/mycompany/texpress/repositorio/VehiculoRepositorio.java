package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Vehiculo;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo,String>{

	
}
