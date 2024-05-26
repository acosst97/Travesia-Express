package com.mycompany.texpress.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.texpress.dao.PqrsServicio;
import com.mycompany.texpress.model.Pqrs;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.PqrsRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Service
public class PqrsImp implements PqrsServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PqrsRepositorio pqrsRepositorio;
	
	@Override
	public List<Pqrs> buscartodos() {
		
		return pqrsRepositorio.findAll();
	}
	
	@Override
	public void crearPqrs(Pqrs pqrs) {
		int res= 0;
		Pqrs pq = pqrsRepositorio.save(pqrs);
				if (!pq.equals(null)) {
					res=1;
				}
	}
	@Override
	public void editarPqrs(Pqrs pqrs) {
	/*Pqrs obpqrs	= pqrsRepositorio.save(pqrs);	*/

	}
	@Override
	public void eliminarPqrs(Pqrs pqrs) {
		// TODO Auto-generated method stub
		
	}


	
	
}
