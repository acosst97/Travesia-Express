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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="venta")
public class Venta implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name="idventa")
    private int idventa;
	@NotEmpty(message = "El nombre del paquete es obligatorio")
    @Column(name="detalleventa")
    private String detalleventa;
	@PastOrPresent
    @Column(name="fechaventa")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
	@NotEmpty(message = "El precio es obligatorio")
    @Column(name="totalpago")
    private String totalpago;
     
	
    @ManyToOne()    
	@JoinColumn(name="usuario_idusuario")  
    private Usuario usuario;  
    
    @ManyToOne()
	@JoinColumn(name="servicio_idservicio")
    private Servicio servicio;  
    
    
    
	public int getIdventa() {
		return idventa;
	}
	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}
	public String getDetalleventa() {
		return detalleventa;
	}
	public void setDetalleventa(String detalleventa) {
		this.detalleventa = detalleventa;
	}
	public Date getFechaventa() {
		return fechaventa;
	}
	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}
	
	public String getTotalpago() {
		return totalpago;
	}
	public void setTotalpago(String totalpago) {
		this.totalpago = totalpago;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
   
    
    
	
	
}
