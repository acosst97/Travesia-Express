package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.ExperienciaServicio;
import com.mycompany.texpress.model.Experiencia;
import com.mycompany.texpress.repositorio.ExperienciaRepositorio;

@Service
public class ExperienciaImp implements ExperienciaServicio {

	
	@Autowired
	ExperienciaRepositorio experienciaRepositorio;

	@Override
	public List<Experiencia> buscartodos() {
		
		return experienciaRepositorio.findAll();
	}

	@Override
	public void CrearExperiencia(Experiencia experiencia) {
		int res= 0;
		Experiencia ex = experienciaRepositorio.save(experiencia);
				if (!ex.equals(null)) {
					res=1;
				}
	}

	@Override
	public void EliminarExperiencia(int idexperiencia) {
		
	experienciaRepositorio.deleteById(idexperiencia);
		
	}
		
	
}
