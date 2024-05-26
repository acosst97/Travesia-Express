package com.mycompany.texpress.dao;

import java.util.List;
import com.mycompany.texpress.model.Beneficio;


public interface BeneficioServicio {
  
	public List<Beneficio> buscartodos();
	
	public void  CrearBeneficio(Beneficio beneficio);
	
	public void EliminarBeneficio(Integer beneficio);
	
	public void ActualizarBeneficio(Beneficio beneficio);
	
}

