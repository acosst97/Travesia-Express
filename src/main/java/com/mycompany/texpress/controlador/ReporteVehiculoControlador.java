package com.mycompany.texpress.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.texpress.daoImp.ReporteVehiculoImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.daoImp.VehiculoImp;
import com.mycompany.texpress.model.ReporteVehiculo;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.repositorio.ReporteVehiculoRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping
public class ReporteVehiculoControlador {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	ReporteVehiculoRepositorio reportevehiculoRepositorio;
	
	@Autowired
	ReporteVehiculoImp reportevehiculoImp;
	
	
	@Autowired
	VehiculoImp vehiculoImp;
	
	@Autowired
	UsuarioImp usuarioImp;
	
	
	
	@GetMapping ("/iniciocondu")
    public String conductor(Usuario usuario, Model model){
		 Usuario validar = usuarioRepositorio.getById(usuario.getIdusuario());
		 model.addAttribute("empleadoUsuario", validar);
			return "iniciocondu";
			 
		
    }
	@GetMapping("/regreportes")
	public String regreportes( Model model) {
	
		model.addAttribute("reporte", new ReporteVehiculo());
		return "regreportes";
	}
	
	
	
	
	@PostMapping("/guardarreporte")
	public String guardav(ReporteVehiculo reporte ,Model model) {	
				reportevehiculoImp.CrearReporte(reporte);
	
		return "redirect:/tablareportes";
	}
	
	
	@RequestMapping("/modificarreporte")
    public String modificarreporte(@RequestParam(name = "idreporte", defaultValue = "0") Integer idreporte,   Model model) {
        ReporteVehiculo reportevehiculo = reportevehiculoImp.buscarBYId(idreporte);
        model.addAttribute("reporte", reportevehiculo);
        return "modreporte";
    }
	
	 @PostMapping("/guardareporte2")
	    public String guardarcliente(ReporteVehiculo idreporte ,Model model) {
	        reportevehiculoImp.actualizarReporte(idreporte);
	        return "redirect:/tablareportes";
	    }
	
	 
	 
	
	/*
	@GetMapping("/editar/{idreporte}")
	public String modificarvehi( @PathVariable int idreporte, Model model) {		
		Optional<ReporteVehiculo> reporte = reportevehiculoImp.buscarBYIdreporte(idreporte); 	
		model.addAttribute("reporte", reporte);	
		return "regreportes";
	}
	
	@PostMapping("editarreporte")
	public String editar(@PathVariable int idreporte, Model model) {	
		reportevehiculoImp.buscarBYIdreporte(idreporte);
		return "redirect:/tablareportes";
	}
	*/
	
	@GetMapping ("/visreporte")
    public String reportes(Model model, ReporteVehiculo idreporte){
		ReporteVehiculo mireport = new  ReporteVehiculo();
		mireport = reportevehiculoImp.buscarBYId(idreporte.getIdreporte());
			
		List<ReporteVehiculo> lstreportev;
		lstreportev = this.reportevehiculoRepositorio.findAll();     
        model.addAttribute("lstreportev", lstreportev);
		
			return "vistareportes";
	
	}
	
	/*@GetMapping ("/visreporteid")
	public String buscarid(Model model, String matriculavehiculo){
		ReporteVehiculo myid = new  ReporteVehiculo();
		myid = (ReporteVehiculo) reportevehiculoImp.buscarByid(matriculavehiculo);
		model.addAttribute( "lstreportev", myid);
		
		return "vistaid";
	}*/
	
	
	
	
	/* INICIO DEL DASH CONDUCTOR*/
	
	
	
	
	
	
}
