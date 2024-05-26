package com.mycompany.texpress.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mycompany.texpress.model.ReporteVehiculo;


public interface ReporteVehiculoServicio {

	
	public List<ReporteVehiculo> buscartodos();
	
	public void CrearReporte(ReporteVehiculo reporte);
	
	public void actualizarReporte(ReporteVehiculo idreporte);
	
	public List<ReporteVehiculo> listareport(String matriculavehiculo);
	
	ReporteVehiculo buscarBYId(int idreporte);
	
	
	
}
