package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idrol")
	private int idrol;
	@Column(name="nombrerol")
	private String nombrerol;
	
	/*@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuario;*/
	
	@ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
	
	
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public String getNombrerol() {
		return nombrerol;
	}
	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Rol(int idrol, String nombrerol, List<Usuario> usuarios) {
		super();
		this.idrol = idrol;
		this.nombrerol = nombrerol;
		this.usuarios = usuarios;
	}
	
	
	public Rol(String nombrerol) {
		super();
		this.nombrerol = nombrerol;
	}
	
	public Rol() {
		super();
	}
	
	
	
	
	

}
