package com.mycompany.texpress.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="ruta")
public class Ruta  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codruta")
	private int codruta;
	@Column(name="origenruta")
	private String origenruta;
	@Column(name="destinoruta")
	private String destinoruta;
	
	
	/* ruta a usuario*/
    @ManyToOne()
    @JoinColumn(name="usuario_idusuario")
    private Usuario usuario;
    
    /* ruta a servicio*/
    @ManyToOne()
    @JoinColumn(name="servicio_idservicio")
    private Servicio servicio;
    
    
    
    
	
	public int getCodruta() {
		return codruta;
	}
	public void setCodruta(int codruta) {
		this.codruta = codruta;
	}
	public String getOrigenruta() {
		return origenruta;
	}
	public void setOrigenruta(String origenruta) {
		this.origenruta = origenruta;
	}
	public String getDestinoruta() {
		return destinoruta;
	}
	public void setDestinoruta(String destinoruta) {
		this.destinoruta = destinoruta;
	}
	
	
	
	
	
	
	
}
