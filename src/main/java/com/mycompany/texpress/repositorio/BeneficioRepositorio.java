package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mycompany.texpress.model.Beneficio;

@Repository
public interface BeneficioRepositorio extends JpaRepository<Beneficio,Integer>{

	
	
}
