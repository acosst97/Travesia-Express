package com.mycompany.texpress.daoImp;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.UsuarioService;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;
import com.mycompany.texpress.usuarios.Dto.UsuarioRegistroDto;

@Service
@Transactional
public class UsuarioServicioImp implements UsuarioService{

	
	
    @Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	private Usuario usuario;
	
	@Override
	public Usuario guardar(UsuarioRegistroDto registroDto) {
		
		
		
		
		
		Usuario  usuario = new Usuario();
		usuario.setIdusuario(registroDto.getIdusuario());
		usuario.setNombreusuario(registroDto.getNombreusuario());
		usuario.setApellidousuario(registroDto.getApellidousuario());
		usuario.setEdad(registroDto.getEdad());
		usuario.setTelefono(registroDto.getTelefono());
		usuario.setCorreo(registroDto.getCorreo());
		usuario.setDireccion(registroDto.getDireccion());
		usuario.setClave(PasswordEncoder.encode(registroDto.getClave()));
	    usuario.setRoles(registroDto.getRoles());
		Arrays.asList(new Rol().getNombrerol());
		return  usuarioRepositorio.save(usuario);
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuario usuario = usuarioRepositorio.findByCorreo(username);
		
		if (usuario == null) {			
			throw new UsernameNotFoundException("Usuario o password invalidos");						
		}
		return  new User(usuario.getCorreo(), usuario.getClave(), mapearAutoridadesARoles(usuario.getRoles()));
	}

	
	private Collection<? extends GrantedAuthority> mapearAutoridadesARoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombrerol())).collect(Collectors.toList());
		
	}
	
	public boolean hasRole(String nombre_rol){
		return this.usuario.hasRole(nombre_rol);
	}
	
	
}
