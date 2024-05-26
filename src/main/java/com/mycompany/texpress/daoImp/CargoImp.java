package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.CargoServicio;
import com.mycompany.texpress.model.Cargo;
import com.mycompany.texpress.repositorio.CargoRepositorio;

@Service
public class CargoImp implements CargoServicio {

	
	@Autowired
	CargoRepositorio cargoRepositorio;	
	
	@Override
	public List<Cargo> buscartodos() {
		
		return null;
	}

	
	
}
