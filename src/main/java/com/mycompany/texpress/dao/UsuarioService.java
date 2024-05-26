package com.mycompany.texpress.dao;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.usuarios.Dto.UsuarioRegistroDto;

public interface UsuarioService extends  UserDetailsService{

	
	public Usuario guardar(UsuarioRegistroDto usuarioregistrodto);

	

	
}
