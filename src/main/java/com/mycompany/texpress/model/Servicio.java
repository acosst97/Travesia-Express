package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {

 private static final long serialVersionUID = 1L;
 
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	@Column(name="idservicio")
    private int idservicio;
    @Column(name="fechaservicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaservicio;
    @Column(name="ofertas")
    private String ofertas;
    @Column(name="nomservicio")
    private String nomservicio;
    @Column(name="precioservicio")
    private int precio;
    
   
    /* de servicio a ruta */
    @OneToMany(mappedBy = "servicio"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Ruta> ruta;
    
    @ManyToOne()
	@JoinColumn(name ="vehiculo_matriculavehiculo")
    private Vehiculo vehiculo;
    
    
    /*de servicio  a venta  */
	@OneToMany(mappedBy = "servicio")
    private List<Venta> venta;
    
   
	
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	public Date getFechaservicio() {
		return fechaservicio;
	}
	public void setFechaservicio(Date fechaservicio) {
		this.fechaservicio = fechaservicio;
	}
	public String getOfertas() {
		return ofertas;
	}
	public void setOfertas(String ofertas) {
		this.ofertas = ofertas;
	}
	public String getNomservicio() {
		return nomservicio;
	}
	public void setNomservicio(String nomservicio) {
		this.nomservicio = nomservicio;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public List<Ruta> getRuta() {
		return ruta;
	}
	public void setRuta(List<Ruta> ruta) {
		this.ruta = ruta;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
 
    
	
	
	
	
	
 
	
}
