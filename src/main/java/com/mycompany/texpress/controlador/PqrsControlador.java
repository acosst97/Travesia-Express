package com.mycompany.texpress.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.texpress.daoImp.PqrsImp;
import com.mycompany.texpress.daoImp.RolImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.model.Pqrs;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Controller 
@RequestMapping
public class PqrsControlador {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
    @Autowired
	PqrsImp pqrsImp;
	
    @Autowired
    UsuarioImp usuarioImp;
    
    @Autowired
    RolImp rolImp;
    
    
    /*  +++ control desde  administrador PQRS ++++ */
    
	@GetMapping("/lstpqrs")
	public String listarpqrs(Model model) {		
		List<Pqrs> lstPqrs = this.pqrsImp.buscartodos();
		model.addAttribute("lstPqrs", lstPqrs);
		return "PQRS";
		
	}
	
	/*  +++ registro desde index */
	
	@GetMapping("/registrarpqrs")
    public String pqrs(Pqrs pqrs){
      return "contacto";
	 
	}
	
	@PostMapping("/regPqrs")
	public String crearpqrs (Usuario usuario, Model model){
		model.addAttribute("pqrs",new  Pqrs());
		return "contacto";
	}
	
	
	@PostMapping("/guardarPqrs")
    public String guardarpqrs(@Valid Pqrs pqrs ,BindingResult result , Model model, Usuario usuario,RedirectAttributes attribute) {
		Usuario validar = usuarioRepositorio.findByidusuario(usuario.getIdusuario());
		if(result.hasErrors())
		{
			System.out.println("hubo errores");
			return"redirect:/registrarpqrs";
		}
		if (validar==null) {
			return "redirect:/contacto";
		}	else {
			pqrsImp.crearPqrs(pqrs);
			attribute.addFlashAttribute("success", "pqrs guardado con exito");
		}
    return "redirect:/registrarpqrs";
   }
    
	@GetMapping("/responderpqrs")
    public String respuetsa(Pqrs pqrs){
		return "respqrs";
	}

}
