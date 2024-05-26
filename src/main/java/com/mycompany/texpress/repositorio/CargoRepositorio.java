package com.mycompany.texpress.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Cargo;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo,Integer> {

}
