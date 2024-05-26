package com.mycompany.texpress.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.texpress.daoImp.ServicioImp;
import com.mycompany.texpress.model.Servicio;


@Controller
@RequestMapping
public class ServicioControlador {
 
	@Autowired
	ServicioImp servicioImp;
	
	@GetMapping("/listarServicios")
	public String listarservicios(Model model) {		
		List<Servicio> lstServicios = this.servicioImp.buscartodos();
		model.addAttribute("lstServicios", lstServicios);
		return "product";
		
	}
	
	/* lista desde el dashboard*/
	@GetMapping("/lstservicio2")
	public String listarservicio(Model model) {		
		List<Servicio> lstServicios = this.servicioImp.buscartodos();
		model.addAttribute("lstServicios", lstServicios);
		return "listservicios";
		
	}
	
	
	
	@GetMapping("/newservicio")
	public String newservicio(Model model) {
		model.addAttribute("Servicio", new Servicio());
		return"regservicio";
	}
		
	@PostMapping("/guardarservicio")
	public String guardarservicio(@Valid Servicio servicio, Model model) {
		servicioImp.crearServicio(servicio);
		return "redirect:/Servicios";
	}
	
	@GetMapping("/modificarServicio")
	public String guardarmodi(Servicio servicio, Model model) {
		Servicio servi = new Servicio();
		servi=servicioImp.buscarById(servicio.getIdservicio());
		model.addAttribute("servicio", servi);
		return "modificarservicio";
	}
	
	
	@PostMapping("/editarservicio")
	public String editarservicio(Servicio servicio, Model model) {	
		servicioImp.actualizarServicio(servicio);
		return "redirect:/Servicios";
	}
	
	@GetMapping("/Servicios")
	public String servicio(Model model) {		
		List<Servicio> lstServicios = this.servicioImp.buscartodos();
		model.addAttribute("lstServicios", lstServicios);
		return "Servicios";
		
	}
	
	@GetMapping("/eliminar1/{idservicio}")
	public String eliminarse(Model model,@PathVariable Integer idservicio) {
		servicioImp.eliminarServicio(idservicio);
		return "redirect:/Servicios";
	}
	
	
	
	
	
}
