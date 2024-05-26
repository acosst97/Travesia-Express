package com.mycompany.texpress.usuarios.Dto;

import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mycompany.texpress.model.Rol;

public class UsuarioRegistroDto {

	private int idusuario;
	
	private String nombreusuario;
	
	private String apellidousuario;
	
	private int edad;
	
	private int telefono;
	
	private String correo;
	
	private String direccion;
	
	private String clave; 
	
	private String resetPasswordToken;

	private Collection <Rol> roles;
	
	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getApellidousuario() {
		return apellidousuario;
	}

	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	
	

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	

	public UsuarioRegistroDto(int idusuario, String nombreusuario, String apellidousuario, int edad, int telefono,
			String correo, String direccion, String clave, String resetPasswordToken, Collection<Rol> roles) {
		super();
		this.idusuario = idusuario;
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.clave = clave;
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
	}
	
	

	public UsuarioRegistroDto(String nombreusuario, String apellidousuario, int edad, int telefono, String correo,
			String direccion, String clave, String resetPasswordToken, Collection<Rol> roles) {
		super();
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.clave = clave;
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
	}

	public UsuarioRegistroDto(String correo) {
		super();
		this.correo = correo;
	}

	public UsuarioRegistroDto() {
		super();
	}

	 
	
}
