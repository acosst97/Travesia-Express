package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.BeneficioServicio;
import com.mycompany.texpress.model.Beneficio;
import com.mycompany.texpress.repositorio.BeneficioRepositorio;

@Service
public class BeneficioImp implements BeneficioServicio{

	@Autowired
	private BeneficioRepositorio beneficioRepositorio;
	@Override
	public List<Beneficio> buscartodos() {
		
		return beneficioRepositorio.findAll();
	}

	@Override
	public void EliminarBeneficio(Integer beneficio) {
		
		beneficioRepositorio.deleteById(beneficio);
		
	}

	@Override
	public void CrearBeneficio(Beneficio beneficio) {
		int res =0;
		Beneficio beneficio1 = beneficioRepositorio.save(beneficio);
		if (!beneficio1.equals(null)) {
			res =1;
		}
		
		
	}

	@Override
	public void ActualizarBeneficio(Beneficio beneficio) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

	
	
}
