package com.mycompany.texpress.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="experiencia")
public class Experiencia implements Serializable{

	 
	private static final long serialVersionUID = 1L;
	
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	@Id
	@Column(name="codexperiencia")
	   private int idexperiencia;	
	@Column(name="Nombre")
	   private String nombres;	
	@Column(name="apellido")
	   private String apellido;	
	@Column(name="Correo")
	   private String Correo;	
	@Column(name="Telefono")
	   private String telefono;
	@Column(name="direccion")
	   private String direccion;	
	@Column(name="cuidadresidencia")
	   private String cuidadresidencia;	
	@Column(name="experiencia")
	   private String experiencia;	
	@Column(name="licenciaconductor")
	   private String licenciaconductor;	
	@Column(name="categoria")
	   private String categoria;	
	@Column(name="tipodocumentos")
	   private String tipodocumentos;	
	@Column(name="numerodocumento")
	   private String numerodocumento;
	@Column(name="lugarexpedicion")
	   private String lugarexpedicion;
	@Column(name="claselibreta")
	   private String  claselibreta;
	@Column(name="numerolibreta")
	   private String numerolibreta;
	@Column(name="lugarexpedicionl")
	   private String lugarexpedicionl;
	@Column(name="empresa1")
	   private String empresa1;
	@Column(name="pdf1")
	   private Blob pdf1;
	@Column(name="empresa2")
	   private String empresa2;
	@Column(name=" pdf2")
	   private Blob  pdf2;
	@Column(name="empresa3")
	   private String empresa3;
	@Column(name="pdf3")
	   private Blob pdf3;
	@Column(name="fechanacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	   private Date fechanacimiento;
	@Column(name="imagenusuario")
	   private Blob imagenusuario;
	@Column(name="lugarnacimiento")
	   private String lugarnacimiento;
	@Column(name="nacionalidad")
	   private String nacionalidad;
	
	
	
	@ManyToOne()
	   @JoinColumn(name ="usuario_idusuario")
	private Usuario usuario;
	
	@ManyToOne()
	   @JoinColumn(name ="cargo_idcargo")
	private Cargo cargo;

	public int getIdexperiencia() {
		return idexperiencia;
	}

	public void setIdexperiencia(int idexperiencia) {
		this.idexperiencia = idexperiencia;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuidadresidencia() {
		return cuidadresidencia;
	}

	public void setCuidadresidencia(String cuidadresidencia) {
		this.cuidadresidencia = cuidadresidencia;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getLicenciaconductor() {
		return licenciaconductor;
	}

	public void setLicenciaconductor(String licenciaconductor) {
		this.licenciaconductor = licenciaconductor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipodocumentos() {
		return tipodocumentos;
	}

	public void setTipodocumentos(String tipodocumentos) {
		this.tipodocumentos = tipodocumentos;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getLugarexpedicion() {
		return lugarexpedicion;
	}

	public void setLugarexpedicion(String lugarexpedicion) {
		this.lugarexpedicion = lugarexpedicion;
	}

	public String getClaselibreta() {
		return claselibreta;
	}

	public void setClaselibreta(String claselibreta) {
		this.claselibreta = claselibreta;
	}

	public String getNumerolibreta() {
		return numerolibreta;
	}

	public void setNumerolibreta(String numerolibreta) {
		this.numerolibreta = numerolibreta;
	}

	public String getLugarexpedicionl() {
		return lugarexpedicionl;
	}

	public void setLugarexpedicionl(String lugarexpedicionl) {
		this.lugarexpedicionl = lugarexpedicionl;
	}

	public String getEmpresa1() {
		return empresa1;
	}

	public void setEmpresa1(String empresa1) {
		this.empresa1 = empresa1;
	}

	public Blob getPdf1() {
		return pdf1;
	}

	public void setPdf1(Blob pdf1) {
		this.pdf1 = pdf1;
	}

	public String getEmpresa2() {
		return empresa2;
	}

	public void setEmpresa2(String empresa2) {
		this.empresa2 = empresa2;
	}

	public Blob getPdf2() {
		return pdf2;
	}

	public void setPdf2(Blob pdf2) {
		this.pdf2 = pdf2;
	}

	public String getEmpresa3() {
		return empresa3;
	}

	public void setEmpresa3(String empresa3) {
		this.empresa3 = empresa3;
	}

	public Blob getPdf3() {
		return pdf3;
	}

	public void setPdf3(Blob pdf3) {
		this.pdf3 = pdf3;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Blob getImagenusuario() {
		return imagenusuario;
	}

	public void setImagenusuario(Blob imagenusuario) {
		this.imagenusuario = imagenusuario;
	}

	public String getLugarnacimiento() {
		return lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
