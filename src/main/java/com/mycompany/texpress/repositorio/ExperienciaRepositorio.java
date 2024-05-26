package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Experiencia;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Integer> {

}
