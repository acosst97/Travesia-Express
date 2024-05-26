package com.mycompany.texpress.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.texpress.daoImp.BeneficioImp;
import com.mycompany.texpress.daoImp.ServicioImp;
import com.mycompany.texpress.model.Beneficio;
import com.mycompany.texpress.model.Servicio;

@Controller
@RequestMapping
public class BeneficioControlador {

	@Autowired
	BeneficioImp beneficioImp;
	
	@Autowired
	ServicioImp servicioImp;
	
	 
	
	@GetMapping("/of1")
    public String fideli(Model model){
        
		List<Beneficio> lstbenefi = this.beneficioImp.buscartodos();
		List<Servicio> lstServicios = this.servicioImp.buscartodos();
		model.addAttribute("lstServicios", lstServicios);
        model.addAttribute("lstbenefi", lstbenefi);
       
    return  "/of1";
    
    }
	
	@GetMapping("/regbeneficio")
    public String registrobe(Model model){
		model.addAttribute("beneficio" ,new Beneficio());
    return  "regbeneficio";
    }
	
	
	@PostMapping("/guardarBeneficio")
    public String guardar(Beneficio beneficio, Model model){	                                          
	beneficioImp.CrearBeneficio(beneficio);      
    return "redirect:/regbeneficio";
    
    }
	
	
	 @RequestMapping("/eliminarb")
    public String eliminarbe(@RequestParam(name = "id", defaultValue = "0") int id) {
        beneficioImp.EliminarBeneficio(id);
        return "redirect:/of1"; 
    
    } 
	
	
	
	
	 
}
