package com.mycompany.texpress.daoImp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.texpress.dao.ReporteVehiculoServicio;
import com.mycompany.texpress.model.ReporteVehiculo;

import com.mycompany.texpress.repositorio.ReporteVehiculoRepositorio;

@Service
public class ReporteVehiculoImp implements ReporteVehiculoServicio{

	
	
	
	
	@Autowired
	ReporteVehiculoRepositorio reportevehiculoRepositorio;
	@Override
	public List<ReporteVehiculo> buscartodos() {
		return reportevehiculoRepositorio.findAll();
	}
	@Override
	public void CrearReporte(ReporteVehiculo reporte) {
		int res=0;
			ReporteVehiculo report = reportevehiculoRepositorio.save(reporte);	
				if (!report.equals(null)) {
					res=1;
				}
		
	}
	@Override
	public void actualizarReporte(ReporteVehiculo idreporte) {
		
		int res=0;
		ReporteVehiculo report = reportevehiculoRepositorio.save(idreporte);
			if (!report.equals(null)) {
				res=1;
			} 
	}
	
	
	
	@Override
	public ReporteVehiculo buscarBYId(int idreporte) {
		
		return reportevehiculoRepositorio.getById(idreporte);
	}
	
	@Override
	public List<ReporteVehiculo> listareport(String matriculavehiculo) {
		
		return reportevehiculoRepositorio.findlistareporte();
	}
	
	
	
	

	
}
