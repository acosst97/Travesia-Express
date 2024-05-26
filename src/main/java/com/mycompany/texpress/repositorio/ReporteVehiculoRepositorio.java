package com.mycompany.texpress.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.ReporteVehiculo;


@Repository
public interface ReporteVehiculoRepositorio extends JpaRepository<ReporteVehiculo,Integer> {

	
	@Query(value="SELECT v.matriculavehiculo, r.Diallegada, v.modelo,  v.capacidad , r.diareporte, r.diaentrega, r.estadovehiculo\r\n"
			+ "  from  vehiculo v\r\n"
			+ "inner join reportevehiculo r on  v.matriculavehiculo   =  r.vehiculo_matriculavehiculo\r\n"
			+ "where r.DiaEntrega between \"2016-01-01\" and \"2022-05-08\"\r\n"
			+ "order by r.estadovehiculo;",nativeQuery = true)	
	public List<ReporteVehiculo> findlistareporte(); 
	
	public ReporteVehiculo findByidreporte(Integer idreporte);
	
}
