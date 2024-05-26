package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Ruta;

@Repository
public interface RutaRepositorio extends JpaRepository<Ruta,Integer> {

}
