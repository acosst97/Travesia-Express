package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.RutaServicio;
import com.mycompany.texpress.model.Ruta;
import com.mycompany.texpress.repositorio.RutaRepositorio;

@Service
public class RutaImp implements RutaServicio {

	@Autowired
	private RutaRepositorio rutaRepositorio;

	@Override
	public List<Ruta> buscartodos() {
		
		return rutaRepositorio.findAll();
	}
}
