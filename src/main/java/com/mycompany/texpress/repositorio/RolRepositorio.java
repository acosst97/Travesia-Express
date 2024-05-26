package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol,Integer> {

	
	public Rol findBynombrerol(Rol rol);
	
	
	
}
