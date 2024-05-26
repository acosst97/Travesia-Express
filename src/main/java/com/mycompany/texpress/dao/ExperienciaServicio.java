package com.mycompany.texpress.dao;

import java.util.List;

import com.mycompany.texpress.model.Experiencia;

public interface ExperienciaServicio {

	
	public List<Experiencia> buscartodos();
	
	public void CrearExperiencia(Experiencia experiencia);
	
	public void EliminarExperiencia(int idexperiencia);
}
