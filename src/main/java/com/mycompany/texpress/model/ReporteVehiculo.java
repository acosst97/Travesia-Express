package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name ="reportevehiculo")
public class ReporteVehiculo  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idreporte")
	private int idreporte;
	@Column(name="diaentrega")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date reporteentrega;
	@Column(name="diallegada")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date reportellegada;
	@Column(name="estadovehiculo")
	private String estadovehiculo; 
	@Column(name="diareporte")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date diareporte;
	
	
	@ManyToOne()
	@JoinColumn(name ="usuario_idusuario")
	private  Usuario usuario;
	
	/* rv a vehiculo*/
	@ManyToOne()
	@JoinColumn(name ="vehiculo_matriculavehiculo")
	private Vehiculo vehiculo;
	
	
	
	
	
	public int getIdreporte() {
		return idreporte;
	}
	public void setIdreporte(int idreporte) {
		this.idreporte = idreporte;
	}
	public Date getReporteentrega() {
		return reporteentrega;
	}
	public void setReporteentrega(Date reporteentrega) {
		this.reporteentrega = reporteentrega;
	}
	public Date getReportellegada() {
		return reportellegada;
	}
	public void setReportellegada(Date reportellegada) {
		this.reportellegada = reportellegada;
	}
	public String getEstadovehiculo() {
		return estadovehiculo;
	}
	public void setEstadovehiculo(String estadovehiculo) {
		this.estadovehiculo = estadovehiculo;
	}
	public Date getDiareporte() {
		return diareporte;
	}
	public void setDiareporte(Date diareporte) {
		this.diareporte = diareporte;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	
	
}
