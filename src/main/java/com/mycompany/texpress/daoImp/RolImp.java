package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.RolServicio;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.RolRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Service
public class RolImp implements RolServicio{
    
	
	@Autowired
	private RolRepositorio rolRepositorio;
	@Override
	public List<Rol> buscartodos() {
		
		return rolRepositorio.findAll();
	}

	@Override
	public void CrearRol(Rol rol) {
	
	    int res=0;
		Rol roles= rolRepositorio.save(rol);
		if(!roles.equals(null)) {
			res=1;   
		}
	}

	@Override
	public Rol buscarById(Integer idrol) {
		
		return rolRepositorio.getById(idrol);
	}
	
	
	
	/*	@Override
	public Usuario buscaridrol(int idrol) {
	
		return usuarioRepositorio.getById(idrol);
	}*/
  
	
}
