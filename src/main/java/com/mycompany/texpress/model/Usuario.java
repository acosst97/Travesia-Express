package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name="idusuario")
	private int idusuario;
	@NotEmpty(message = "El nombre es obligatorio")
	@Column(name="nombreusuario")
	private String nombreusuario;
	@NotEmpty(message = "El apellido es obligatorio")
	@Column(name="apellidousuario")
	private String apellidousuario;
	@NotNull
	@Min(value = 18)
	@Column(name="edad")
	private int edad;
	@NotNull(message = "El telefono es obligatorio")
	@Min(value = 6)
	@Column(name="telefono")
	private int telefono;
	@Email
	@NotEmpty(message = "El correo es obligatorio")	
	@Column(name="correo")
	private String correo;
	@NotEmpty(message = "La dirección es obligatoria")
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="clave")
	@NotEmpty(message = "La contraseña es obligatoria")
	private String clave;
	@Column(name="reset_password_token")
	private String resetPasswordToken;
	
	
	
	/*de usuario a experiencia */
	@OneToMany(mappedBy = "usuario")
    private List<Experiencia> lstexperiencia;
	
	
	/*de usuario a beneficio */
	@OneToMany(mappedBy = "usuario")
    private List<Beneficio> lstbeneficio;
	
	/*pqrs */
	@OneToMany(mappedBy = "usuario")
    private List<Pqrs> lstpqrs;
	
	/*ruta*/
	@OneToMany(mappedBy = "usuario")
	private List<Ruta> lstruta;
	
	/*de usuario a venta */
	@OneToMany(mappedBy = "usuario")
    private List<Venta> venta;
	
	
	
	/*reportevehiculo */
	@OneToMany(mappedBy = "usuario")
	private List<ReporteVehiculo> lstreporte;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name="usuarios_roles", 
        joinColumns = {@JoinColumn(name="usuario_id")},
        inverseJoinColumns = {@JoinColumn(name="rol_id") } )
    private Collection<Rol>  roles;

	public boolean hasRole(String nombre_rol){
		Iterator<Rol> iterator = this.roles.iterator();
		while (iterator.hasNext()){
			Rol rol = iterator.next();
			if (rol.getNombrerol().equals(nombre_rol)){
				return true;
			}
		}
		return false;
	}
	
	
	
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
	/*++*/
	public List<Beneficio> getLstbeneficio() {
		return lstbeneficio;
	}
	public void setLstbeneficio(List<Beneficio> lstbeneficio) {
		this.lstbeneficio = lstbeneficio;
	}
	public List<Pqrs> getLstpqrs() {
		return lstpqrs;
	}
	public void setLstpqrs(List<Pqrs> lstpqrs) {
		this.lstpqrs = lstpqrs;
	}
	public List<Ruta> getLstruta() {
		return lstruta;
	}
	public void setLstruta(List<Ruta> lstruta) {
		this.lstruta = lstruta;
	}
	public List<Experiencia> getLstexperiencia() {
		return lstexperiencia;
	}
	public void setLstexperiencia(List<Experiencia> lstexperiencia) {
		this.lstexperiencia = lstexperiencia;
	}
	public List<ReporteVehiculo> getLstreporte() {
		return lstreporte;
	}
	public void setLstreporte(List<ReporteVehiculo> lstreporte) {
		this.lstreporte = lstreporte;
	}
	public List<Venta> getVenta() {
		return venta;
	}
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}
	public Usuario orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	public Usuario(int idusuario, @NotEmpty(message = "El nombre es obligatorio") String nombreusuario,
			@NotEmpty(message = "El apellido es obligatorio") String apellidousuario, @NotNull @Min(18) int edad,
			@NotNull(message = "El telefono es obligatorio") @Min(6) int telefono,
			@Email @NotEmpty(message = "El correo es obligatorio") String correo,
			@NotEmpty(message = "La dirección es obligatoria") String direccion,
			@NotEmpty(message = "La contraseña es obligatoria") String clave, String resetPasswordToken,
			List<Experiencia> lstexperiencia, List<Beneficio> lstbeneficio, List<Pqrs> lstpqrs, List<Ruta> lstruta,
			List<Venta> venta, List<ReporteVehiculo> lstreporte, Collection<Rol> roles) {
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
		this.lstexperiencia = lstexperiencia;
		this.lstbeneficio = lstbeneficio;
		this.lstpqrs = lstpqrs;
		this.lstruta = lstruta;
		this.venta = venta;
		this.lstreporte = lstreporte;
		this.roles = roles;
	}
	
	
	
	
	public Usuario(@NotEmpty(message = "El nombre es obligatorio") String nombreusuario,
			@NotEmpty(message = "El apellido es obligatorio") String apellidousuario, @NotNull @Min(18) int edad,
			@NotNull(message = "El telefono es obligatorio") @Min(6) int telefono,
			@Email @NotEmpty(message = "El correo es obligatorio") String correo,
			@NotEmpty(message = "La dirección es obligatoria") String direccion,
			@NotEmpty(message = "La contraseña es obligatoria") String clave, String resetPasswordToken,
			List<Experiencia> lstexperiencia, List<Beneficio> lstbeneficio, List<Pqrs> lstpqrs, List<Ruta> lstruta,
			List<Venta> venta, List<ReporteVehiculo> lstreporte, Collection<Rol> roles) {
		super();
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.clave = clave;
		this.resetPasswordToken = resetPasswordToken;
		this.lstexperiencia = lstexperiencia;
		this.lstbeneficio = lstbeneficio;
		this.lstpqrs = lstpqrs;
		this.lstruta = lstruta;
		this.venta = venta;
		this.lstreporte = lstreporte;
		this.roles = roles;
	}
	public Usuario() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
