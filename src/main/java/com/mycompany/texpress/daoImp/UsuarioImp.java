package com.mycompany.texpress.daoImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.mycompany.texpress.dao.UsuarioServicio;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;
import com.mycompany.texpress.resetcontra.UsuarioNotFoundException;
import com.mycompany.texpress.usuarios.Dto.UsuarioRegistroDto;

@Service
@Transactional
public class UsuarioImp implements UsuarioServicio {

	
	private BCryptPasswordEncoder PasswordEncoder;
	
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	

	@Override
	public List<Usuario> buscartodos() {
		return usuarioRepositorio.findAll();
	}
	@Override
	public void crearUsuario(Usuario usuario) {
		int res=0;
		Usuario usuarios=usuarioRepositorio.save(usuario);
		if(!usuarios.equals(null)) {
			res=1;
		}
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		int res=0;
		Usuario usuarios=usuarioRepositorio.save(usuario);
		if(!usuarios.equals(null)) {
			res=1;
		}
		
	}

	
	@Override
	public void eliminarUsuario(Usuario usuario) {
		
		
	}

	@Override
	public List<Usuario> listareporte(Usuario usuario) {
		
		
		return usuarioRepositorio.findByreporte();
	}

	@Override
	public Usuario buscarBYId(Integer idusuario) {
		
		return usuarioRepositorio.getById(idusuario);
	}

   
	
    public void updateResetPassword(String token, String correo) throws UsuarioNotFoundException  {
    	
    	Usuario usuario = usuarioRepositorio.findByCorreo(correo);
		
		if (usuario != null) {
			usuario.setResetPasswordToken(token);
			usuarioRepositorio.save(usuario);
		}else{
			throw new UsuarioNotFoundException("No se pudo enviar no se reconoce correo " + correo);
		}
    }
	
    
	
	
	
	
	public Usuario getByResetPasswordToken(String token) {
		
		return usuarioRepositorio.findByResetPasswordToken(token);
		
	}
	
	
	public void updatePassword(Usuario usuario,String newPassword) {
		
		BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
		String encodedpassword = passwordEncoder.encode(newPassword);
		usuario.setClave(encodedpassword);
		usuario.setResetPasswordToken(null);		
		usuarioRepositorio.save(usuario);
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
    

	
	
	
}
