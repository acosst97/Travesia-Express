package com.mycompany.texpress.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="vehiculo")
public class Vehiculo  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="matriculavehiculo")
	private String matriculavehiculo;
	@Column(name="color")
	private String color;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@Column(name="tipovehiculo")
	private String tipovehiculo;
	@Column(name="capacidad")
	private int capacidad;
	@Column(name="tarjetaoperacion")
	private String tarjetaoperacion;
	@Column(name="tarjetapropiedad")
	private String tarjetapropiedad;
	@Column(name="soat")
	private String soat;
	@Column(name="tecnicomecanica")
	private String tecnicomecanica;
	
	/* vehi a reporteV*/
	@OneToMany(mappedBy = "vehiculo"/*, cascade = CascadeType.REFRESH , orphanRemoval = true*/)
	private List<ReporteVehiculo> vehiculo;

	/* vehi a servi*/
	@OneToMany(mappedBy = "vehiculo")
	private List<Servicio> servicio;
	
	public String getMatriculavehiculo() {
		return matriculavehiculo;
	}

	public void setMatriculavehiculo(String matriculavehiculo) {
		this.matriculavehiculo = matriculavehiculo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTarjetaoperacion() {
		return tarjetaoperacion;
	}

	public void setTarjetaoperacion(String tarjetaoperacion) {
		this.tarjetaoperacion = tarjetaoperacion;
	}

	public String getTarjetapropiedad() {
		return tarjetapropiedad;
	}

	public void setTarjetapropiedad(String tarjetapropiedad) {
		this.tarjetapropiedad = tarjetapropiedad;
	}

	public String getSoat() {
		return soat;
	}

	public void setSoat(String soat) {
		this.soat = soat;
	}

	public String getTecnicomecanica() {
		return tecnicomecanica;
	}

	public void setTecnicomecanica(String tecnicomecanica) {
		this.tecnicomecanica = tecnicomecanica;
	}

	public List<ReporteVehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(List<ReporteVehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Vehiculo(String matriculavehiculo, String color, String marca, String modelo, String tipovehiculo,
			int capacidad, String tarjetaoperacion, String tarjetapropiedad, String soat, String tecnicomecanica,
			List<ReporteVehiculo> vehiculo, List<Servicio> servicio) {
		super();
		this.matriculavehiculo = matriculavehiculo;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.tipovehiculo = tipovehiculo;
		this.capacidad = capacidad;
		this.tarjetaoperacion = tarjetaoperacion;
		this.tarjetapropiedad = tarjetapropiedad;
		this.soat = soat;
		this.tecnicomecanica = tecnicomecanica;
		this.vehiculo = vehiculo;
		this.servicio = servicio;
	}

	public Vehiculo(String color, String marca, String modelo, String tipovehiculo, int capacidad,
			String tarjetaoperacion, String tarjetapropiedad, String soat, String tecnicomecanica,
			List<ReporteVehiculo> vehiculo, List<Servicio> servicio) {
		super();
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.tipovehiculo = tipovehiculo;
		this.capacidad = capacidad;
		this.tarjetaoperacion = tarjetaoperacion;
		this.tarjetapropiedad = tarjetapropiedad;
		this.soat = soat;
		this.tecnicomecanica = tecnicomecanica;
		this.vehiculo = vehiculo;
		this.servicio = servicio;
	}

	public Vehiculo() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	

}

