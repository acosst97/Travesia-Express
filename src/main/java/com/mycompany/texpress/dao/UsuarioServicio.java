package com.mycompany.texpress.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.resetcontra.UsuarioNotFoundException;
import com.mycompany.texpress.usuarios.Dto.UsuarioRegistroDto;

public interface UsuarioServicio extends  UserDetailsService  {

	
	
	public List<Usuario> buscartodos();

    public void crearUsuario (Usuario usuario);
	
	public void actualizarUsuario (Usuario usuario);
	
	public void eliminarUsuario (Usuario usuario);
	
	public List<Usuario> listareporte(Usuario usuario);
	
	Usuario buscarBYId(Integer idusuario);

	/*secutiry registro*/
    
    

	
	/* reset  contraseña*/
	/*public void updateResetPasswordToken(String token, String correo) throws UsuarioNotFoundException;	
	/*public Usuario get(String resetPasswordToken);	
	public void updatePassword(Usuario usuario,String newPassword);*/
    //	++++++++



	/*void updateResetPasswordtoken(String token, String correo) throws UsuarioNotFoundException;*/
	
	
	
}
