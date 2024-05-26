package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Pqrs;

@Repository
public interface PqrsRepositorio extends JpaRepository<Pqrs,Integer>{
  
	
	
}
