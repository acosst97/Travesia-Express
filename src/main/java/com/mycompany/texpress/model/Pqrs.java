package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="pqrs")
public class Pqrs implements Serializable {

	private static final long serialVersionUID = 1L;	

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="idpqrs")
   private int id;
   @NotEmpty(message = "La informacón  es obligatoria")
   @Column(name="detallepqrs")
   private String detalles;
   @NotNull(message = "La fecha debe ser presente")
   @Past
   @Column(name="fechapqrs")     
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @Temporal(TemporalType.DATE)
   private Date fecha;
  
   @Column(name="respuestapqrs") 
   private String respuesta;
   @Email
   @NotEmpty(message = "El correo es obligatorio")
   @Column(name="correo")  
   
   private String correo;
   
   
   @ManyToOne()
   @JoinColumn(name ="usuario_idusuario")
   
   private Usuario usuario;
   
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getDetalles() {
	return detalles;
}
public void setDetalles(String detalles) {
	this.detalles = detalles;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getRespuesta() {
	return respuesta;
}
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}

public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


   
   
   
   
	
	
	
	
	
}
