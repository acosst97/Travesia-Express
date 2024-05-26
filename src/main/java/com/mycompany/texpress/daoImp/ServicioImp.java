package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.ServicioServicio;
import com.mycompany.texpress.model.Servicio;
import com.mycompany.texpress.repositorio.ServicioRepositorio;

@Service
public class ServicioImp implements ServicioServicio {

    @Autowired
	private ServicioRepositorio servicioRepositorio;
	
    
   	@Override
   	public List<Servicio> buscartodos() {
   		// TODO Auto-generated method stub
   		return servicioRepositorio.findAll();
   	}

   	@Override
   	public void crearServicio(Servicio servicio) {
   		int res=0;
   		Servicio serv=servicioRepositorio.save(servicio);
   		if(!serv.equals(null)) {
   			res=1;
   		}
   		
   	}

   	@Override
   	public void actualizarServicio(Servicio servicio) {
   		int res=0;
   		Servicio servi=servicioRepositorio.save(servicio);
   		if(!servi.equals(null)) {
   			res=1;
   		}

   	}

     
   	

   	@Override
   	public Servicio buscarById(Integer idservicio) {
   	
   		return servicioRepositorio.getById(idservicio);
   	}

   	@Override
   	public void eliminarServicio(Integer idservicio) {
   		 servicioRepositorio.deleteById(idservicio);
   		
   	}

	
}
