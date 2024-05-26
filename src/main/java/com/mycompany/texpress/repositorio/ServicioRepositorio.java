package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio,Integer>{

	
}
